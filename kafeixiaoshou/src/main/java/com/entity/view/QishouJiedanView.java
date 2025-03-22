package com.entity.view;

import com.entity.QishouJiedanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 骑手接单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("qishou_jiedan")
public class QishouJiedanView extends QishouJiedanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 送单状态的值
		*/
		private String qishouJiedanValue;



		//级联表 goods_order
			/**
			* 订单号
			*/
			private String goodsOrderUuidNumber;
			/**
			* 购买的数量
			*/
			private Integer buyNumber;
			/**
			* 实付价格
			*/
			private Double goodsOrderTruePrice;
			/**
			* 订单类型
			*/
			private Integer goodsOrderTypes;
				/**
				* 订单类型的值
				*/
				private String goodsOrderValue;
			/**
			* 支付类型
			*/
			private Integer goodsOrderPaymentTypes;
				/**
				* 支付类型的值
				*/
				private String goodsOrderPaymentValue;

		//级联表 qishou
			/**
			* 骑手姓名
			*/
			private String qishouName;
			/**
			* 头像
			*/
			private String qishouPhoto;
			/**
			* 骑手手机号
			*/
			private String qishouPhone;
			/**
			* 骑手身份证号
			*/
			private String qishouIdNumber;
			/**
			* 假删
			*/
			private Integer qishouDelete;

	public QishouJiedanView() {

	}

	public QishouJiedanView(QishouJiedanEntity qishouJiedanEntity) {
		try {
			BeanUtils.copyProperties(this, qishouJiedanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 送单状态的值
			*/
			public String getQishouJiedanValue() {
				return qishouJiedanValue;
			}
			/**
			* 设置： 送单状态的值
			*/
			public void setQishouJiedanValue(String qishouJiedanValue) {
				this.qishouJiedanValue = qishouJiedanValue;
			}























				//级联表的get和set goods_order
					/**
					* 获取： 订单号
					*/
					public String getGoodsOrderUuidNumber() {
						return goodsOrderUuidNumber;
					}
					/**
					* 设置： 订单号
					*/
					public void setGoodsOrderUuidNumber(String goodsOrderUuidNumber) {
						this.goodsOrderUuidNumber = goodsOrderUuidNumber;
					}
					/**
					* 获取： 购买的数量
					*/
					public Integer getBuyNumber() {
						return buyNumber;
					}
					/**
					* 设置： 购买的数量
					*/
					public void setBuyNumber(Integer buyNumber) {
						this.buyNumber = buyNumber;
					}
					/**
					* 获取： 实付价格
					*/
					public Double getGoodsOrderTruePrice() {
						return goodsOrderTruePrice;
					}
					/**
					* 设置： 实付价格
					*/
					public void setGoodsOrderTruePrice(Double goodsOrderTruePrice) {
						this.goodsOrderTruePrice = goodsOrderTruePrice;
					}
					/**
					* 获取： 订单类型
					*/
					public Integer getGoodsOrderTypes() {
						return goodsOrderTypes;
					}
					/**
					* 设置： 订单类型
					*/
					public void setGoodsOrderTypes(Integer goodsOrderTypes) {
						this.goodsOrderTypes = goodsOrderTypes;
					}


						/**
						* 获取： 订单类型的值
						*/
						public String getGoodsOrderValue() {
							return goodsOrderValue;
						}
						/**
						* 设置： 订单类型的值
						*/
						public void setGoodsOrderValue(String goodsOrderValue) {
							this.goodsOrderValue = goodsOrderValue;
						}
					/**
					* 获取： 支付类型
					*/
					public Integer getGoodsOrderPaymentTypes() {
						return goodsOrderPaymentTypes;
					}
					/**
					* 设置： 支付类型
					*/
					public void setGoodsOrderPaymentTypes(Integer goodsOrderPaymentTypes) {
						this.goodsOrderPaymentTypes = goodsOrderPaymentTypes;
					}


						/**
						* 获取： 支付类型的值
						*/
						public String getGoodsOrderPaymentValue() {
							return goodsOrderPaymentValue;
						}
						/**
						* 设置： 支付类型的值
						*/
						public void setGoodsOrderPaymentValue(String goodsOrderPaymentValue) {
							this.goodsOrderPaymentValue = goodsOrderPaymentValue;
						}





				//级联表的get和set qishou
					/**
					* 获取： 骑手姓名
					*/
					public String getQishouName() {
						return qishouName;
					}
					/**
					* 设置： 骑手姓名
					*/
					public void setQishouName(String qishouName) {
						this.qishouName = qishouName;
					}
					/**
					* 获取： 头像
					*/
					public String getQishouPhoto() {
						return qishouPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setQishouPhoto(String qishouPhoto) {
						this.qishouPhoto = qishouPhoto;
					}
					/**
					* 获取： 骑手手机号
					*/
					public String getQishouPhone() {
						return qishouPhone;
					}
					/**
					* 设置： 骑手手机号
					*/
					public void setQishouPhone(String qishouPhone) {
						this.qishouPhone = qishouPhone;
					}
					/**
					* 获取： 骑手身份证号
					*/
					public String getQishouIdNumber() {
						return qishouIdNumber;
					}
					/**
					* 设置： 骑手身份证号
					*/
					public void setQishouIdNumber(String qishouIdNumber) {
						this.qishouIdNumber = qishouIdNumber;
					}
					/**
					* 获取： 假删
					*/
					public Integer getQishouDelete() {
						return qishouDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setQishouDelete(Integer qishouDelete) {
						this.qishouDelete = qishouDelete;
					}













}
