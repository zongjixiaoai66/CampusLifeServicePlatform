package com.entity.vo;

import com.entity.WenyuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 文娱活动
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wenyu")
public class WenyuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 活动名称
     */

    @TableField(value = "wenyu_name")
    private String wenyuName;


    /**
     * 活动编号
     */

    @TableField(value = "wenyu_uuid_number")
    private String wenyuUuidNumber;


    /**
     * 活动照片
     */

    @TableField(value = "wenyu_photo")
    private String wenyuPhoto;


    /**
     * 活动地点
     */

    @TableField(value = "wenyu_address")
    private String wenyuAddress;


    /**
     * 活动类型
     */

    @TableField(value = "wenyu_types")
    private Integer wenyuTypes;


    /**
     * 活动人数
     */

    @TableField(value = "wenyu_kucun_number")
    private Integer wenyuKucunNumber;


    /**
     * 活动介绍
     */

    @TableField(value = "wenyu_content")
    private String wenyuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "wenyu_delete")
    private Integer wenyuDelete;


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
	 * 设置：活动名称
	 */
    public String getWenyuName() {
        return wenyuName;
    }


    /**
	 * 获取：活动名称
	 */

    public void setWenyuName(String wenyuName) {
        this.wenyuName = wenyuName;
    }
    /**
	 * 设置：活动编号
	 */
    public String getWenyuUuidNumber() {
        return wenyuUuidNumber;
    }


    /**
	 * 获取：活动编号
	 */

    public void setWenyuUuidNumber(String wenyuUuidNumber) {
        this.wenyuUuidNumber = wenyuUuidNumber;
    }
    /**
	 * 设置：活动照片
	 */
    public String getWenyuPhoto() {
        return wenyuPhoto;
    }


    /**
	 * 获取：活动照片
	 */

    public void setWenyuPhoto(String wenyuPhoto) {
        this.wenyuPhoto = wenyuPhoto;
    }
    /**
	 * 设置：活动地点
	 */
    public String getWenyuAddress() {
        return wenyuAddress;
    }


    /**
	 * 获取：活动地点
	 */

    public void setWenyuAddress(String wenyuAddress) {
        this.wenyuAddress = wenyuAddress;
    }
    /**
	 * 设置：活动类型
	 */
    public Integer getWenyuTypes() {
        return wenyuTypes;
    }


    /**
	 * 获取：活动类型
	 */

    public void setWenyuTypes(Integer wenyuTypes) {
        this.wenyuTypes = wenyuTypes;
    }
    /**
	 * 设置：活动人数
	 */
    public Integer getWenyuKucunNumber() {
        return wenyuKucunNumber;
    }


    /**
	 * 获取：活动人数
	 */

    public void setWenyuKucunNumber(Integer wenyuKucunNumber) {
        this.wenyuKucunNumber = wenyuKucunNumber;
    }
    /**
	 * 设置：活动介绍
	 */
    public String getWenyuContent() {
        return wenyuContent;
    }


    /**
	 * 获取：活动介绍
	 */

    public void setWenyuContent(String wenyuContent) {
        this.wenyuContent = wenyuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getWenyuDelete() {
        return wenyuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setWenyuDelete(Integer wenyuDelete) {
        this.wenyuDelete = wenyuDelete;
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
