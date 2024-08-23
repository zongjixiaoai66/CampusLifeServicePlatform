package com.entity.model;

import com.entity.WenyuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 文娱活动
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WenyuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 活动名称
     */
    private String wenyuName;


    /**
     * 活动编号
     */
    private String wenyuUuidNumber;


    /**
     * 活动照片
     */
    private String wenyuPhoto;


    /**
     * 活动地点
     */
    private String wenyuAddress;


    /**
     * 活动类型
     */
    private Integer wenyuTypes;


    /**
     * 活动人数
     */
    private Integer wenyuKucunNumber;


    /**
     * 活动介绍
     */
    private String wenyuContent;


    /**
     * 逻辑删除
     */
    private Integer wenyuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
