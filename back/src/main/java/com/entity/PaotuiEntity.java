package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 跑腿
 *
 * @author 
 * @email
 */
@TableName("paotui")
public class PaotuiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PaotuiEntity() {

	}

	public PaotuiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 跑腿名称
     */
    @ColumnInfo(comment="跑腿名称",type="varchar(200)")
    @TableField(value = "paotui_name")

    private String paotuiName;


    /**
     * 跑腿编号
     */
    @ColumnInfo(comment="跑腿编号",type="varchar(200)")
    @TableField(value = "paotui_uuid_number")

    private String paotuiUuidNumber;


    /**
     * 跑腿照片
     */
    @ColumnInfo(comment="跑腿照片",type="varchar(200)")
    @TableField(value = "paotui_photo")

    private String paotuiPhoto;


    /**
     * 跑腿地点
     */
    @ColumnInfo(comment="跑腿地点",type="varchar(200)")
    @TableField(value = "paotui_address")

    private String paotuiAddress;


    /**
     * 跑腿类型
     */
    @ColumnInfo(comment="跑腿类型",type="int(11)")
    @TableField(value = "paotui_types")

    private Integer paotuiTypes;


    /**
     * 现价/积分
     */
    @ColumnInfo(comment="现价/积分",type="decimal(10,2)")
    @TableField(value = "paotui_new_money")

    private Double paotuiNewMoney;


    /**
     * 跑腿介绍
     */
    @ColumnInfo(comment="跑腿介绍",type="longtext")
    @TableField(value = "paotui_content")

    private String paotuiContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "paotui_delete")

    private Integer paotuiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：跑腿名称
	 */
    public String getPaotuiName() {
        return paotuiName;
    }
    /**
	 * 设置：跑腿名称
	 */

    public void setPaotuiName(String paotuiName) {
        this.paotuiName = paotuiName;
    }
    /**
	 * 获取：跑腿编号
	 */
    public String getPaotuiUuidNumber() {
        return paotuiUuidNumber;
    }
    /**
	 * 设置：跑腿编号
	 */

    public void setPaotuiUuidNumber(String paotuiUuidNumber) {
        this.paotuiUuidNumber = paotuiUuidNumber;
    }
    /**
	 * 获取：跑腿照片
	 */
    public String getPaotuiPhoto() {
        return paotuiPhoto;
    }
    /**
	 * 设置：跑腿照片
	 */

    public void setPaotuiPhoto(String paotuiPhoto) {
        this.paotuiPhoto = paotuiPhoto;
    }
    /**
	 * 获取：跑腿地点
	 */
    public String getPaotuiAddress() {
        return paotuiAddress;
    }
    /**
	 * 设置：跑腿地点
	 */

    public void setPaotuiAddress(String paotuiAddress) {
        this.paotuiAddress = paotuiAddress;
    }
    /**
	 * 获取：跑腿类型
	 */
    public Integer getPaotuiTypes() {
        return paotuiTypes;
    }
    /**
	 * 设置：跑腿类型
	 */

    public void setPaotuiTypes(Integer paotuiTypes) {
        this.paotuiTypes = paotuiTypes;
    }
    /**
	 * 获取：现价/积分
	 */
    public Double getPaotuiNewMoney() {
        return paotuiNewMoney;
    }
    /**
	 * 设置：现价/积分
	 */

    public void setPaotuiNewMoney(Double paotuiNewMoney) {
        this.paotuiNewMoney = paotuiNewMoney;
    }
    /**
	 * 获取：跑腿介绍
	 */
    public String getPaotuiContent() {
        return paotuiContent;
    }
    /**
	 * 设置：跑腿介绍
	 */

    public void setPaotuiContent(String paotuiContent) {
        this.paotuiContent = paotuiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getPaotuiDelete() {
        return paotuiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setPaotuiDelete(Integer paotuiDelete) {
        this.paotuiDelete = paotuiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Paotui{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", paotuiName=" + paotuiName +
            ", paotuiUuidNumber=" + paotuiUuidNumber +
            ", paotuiPhoto=" + paotuiPhoto +
            ", paotuiAddress=" + paotuiAddress +
            ", paotuiTypes=" + paotuiTypes +
            ", paotuiNewMoney=" + paotuiNewMoney +
            ", paotuiContent=" + paotuiContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", paotuiDelete=" + paotuiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
