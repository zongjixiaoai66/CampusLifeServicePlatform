package com.entity.model;

import com.entity.PaotuiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 跑腿接单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PaotuiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 接单编号
     */
    private String paotuiOrderUuidNumber;


    /**
     * 跑腿
     */
    private Integer paotuiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double paotuiOrderTruePrice;


    /**
     * 接单类型
     */
    private Integer paotuiOrderTypes;


    /**
     * 接单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：接单编号
	 */
    public String getPaotuiOrderUuidNumber() {
        return paotuiOrderUuidNumber;
    }


    /**
	 * 设置：接单编号
	 */
    public void setPaotuiOrderUuidNumber(String paotuiOrderUuidNumber) {
        this.paotuiOrderUuidNumber = paotuiOrderUuidNumber;
    }
    /**
	 * 获取：跑腿
	 */
    public Integer getPaotuiId() {
        return paotuiId;
    }


    /**
	 * 设置：跑腿
	 */
    public void setPaotuiId(Integer paotuiId) {
        this.paotuiId = paotuiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getPaotuiOrderTruePrice() {
        return paotuiOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setPaotuiOrderTruePrice(Double paotuiOrderTruePrice) {
        this.paotuiOrderTruePrice = paotuiOrderTruePrice;
    }
    /**
	 * 获取：接单类型
	 */
    public Integer getPaotuiOrderTypes() {
        return paotuiOrderTypes;
    }


    /**
	 * 设置：接单类型
	 */
    public void setPaotuiOrderTypes(Integer paotuiOrderTypes) {
        this.paotuiOrderTypes = paotuiOrderTypes;
    }
    /**
	 * 获取：接单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：接单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
