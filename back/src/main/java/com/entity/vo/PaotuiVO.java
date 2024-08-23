package com.entity.vo;

import com.entity.PaotuiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 跑腿
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("paotui")
public class PaotuiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 跑腿名称
     */

    @TableField(value = "paotui_name")
    private String paotuiName;


    /**
     * 跑腿编号
     */

    @TableField(value = "paotui_uuid_number")
    private String paotuiUuidNumber;


    /**
     * 跑腿照片
     */

    @TableField(value = "paotui_photo")
    private String paotuiPhoto;


    /**
     * 跑腿地点
     */

    @TableField(value = "paotui_address")
    private String paotuiAddress;


    /**
     * 跑腿类型
     */

    @TableField(value = "paotui_types")
    private Integer paotuiTypes;


    /**
     * 现价/积分
     */

    @TableField(value = "paotui_new_money")
    private Double paotuiNewMoney;


    /**
     * 跑腿介绍
     */

    @TableField(value = "paotui_content")
    private String paotuiContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "paotui_delete")
    private Integer paotuiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：跑腿名称
	 */
    public String getPaotuiName() {
        return paotuiName;
    }


    /**
	 * 获取：跑腿名称
	 */

    public void setPaotuiName(String paotuiName) {
        this.paotuiName = paotuiName;
    }
    /**
	 * 设置：跑腿编号
	 */
    public String getPaotuiUuidNumber() {
        return paotuiUuidNumber;
    }


    /**
	 * 获取：跑腿编号
	 */

    public void setPaotuiUuidNumber(String paotuiUuidNumber) {
        this.paotuiUuidNumber = paotuiUuidNumber;
    }
    /**
	 * 设置：跑腿照片
	 */
    public String getPaotuiPhoto() {
        return paotuiPhoto;
    }


    /**
	 * 获取：跑腿照片
	 */

    public void setPaotuiPhoto(String paotuiPhoto) {
        this.paotuiPhoto = paotuiPhoto;
    }
    /**
	 * 设置：跑腿地点
	 */
    public String getPaotuiAddress() {
        return paotuiAddress;
    }


    /**
	 * 获取：跑腿地点
	 */

    public void setPaotuiAddress(String paotuiAddress) {
        this.paotuiAddress = paotuiAddress;
    }
    /**
	 * 设置：跑腿类型
	 */
    public Integer getPaotuiTypes() {
        return paotuiTypes;
    }


    /**
	 * 获取：跑腿类型
	 */

    public void setPaotuiTypes(Integer paotuiTypes) {
        this.paotuiTypes = paotuiTypes;
    }
    /**
	 * 设置：现价/积分
	 */
    public Double getPaotuiNewMoney() {
        return paotuiNewMoney;
    }


    /**
	 * 获取：现价/积分
	 */

    public void setPaotuiNewMoney(Double paotuiNewMoney) {
        this.paotuiNewMoney = paotuiNewMoney;
    }
    /**
	 * 设置：跑腿介绍
	 */
    public String getPaotuiContent() {
        return paotuiContent;
    }


    /**
	 * 获取：跑腿介绍
	 */

    public void setPaotuiContent(String paotuiContent) {
        this.paotuiContent = paotuiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getPaotuiDelete() {
        return paotuiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setPaotuiDelete(Integer paotuiDelete) {
        this.paotuiDelete = paotuiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
