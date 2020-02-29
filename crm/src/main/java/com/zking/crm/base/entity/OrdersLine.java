package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * Orders_line 实体类
 * 2019-07-31 20:43:23
 */ 


public class OrdersLine implements Serializable {
	private Integer oddId;//订单明细ID: 主键 标识列
	private Integer oddOrderId;//订单ID: 外键 引用orders(odr_id)
	private Integer oddProdId;//产品ID: 外键 引用product(prod_id)
	private Integer oddCount;//数量
	private String oddUnit;//单位
	private Float oddPrice;//单价

	public	OrdersLine(){}	

	public	OrdersLine(Integer oddId,Integer oddOrderId,Integer oddProdId,Integer oddCount,String oddUnit,Float oddPrice){
		 this.oddId=oddId;
		 this.oddOrderId=oddOrderId;
		 this.oddProdId=oddProdId;
		 this.oddCount=oddCount;
		 this.oddUnit=oddUnit;
		 this.oddPrice=oddPrice;
	}

	public void setOddId(Integer oddId){
		this.oddId=oddId;
	}

	public Integer getOddId(){
		return oddId;
	}

	public void setOddOrderId(Integer oddOrderId){
		this.oddOrderId=oddOrderId;
	}

	public Integer getOddOrderId(){
		return oddOrderId;
	}

	public void setOddProdId(Integer oddProdId){
		this.oddProdId=oddProdId;
	}

	public Integer getOddProdId(){
		return oddProdId;
	}

	public void setOddCount(Integer oddCount){
		this.oddCount=oddCount;
	}

	public Integer getOddCount(){
		return oddCount;
	}

	public void setOddUnit(String oddUnit){
		this.oddUnit=oddUnit;
	}

	public String getOddUnit(){
		return oddUnit;
	}

	public void setOddPrice(Float oddPrice){
		this.oddPrice=oddPrice;
	}

	public Float getOddPrice(){
		return oddPrice;
	}

	 public String toString(){
		 return "OrdersLine[oddId="	+oddId+",oddOrderId="	+oddOrderId+",oddProdId="	+oddProdId+",oddCount="	+oddCount+",oddUnit="	+oddUnit+",oddPrice="	+oddPrice+"]";
	}
}

