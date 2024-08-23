package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WenyuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 商品订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wenyu_order")
public class WenyuOrderView extends WenyuOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String wenyuOrderValue;

	//级联表 文娱活动
		/**
		* 活动名称
		*/

		@ColumnInfo(comment="活动名称",type="varchar(200)")
		private String wenyuName;
		/**
		* 活动编号
		*/

		@ColumnInfo(comment="活动编号",type="varchar(200)")
		private String wenyuUuidNumber;
		/**
		* 活动照片
		*/

		@ColumnInfo(comment="活动照片",type="varchar(200)")
		private String wenyuPhoto;
		/**
		* 活动地点
		*/

		@ColumnInfo(comment="活动地点",type="varchar(200)")
		private String wenyuAddress;
		/**
		* 活动类型
		*/
		@ColumnInfo(comment="活动类型",type="int(11)")
		private Integer wenyuTypes;
			/**
			* 活动类型的值
			*/
			@ColumnInfo(comment="活动类型的字典表值",type="varchar(200)")
			private String wenyuValue;
		/**
		* 活动人数
		*/

		@ColumnInfo(comment="活动人数",type="int(11)")
		private Integer wenyuKucunNumber;
		/**
		* 活动介绍
		*/

		@ColumnInfo(comment="活动介绍",type="longtext")
		private String wenyuContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer wenyuDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public WenyuOrderView() {

	}

	public WenyuOrderView(WenyuOrderEntity wenyuOrderEntity) {
		try {
			BeanUtils.copyProperties(this, wenyuOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getWenyuOrderValue() {
		return wenyuOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setWenyuOrderValue(String wenyuOrderValue) {
		this.wenyuOrderValue = wenyuOrderValue;
	}


	//级联表的get和set 文娱活动

		/**
		* 获取： 活动名称
		*/
		public String getWenyuName() {
			return wenyuName;
		}
		/**
		* 设置： 活动名称
		*/
		public void setWenyuName(String wenyuName) {
			this.wenyuName = wenyuName;
		}

		/**
		* 获取： 活动编号
		*/
		public String getWenyuUuidNumber() {
			return wenyuUuidNumber;
		}
		/**
		* 设置： 活动编号
		*/
		public void setWenyuUuidNumber(String wenyuUuidNumber) {
			this.wenyuUuidNumber = wenyuUuidNumber;
		}

		/**
		* 获取： 活动照片
		*/
		public String getWenyuPhoto() {
			return wenyuPhoto;
		}
		/**
		* 设置： 活动照片
		*/
		public void setWenyuPhoto(String wenyuPhoto) {
			this.wenyuPhoto = wenyuPhoto;
		}

		/**
		* 获取： 活动地点
		*/
		public String getWenyuAddress() {
			return wenyuAddress;
		}
		/**
		* 设置： 活动地点
		*/
		public void setWenyuAddress(String wenyuAddress) {
			this.wenyuAddress = wenyuAddress;
		}
		/**
		* 获取： 活动类型
		*/
		public Integer getWenyuTypes() {
			return wenyuTypes;
		}
		/**
		* 设置： 活动类型
		*/
		public void setWenyuTypes(Integer wenyuTypes) {
			this.wenyuTypes = wenyuTypes;
		}


			/**
			* 获取： 活动类型的值
			*/
			public String getWenyuValue() {
				return wenyuValue;
			}
			/**
			* 设置： 活动类型的值
			*/
			public void setWenyuValue(String wenyuValue) {
				this.wenyuValue = wenyuValue;
			}

		/**
		* 获取： 活动人数
		*/
		public Integer getWenyuKucunNumber() {
			return wenyuKucunNumber;
		}
		/**
		* 设置： 活动人数
		*/
		public void setWenyuKucunNumber(Integer wenyuKucunNumber) {
			this.wenyuKucunNumber = wenyuKucunNumber;
		}

		/**
		* 获取： 活动介绍
		*/
		public String getWenyuContent() {
			return wenyuContent;
		}
		/**
		* 设置： 活动介绍
		*/
		public void setWenyuContent(String wenyuContent) {
			this.wenyuContent = wenyuContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getWenyuDelete() {
			return wenyuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setWenyuDelete(Integer wenyuDelete) {
			this.wenyuDelete = wenyuDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "WenyuOrderView{" +
			", wenyuOrderValue=" + wenyuOrderValue +
			", wenyuName=" + wenyuName +
			", wenyuUuidNumber=" + wenyuUuidNumber +
			", wenyuPhoto=" + wenyuPhoto +
			", wenyuAddress=" + wenyuAddress +
			", wenyuKucunNumber=" + wenyuKucunNumber +
			", wenyuContent=" + wenyuContent +
			", wenyuDelete=" + wenyuDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
