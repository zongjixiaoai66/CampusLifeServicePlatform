
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
 * 文娱活动
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wenyu")
public class WenyuController {
    private static final Logger logger = LoggerFactory.getLogger(WenyuController.class);

    private static final String TABLE_NAME = "wenyu";

    @Autowired
    private WenyuService wenyuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BeiwangluService beiwangluService;//备忘录
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
    private WenyuOrderService wenyuOrderService;//文娱活动报名
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
        params.put("wenyuDeleteStart",1);params.put("wenyuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wenyuService.queryPage(params);

        //字典表数据转换
        List<WenyuView> list =(List<WenyuView>)page.getList();
        for(WenyuView c:list){
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
        WenyuEntity wenyu = wenyuService.selectById(id);
        if(wenyu !=null){
            //entity转view
            WenyuView view = new WenyuView();
            BeanUtils.copyProperties( wenyu , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wenyu.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody WenyuEntity wenyu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wenyu:{}",this.getClass().getName(),wenyu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wenyu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WenyuEntity> queryWrapper = new EntityWrapper<WenyuEntity>()
            .eq("yonghu_id", wenyu.getYonghuId())
            .eq("wenyu_name", wenyu.getWenyuName())
            .eq("wenyu_address", wenyu.getWenyuAddress())
            .eq("wenyu_types", wenyu.getWenyuTypes())
            .eq("wenyu_kucun_number", wenyu.getWenyuKucunNumber())
            .eq("wenyu_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenyuEntity wenyuEntity = wenyuService.selectOne(queryWrapper);
        if(wenyuEntity==null){
            wenyu.setWenyuDelete(1);
            wenyu.setInsertTime(new Date());
            wenyu.setCreateTime(new Date());
            wenyuService.insert(wenyu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WenyuEntity wenyu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wenyu:{}",this.getClass().getName(),wenyu.toString());
        WenyuEntity oldWenyuEntity = wenyuService.selectById(wenyu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wenyu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(wenyu.getWenyuPhoto()) || "null".equals(wenyu.getWenyuPhoto())){
                wenyu.setWenyuPhoto(null);
        }

            wenyuService.updateById(wenyu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WenyuEntity> oldWenyuList =wenyuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<WenyuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WenyuEntity wenyuEntity = new WenyuEntity();
            wenyuEntity.setId(id);
            wenyuEntity.setWenyuDelete(2);
            list.add(wenyuEntity);
        }
        if(list != null && list.size() >0){
            wenyuService.updateBatchById(list);
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
            List<WenyuEntity> wenyuList = new ArrayList<>();//上传的东西
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
                            WenyuEntity wenyuEntity = new WenyuEntity();
//                            wenyuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wenyuEntity.setWenyuName(data.get(0));                    //活动名称 要改的
//                            wenyuEntity.setWenyuUuidNumber(data.get(0));                    //活动编号 要改的
//                            wenyuEntity.setWenyuPhoto("");//详情和图片
//                            wenyuEntity.setWenyuAddress(data.get(0));                    //活动地点 要改的
//                            wenyuEntity.setWenyuTypes(Integer.valueOf(data.get(0)));   //活动类型 要改的
//                            wenyuEntity.setWenyuKucunNumber(Integer.valueOf(data.get(0)));   //活动人数 要改的
//                            wenyuEntity.setWenyuContent("");//详情和图片
//                            wenyuEntity.setWenyuDelete(1);//逻辑删除字段
//                            wenyuEntity.setInsertTime(date);//时间
//                            wenyuEntity.setCreateTime(date);//时间
                            wenyuList.add(wenyuEntity);


                            //把要查询是否重复的字段放入map中
                                //活动编号
                                if(seachFields.containsKey("wenyuUuidNumber")){
                                    List<String> wenyuUuidNumber = seachFields.get("wenyuUuidNumber");
                                    wenyuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wenyuUuidNumber = new ArrayList<>();
                                    wenyuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wenyuUuidNumber",wenyuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //活动编号
                        List<WenyuEntity> wenyuEntities_wenyuUuidNumber = wenyuService.selectList(new EntityWrapper<WenyuEntity>().in("wenyu_uuid_number", seachFields.get("wenyuUuidNumber")).eq("wenyu_delete", 1));
                        if(wenyuEntities_wenyuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WenyuEntity s:wenyuEntities_wenyuUuidNumber){
                                repeatFields.add(s.getWenyuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [活动编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wenyuService.insertBatch(wenyuList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<WenyuView> returnWenyuViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = wenyuOrderService.queryPage(params1);
        List<WenyuOrderView> orderViewsList =(List<WenyuOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(WenyuOrderView orderView:orderViewsList){
            Integer wenyuTypes = orderView.getWenyuTypes();
            if(typeMap.containsKey(wenyuTypes)){
                typeMap.put(wenyuTypes,typeMap.get(wenyuTypes)+1);
            }else{
                typeMap.put(wenyuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("wenyuTypes",type);
            PageUtils pageUtils1 = wenyuService.queryPage(params2);
            List<WenyuView> wenyuViewList =(List<WenyuView>)pageUtils1.getList();
            returnWenyuViewList.addAll(wenyuViewList);
            if(returnWenyuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = wenyuService.queryPage(params);
        if(returnWenyuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnWenyuViewList.size();//要添加的数量
            List<WenyuView> wenyuViewList =(List<WenyuView>)page.getList();
            for(WenyuView wenyuView:wenyuViewList){
                Boolean addFlag = true;
                for(WenyuView returnWenyuView:returnWenyuViewList){
                    if(returnWenyuView.getId().intValue() ==wenyuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnWenyuViewList.add(wenyuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnWenyuViewList = returnWenyuViewList.subList(0, limit);
        }

        for(WenyuView c:returnWenyuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnWenyuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wenyuService.queryPage(params);

        //字典表数据转换
        List<WenyuView> list =(List<WenyuView>)page.getList();
        for(WenyuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WenyuEntity wenyu = wenyuService.selectById(id);
            if(wenyu !=null){


                //entity转view
                WenyuView view = new WenyuView();
                BeanUtils.copyProperties( wenyu , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(wenyu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody WenyuEntity wenyu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wenyu:{}",this.getClass().getName(),wenyu.toString());
        Wrapper<WenyuEntity> queryWrapper = new EntityWrapper<WenyuEntity>()
            .eq("yonghu_id", wenyu.getYonghuId())
            .eq("wenyu_name", wenyu.getWenyuName())
            .eq("wenyu_uuid_number", wenyu.getWenyuUuidNumber())
            .eq("wenyu_address", wenyu.getWenyuAddress())
            .eq("wenyu_types", wenyu.getWenyuTypes())
            .eq("wenyu_kucun_number", wenyu.getWenyuKucunNumber())
            .eq("wenyu_delete", wenyu.getWenyuDelete())
//            .notIn("wenyu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenyuEntity wenyuEntity = wenyuService.selectOne(queryWrapper);
        if(wenyuEntity==null){
            wenyu.setWenyuDelete(1);
            wenyu.setInsertTime(new Date());
            wenyu.setCreateTime(new Date());
        wenyuService.insert(wenyu);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

