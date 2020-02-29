package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * Sal_plan_item 实体类
 * 2019-08-04 11:31:48
 */ 


public class SalPlanItem implements Serializable {
	private Integer pitemId;//计划项id:: 主键 标识列
	private Integer plaIdItem;//计划ID
	private Timestamp plaDateItem;//计划执行日期
	private String plaTodoItem;//计划内容
	private String plaResultItem;//计划执行结果

	public	SalPlanItem(){}	

	public	SalPlanItem(Integer pitemId,Integer plaIdItem,Timestamp plaDateItem,String plaTodoItem,String plaResultItem){
		 this.pitemId=pitemId;
		 this.plaIdItem=plaIdItem;
		 this.plaDateItem=plaDateItem;
		 this.plaTodoItem=plaTodoItem;
		 this.plaResultItem=plaResultItem;
	}

	public void setPitemId(Integer pitemId){
		this.pitemId=pitemId;
	}

	public Integer getPitemId(){
		return pitemId;
	}

	public void setPlaIdItem(Integer plaIdItem){
		this.plaIdItem=plaIdItem;
	}

	public Integer getPlaIdItem(){
		return plaIdItem;
	}

	public void setPlaDateItem(Timestamp plaDateItem){
		this.plaDateItem=plaDateItem;
	}

	public Timestamp getPlaDateItem(){
		return plaDateItem;
	}

	public void setPlaTodoItem(String plaTodoItem){
		this.plaTodoItem=plaTodoItem;
	}

	public String getPlaTodoItem(){
		return plaTodoItem;
	}

	public void setPlaResultItem(String plaResultItem){
		this.plaResultItem=plaResultItem;
	}

	public String getPlaResultItem(){
		return plaResultItem;
	}

	 public String toString(){
		 return "SalPlanItem[pitemId="	+pitemId+",plaIdItem="	+plaIdItem+",plaDateItem="	+plaDateItem+",plaTodoItem="	+plaTodoItem+",plaResultItem="	+plaResultItem+"]";
	}
}

