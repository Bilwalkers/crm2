package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * Orders 实体类
 * 2019-07-31 20:43:23
 */ 


public class Orders implements Serializable {
	private Integer odrId;//订单ID:主键 标识列
	private String odrCustomer;//客户名称
	private Timestamp odrDate;//下单日期
	private String odrAddr;//送货地址
	private String odrStatus;//订单状态: a 已回款 b 未回款

	
	private Float oddPrice;//代表历史订单的价格
	private String ordersTime;//接收前端的年份然后查询

	public Float getOddPrice() {
		return oddPrice;
	}

	

	public Orders(Integer odrId, String odrCustomer, Float oddPrice) {
		super();
		this.odrId = odrId;
		this.odrCustomer = odrCustomer;
		this.oddPrice = oddPrice;
	}



	public void setOddPrice(Float oddPrice) {
		this.oddPrice = oddPrice;
	}

	public String getOrdersTime() {
		return ordersTime;
	}

	public void setOrdersTime(String ordersTime) {
		this.ordersTime = ordersTime;
	}

	public	Orders(){}	

	public	Orders(Integer odrId,String odrCustomer,Timestamp odrDate,String odrAddr,String odrStatus){
		 this.odrId=odrId;
		 this.odrCustomer=odrCustomer;
		 this.odrDate=odrDate;
		 this.odrAddr=odrAddr;
		 this.odrStatus=odrStatus;
	}

	public void setOdrId(Integer odrId){
		this.odrId=odrId;
	}

	public Integer getOdrId(){
		return odrId;
	}

	public void setOdrCustomer(String odrCustomer){
		this.odrCustomer=odrCustomer;
	}

	public String getOdrCustomer(){
		return odrCustomer;
	}

	public void setOdrDate(Timestamp odrDate){
		this.odrDate=odrDate;
	}

	public Timestamp getOdrDate(){
		return odrDate;
	}

	public void setOdrAddr(String odrAddr){
		this.odrAddr=odrAddr;
	}

	public String getOdrAddr(){
		return odrAddr;
	}

	public void setOdrStatus(String odrStatus){
		this.odrStatus=odrStatus;
	}

	public String getOdrStatus(){
		return odrStatus;
	}

	 public String toString(){
		 return "Orders[odrId="	+odrId+",odrCustomer="	+odrCustomer+",odrDate="	+odrDate+",odrAddr="	+odrAddr+",odrStatus="	+odrStatus+"]";
	}
}

