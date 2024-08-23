package com.entity.vo;

import com.entity.PaotuiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 跑腿接单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("paotui_order")
public class PaotuiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 接单编号
     */

    @TableField(value = "paotui_order_uuid_number")
    private String paotuiOrderUuidNumber;


    /**
     * 跑腿
     */

    @TableField(value = "paotui_id")
    private Integer paotuiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "paotui_order_true_price")
    private Double paotuiOrderTruePrice;


    /**
     * 接单类型
     */

    @TableField(value = "paotui_order_types")
    private Integer paotuiOrderTypes;


    /**
     * 接单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：接单编号
	 */
    public String getPaotuiOrderUuidNumber() {
        return paotuiOrderUuidNumber;
    }


    /**
	 * 获取：接单编号
	 */

    public void setPaotuiOrderUuidNumber(String paotuiOrderUuidNumber) {
        this.paotuiOrderUuidNumber = paotuiOrderUuidNumber;
    }
    /**
	 * 设置：跑腿
	 */
    public Integer getPaotuiId() {
        return paotuiId;
    }


    /**
	 * 获取：跑腿
	 */

    public void setPaotuiId(Integer paotuiId) {
        this.paotuiId = paotuiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getPaotuiOrderTruePrice() {
        return paotuiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setPaotuiOrderTruePrice(Double paotuiOrderTruePrice) {
        this.paotuiOrderTruePrice = paotuiOrderTruePrice;
    }
    /**
	 * 设置：接单类型
	 */
    public Integer getPaotuiOrderTypes() {
        return paotuiOrderTypes;
    }


    /**
	 * 获取：接单类型
	 */

    public void setPaotuiOrderTypes(Integer paotuiOrderTypes) {
        this.paotuiOrderTypes = paotuiOrderTypes;
    }
    /**
	 * 设置：接单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：接单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
