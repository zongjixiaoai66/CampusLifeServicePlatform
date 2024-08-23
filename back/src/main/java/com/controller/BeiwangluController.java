
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 备忘录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/beiwanglu")
public class BeiwangluController {
    private static final Logger logger = LoggerFactory.getLogger(BeiwangluController.class);

    private static final String TABLE_NAME = "beiwanglu";

    @Autowired
    private BeiwangluService beiwangluService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//分享大厅
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private HuodongYuyueService huodongYuyueService;//活动申请
    @Autowired
    private PaotuiService paotuiService;//跑腿
    @Autowired
    private PaotuiOrderService paotuiOrderService;//跑腿接单
    @Autowired
    private WenyuService wenyuService;//文娱活动
    @Autowired
    private WenyuOrderService wenyuOrderService;//商品订单
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("beiwangluDeleteStart",1);params.put("beiwangluDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = beiwangluService.queryPage(params);

        //字典表数据转换
        List<BeiwangluView> list =(List<BeiwangluView>)page.getList();
        for(BeiwangluView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BeiwangluEntity beiwanglu = beiwangluService.selectById(id);
        if(beiwanglu !=null){
            //entity转view
            BeiwangluView view = new BeiwangluView();
            BeanUtils.copyProperties( beiwanglu , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BeiwangluEntity beiwanglu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,beiwanglu:{}",this.getClass().getName(),beiwanglu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<BeiwangluEntity> queryWrapper = new EntityWrapper<BeiwangluEntity>()
            .eq("beiwanglu_name", beiwanglu.getBeiwangluName())
            .eq("beiwanglu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BeiwangluEntity beiwangluEntity = beiwangluService.selectOne(queryWrapper);
        if(beiwangluEntity==null){
            beiwanglu.setBeiwangluDelete(1);
            beiwanglu.setInsertTime(new Date());
            beiwanglu.setCreateTime(new Date());
            beiwangluService.insert(beiwanglu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BeiwangluEntity beiwanglu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,beiwanglu:{}",this.getClass().getName(),beiwanglu.toString());
        BeiwangluEntity oldBeiwangluEntity = beiwangluService.selectById(beiwanglu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");

            beiwangluService.updateById(beiwanglu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BeiwangluEntity> oldBeiwangluList =beiwangluService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<BeiwangluEntity> list = new ArrayList<>();
        for(Integer id:ids){
            BeiwangluEntity beiwangluEntity = new BeiwangluEntity();
            beiwangluEntity.setId(id);
            beiwangluEntity.setBeiwangluDelete(2);
            list.add(beiwangluEntity);
        }
        if(list != null && list.size() >0){
            beiwangluService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<BeiwangluEntity> beiwangluList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BeiwangluEntity beiwangluEntity = new BeiwangluEntity();
//                            beiwangluEntity.setBeiwangluName(data.get(0));                    //备忘录名称 要改的
//                            beiwangluEntity.setBeiwangluUuidNumber(data.get(0));                    //备忘录编号 要改的
//                            beiwangluEntity.setBeiwangluContent("");//详情和图片
//                            beiwangluEntity.setBeiwangluDelete(1);//逻辑删除字段
//                            beiwangluEntity.setInsertTime(date);//时间
//                            beiwangluEntity.setCreateTime(date);//时间
                            beiwangluList.add(beiwangluEntity);


                            //把要查询是否重复的字段放入map中
                                //备忘录编号
                                if(seachFields.containsKey("beiwangluUuidNumber")){
                                    List<String> beiwangluUuidNumber = seachFields.get("beiwangluUuidNumber");
                                    beiwangluUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> beiwangluUuidNumber = new ArrayList<>();
                                    beiwangluUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("beiwangluUuidNumber",beiwangluUuidNumber);
                                }
                        }

                        //查询是否重复
                         //备忘录编号
                        List<BeiwangluEntity> beiwangluEntities_beiwangluUuidNumber = beiwangluService.selectList(new EntityWrapper<BeiwangluEntity>().in("beiwanglu_uuid_number", seachFields.get("beiwangluUuidNumber")).eq("beiwanglu_delete", 1));
                        if(beiwangluEntities_beiwangluUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BeiwangluEntity s:beiwangluEntities_beiwangluUuidNumber){
                                repeatFields.add(s.getBeiwangluUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [备忘录编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        beiwangluService.insertBatch(beiwangluList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = beiwangluService.queryPage(params);

        //字典表数据转换
        List<BeiwangluView> list =(List<BeiwangluView>)page.getList();
        for(BeiwangluView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BeiwangluEntity beiwanglu = beiwangluService.selectById(id);
            if(beiwanglu !=null){


                //entity转view
                BeiwangluView view = new BeiwangluView();
                BeanUtils.copyProperties( beiwanglu , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody BeiwangluEntity beiwanglu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,beiwanglu:{}",this.getClass().getName(),beiwanglu.toString());
        Wrapper<BeiwangluEntity> queryWrapper = new EntityWrapper<BeiwangluEntity>()
            .eq("beiwanglu_name", beiwanglu.getBeiwangluName())
            .eq("beiwanglu_uuid_number", beiwanglu.getBeiwangluUuidNumber())
            .eq("beiwanglu_delete", beiwanglu.getBeiwangluDelete())
//            .notIn("beiwanglu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BeiwangluEntity beiwangluEntity = beiwangluService.selectOne(queryWrapper);
        if(beiwangluEntity==null){
            beiwanglu.setBeiwangluDelete(1);
            beiwanglu.setInsertTime(new Date());
            beiwanglu.setCreateTime(new Date());
        beiwangluService.insert(beiwanglu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

