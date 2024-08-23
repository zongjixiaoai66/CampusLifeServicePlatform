package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.PaotuiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 跑腿接单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("paotui_order")
public class PaotuiOrderView extends PaotuiOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 接单类型的值
	*/
	@ColumnInfo(comment="接单类型的字典表值",type="varchar(200)")
	private String paotuiOrderValue;

	//级联表 跑腿
					 
		/**
		* 跑腿 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer paotuiYonghuId;
		/**
		* 跑腿名称
		*/

		@ColumnInfo(comment="跑腿名称",type="varchar(200)")
		private String paotuiName;
		/**
		* 跑腿编号
		*/

		@ColumnInfo(comment="跑腿编号",type="varchar(200)")
		private String paotuiUuidNumber;
		/**
		* 跑腿照片
		*/

		@ColumnInfo(comment="跑腿照片",type="varchar(200)")
		private String paotuiPhoto;
		/**
		* 跑腿地点
		*/

		@ColumnInfo(comment="跑腿地点",type="varchar(200)")
		private String paotuiAddress;
		/**
		* 跑腿类型
		*/
		@ColumnInfo(comment="跑腿类型",type="int(11)")
		private Integer paotuiTypes;
			/**
			* 跑腿类型的值
			*/
			@ColumnInfo(comment="跑腿类型的字典表值",type="varchar(200)")
			private String paotuiValue;
		/**
		* 现价/积分
		*/
		@ColumnInfo(comment="现价/积分",type="decimal(10,2)")
		private Double paotuiNewMoney;
		/**
		* 跑腿介绍
		*/

		@ColumnInfo(comment="跑腿介绍",type="longtext")
		private String paotuiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer paotuiDelete;
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



	public PaotuiOrderView() {

	}

	public PaotuiOrderView(PaotuiOrderEntity paotuiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, paotuiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 接单类型的值
	*/
	public String getPaotuiOrderValue() {
		return paotuiOrderValue;
	}
	/**
	* 设置： 接单类型的值
	*/
	public void setPaotuiOrderValue(String paotuiOrderValue) {
		this.paotuiOrderValue = paotuiOrderValue;
	}


	//级联表的get和set 跑腿
		/**
		* 获取：跑腿 的 用户
		*/
		public Integer getPaotuiYonghuId() {
			return paotuiYonghuId;
		}
		/**
		* 设置：跑腿 的 用户
		*/
		public void setPaotuiYonghuId(Integer paotuiYonghuId) {
			this.paotuiYonghuId = paotuiYonghuId;
		}

		/**
		* 获取： 跑腿名称
		*/
		public String getPaotuiName() {
			return paotuiName;
		}
		/**
		* 设置： 跑腿名称
		*/
		public void setPaotuiName(String paotuiName) {
			this.paotuiName = paotuiName;
		}

		/**
		* 获取： 跑腿编号
		*/
		public String getPaotuiUuidNumber() {
			return paotuiUuidNumber;
		}
		/**
		* 设置： 跑腿编号
		*/
		public void setPaotuiUuidNumber(String paotuiUuidNumber) {
			this.paotuiUuidNumber = paotuiUuidNumber;
		}

		/**
		* 获取： 跑腿照片
		*/
		public String getPaotuiPhoto() {
			return paotuiPhoto;
		}
		/**
		* 设置： 跑腿照片
		*/
		public void setPaotuiPhoto(String paotuiPhoto) {
			this.paotuiPhoto = paotuiPhoto;
		}

		/**
		* 获取： 跑腿地点
		*/
		public String getPaotuiAddress() {
			return paotuiAddress;
		}
		/**
		* 设置： 跑腿地点
		*/
		public void setPaotuiAddress(String paotuiAddress) {
			this.paotuiAddress = paotuiAddress;
		}
		/**
		* 获取： 跑腿类型
		*/
		public Integer getPaotuiTypes() {
			return paotuiTypes;
		}
		/**
		* 设置： 跑腿类型
		*/
		public void setPaotuiTypes(Integer paotuiTypes) {
			this.paotuiTypes = paotuiTypes;
		}


			/**
			* 获取： 跑腿类型的值
			*/
			public String getPaotuiValue() {
				return paotuiValue;
			}
			/**
			* 设置： 跑腿类型的值
			*/
			public void setPaotuiValue(String paotuiValue) {
				this.paotuiValue = paotuiValue;
			}

		/**
		* 获取： 现价/积分
		*/
		public Double getPaotuiNewMoney() {
			return paotuiNewMoney;
		}
		/**
		* 设置： 现价/积分
		*/
		public void setPaotuiNewMoney(Double paotuiNewMoney) {
			this.paotuiNewMoney = paotuiNewMoney;
		}

		/**
		* 获取： 跑腿介绍
		*/
		public String getPaotuiContent() {
			return paotuiContent;
		}
		/**
		* 设置： 跑腿介绍
		*/
		public void setPaotuiContent(String paotuiContent) {
			this.paotuiContent = paotuiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getPaotuiDelete() {
			return paotuiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setPaotuiDelete(Integer paotuiDelete) {
			this.paotuiDelete = paotuiDelete;
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
		return "PaotuiOrderView{" +
			", paotuiOrderValue=" + paotuiOrderValue +
			", paotuiName=" + paotuiName +
			", paotuiUuidNumber=" + paotuiUuidNumber +
			", paotuiPhoto=" + paotuiPhoto +
			", paotuiAddress=" + paotuiAddress +
			", paotuiNewMoney=" + paotuiNewMoney +
			", paotuiContent=" + paotuiContent +
			", paotuiDelete=" + paotuiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
