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
 * 文娱活动
 *
 * @author 
 * @email
 */
@TableName("wenyu")
public class WenyuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WenyuEntity() {

	}

	public WenyuEntity(T t) {
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
     * 活动名称
     */
    @ColumnInfo(comment="活动名称",type="varchar(200)")
    @TableField(value = "wenyu_name")

    private String wenyuName;


    /**
     * 活动编号
     */
    @ColumnInfo(comment="活动编号",type="varchar(200)")
    @TableField(value = "wenyu_uuid_number")

    private String wenyuUuidNumber;


    /**
     * 活动照片
     */
    @ColumnInfo(comment="活动照片",type="varchar(200)")
    @TableField(value = "wenyu_photo")

    private String wenyuPhoto;


    /**
     * 活动地点
     */
    @ColumnInfo(comment="活动地点",type="varchar(200)")
    @TableField(value = "wenyu_address")

    private String wenyuAddress;


    /**
     * 活动类型
     */
    @ColumnInfo(comment="活动类型",type="int(11)")
    @TableField(value = "wenyu_types")

    private Integer wenyuTypes;


    /**
     * 活动人数
     */
    @ColumnInfo(comment="活动人数",type="int(11)")
    @TableField(value = "wenyu_kucun_number")

    private Integer wenyuKucunNumber;


    /**
     * 活动介绍
     */
    @ColumnInfo(comment="活动介绍",type="longtext")
    @TableField(value = "wenyu_content")

    private String wenyuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "wenyu_delete")

    private Integer wenyuDelete;


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
	 * 获取：活动名称
	 */
    public String getWenyuName() {
        return wenyuName;
    }
    /**
	 * 设置：活动名称
	 */

    public void setWenyuName(String wenyuName) {
        this.wenyuName = wenyuName;
    }
    /**
	 * 获取：活动编号
	 */
    public String getWenyuUuidNumber() {
        return wenyuUuidNumber;
    }
    /**
	 * 设置：活动编号
	 */

    public void setWenyuUuidNumber(String wenyuUuidNumber) {
        this.wenyuUuidNumber = wenyuUuidNumber;
    }
    /**
	 * 获取：活动照片
	 */
    public String getWenyuPhoto() {
        return wenyuPhoto;
    }
    /**
	 * 设置：活动照片
	 */

    public void setWenyuPhoto(String wenyuPhoto) {
        this.wenyuPhoto = wenyuPhoto;
    }
    /**
	 * 获取：活动地点
	 */
    public String getWenyuAddress() {
        return wenyuAddress;
    }
    /**
	 * 设置：活动地点
	 */

    public void setWenyuAddress(String wenyuAddress) {
        this.wenyuAddress = wenyuAddress;
    }
    /**
	 * 获取：活动类型
	 */
    public Integer getWenyuTypes() {
        return wenyuTypes;
    }
    /**
	 * 设置：活动类型
	 */

    public void setWenyuTypes(Integer wenyuTypes) {
        this.wenyuTypes = wenyuTypes;
    }
    /**
	 * 获取：活动人数
	 */
    public Integer getWenyuKucunNumber() {
        return wenyuKucunNumber;
    }
    /**
	 * 设置：活动人数
	 */

    public void setWenyuKucunNumber(Integer wenyuKucunNumber) {
        this.wenyuKucunNumber = wenyuKucunNumber;
    }
    /**
	 * 获取：活动介绍
	 */
    public String getWenyuContent() {
        return wenyuContent;
    }
    /**
	 * 设置：活动介绍
	 */

    public void setWenyuContent(String wenyuContent) {
        this.wenyuContent = wenyuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getWenyuDelete() {
        return wenyuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setWenyuDelete(Integer wenyuDelete) {
        this.wenyuDelete = wenyuDelete;
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
        return "Wenyu{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", wenyuName=" + wenyuName +
            ", wenyuUuidNumber=" + wenyuUuidNumber +
            ", wenyuPhoto=" + wenyuPhoto +
            ", wenyuAddress=" + wenyuAddress +
            ", wenyuTypes=" + wenyuTypes +
            ", wenyuKucunNumber=" + wenyuKucunNumber +
            ", wenyuContent=" + wenyuContent +
            ", wenyuDelete=" + wenyuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
