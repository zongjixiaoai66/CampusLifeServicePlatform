package com.entity.model;

import com.entity.PaotuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 跑腿
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PaotuiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 跑腿名称
     */
    private String paotuiName;


    /**
     * 跑腿编号
     */
    private String paotuiUuidNumber;


    /**
     * 跑腿照片
     */
    private String paotuiPhoto;


    /**
     * 跑腿地点
     */
    private String paotuiAddress;


    /**
     * 跑腿类型
     */
    private Integer paotuiTypes;


    /**
     * 现价/积分
     */
    private Double paotuiNewMoney;


    /**
     * 跑腿介绍
     */
    private String paotuiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer paotuiDelete;


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
