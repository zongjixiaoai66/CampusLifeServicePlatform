
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
 * 商品订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wenyuOrder")
public class WenyuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(WenyuOrderController.class);

    private static final String TABLE_NAME = "wenyuOrder";

    @Autowired
    private WenyuOrderService wenyuOrderService;


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
    private WenyuService wenyuService;//文娱活动
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
        CommonUtil.checkMap(params);
        PageUtils page = wenyuOrderService.queryPage(params);

        //字典表数据转换
        List<WenyuOrderView> list =(List<WenyuOrderView>)page.getList();
        for(WenyuOrderView c:list){
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
        WenyuOrderEntity wenyuOrder = wenyuOrderService.selectById(id);
        if(wenyuOrder !=null){
            //entity转view
            WenyuOrderView view = new WenyuOrderView();
            BeanUtils.copyProperties( wenyuOrder , view );//把实体数据重构到view中
            //级联表 文娱活动
            //级联表
            WenyuEntity wenyu = wenyuService.selectById(wenyuOrder.getWenyuId());
            if(wenyu != null){
            BeanUtils.copyProperties( wenyu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWenyuId(wenyu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wenyuOrder.getYonghuId());
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
    public R save(@RequestBody WenyuOrderEntity wenyuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wenyuOrder:{}",this.getClass().getName(),wenyuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wenyuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        wenyuOrder.setCreateTime(new Date());
        wenyuOrder.setInsertTime(new Date());
        wenyuOrderService.insert(wenyuOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WenyuOrderEntity wenyuOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wenyuOrder:{}",this.getClass().getName(),wenyuOrder.toString());
        WenyuOrderEntity oldWenyuOrderEntity = wenyuOrderService.selectById(wenyuOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wenyuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wenyuOrderService.updateById(wenyuOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WenyuOrderEntity> oldWenyuOrderList =wenyuOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wenyuOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<WenyuOrderEntity> wenyuOrderList = new ArrayList<>();//上传的东西
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
                            WenyuOrderEntity wenyuOrderEntity = new WenyuOrderEntity();
//                            wenyuOrderEntity.setWenyuOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            wenyuOrderEntity.setWenyuId(Integer.valueOf(data.get(0)));   //文娱活动 要改的
//                            wenyuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wenyuOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            wenyuOrderEntity.setWenyuOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            wenyuOrderEntity.setInsertTime(date);//时间
//                            wenyuOrderEntity.setCreateTime(date);//时间
                            wenyuOrderList.add(wenyuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("wenyuOrderUuidNumber")){
                                    List<String> wenyuOrderUuidNumber = seachFields.get("wenyuOrderUuidNumber");
                                    wenyuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wenyuOrderUuidNumber = new ArrayList<>();
                                    wenyuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wenyuOrderUuidNumber",wenyuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<WenyuOrderEntity> wenyuOrderEntities_wenyuOrderUuidNumber = wenyuOrderService.selectList(new EntityWrapper<WenyuOrderEntity>().in("wenyu_order_uuid_number", seachFields.get("wenyuOrderUuidNumber")));
                        if(wenyuOrderEntities_wenyuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WenyuOrderEntity s:wenyuOrderEntities_wenyuOrderUuidNumber){
                                repeatFields.add(s.getWenyuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wenyuOrderService.insertBatch(wenyuOrderList);
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
        PageUtils page = wenyuOrderService.queryPage(params);

        //字典表数据转换
        List<WenyuOrderView> list =(List<WenyuOrderView>)page.getList();
        for(WenyuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WenyuOrderEntity wenyuOrder = wenyuOrderService.selectById(id);
            if(wenyuOrder !=null){


                //entity转view
                WenyuOrderView view = new WenyuOrderView();
                BeanUtils.copyProperties( wenyuOrder , view );//把实体数据重构到view中

                //级联表
                    WenyuEntity wenyu = wenyuService.selectById(wenyuOrder.getWenyuId());
                if(wenyu != null){
                    BeanUtils.copyProperties( wenyu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWenyuId(wenyu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(wenyuOrder.getYonghuId());
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
    public R add(@RequestBody WenyuOrderEntity wenyuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wenyuOrder:{}",this.getClass().getName(),wenyuOrder.toString());
            WenyuEntity wenyuEntity = wenyuService.selectById(wenyuOrder.getWenyuId());
            if(wenyuEntity == null){
                return R.error(511,"查不到该文娱活动");
            }
            // Double wenyuNewMoney = wenyuEntity.getWenyuNewMoney();

            if(false){
            }
            else if((wenyuEntity.getWenyuKucunNumber() -wenyuOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            wenyuOrder.setWenyuOrderTypes(101); //设置订单状态为已报名
            wenyuOrder.setYonghuId(userId); //设置订单支付人id
            wenyuOrder.setWenyuOrderUuidNumber(String.valueOf(new Date().getTime()));
            wenyuOrder.setInsertTime(new Date());
            wenyuOrder.setCreateTime(new Date());
                wenyuEntity.setWenyuKucunNumber( wenyuEntity.getWenyuKucunNumber() -wenyuOrder.getBuyNumber());
                wenyuService.updateById(wenyuEntity);
                wenyuOrderService.insert(wenyuOrder);//新增订单
            //更新第一注册表
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 取消报名
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            WenyuOrderEntity wenyuOrder = wenyuOrderService.selectById(id);//当前表service
            Integer buyNumber = wenyuOrder.getBuyNumber();
            Integer wenyuId = wenyuOrder.getWenyuId();
            if(wenyuId == null)
                return R.error(511,"查不到该文娱活动");
            WenyuEntity wenyuEntity = wenyuService.selectById(wenyuId);
            if(wenyuEntity == null)
                return R.error(511,"查不到该文娱活动");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                //计算所获得积分
                Double buyJifen = 0.0;



            wenyuEntity.setWenyuKucunNumber(wenyuEntity.getWenyuKucunNumber() + buyNumber);


            wenyuOrder.setWenyuOrderTypes(102);//设置订单状态为已取消报名
            wenyuOrderService.updateById(wenyuOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            wenyuService.updateById(wenyuEntity);//更新订单中文娱活动的信息

            return R.ok();
    }

}

