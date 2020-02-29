package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * Cst_lost 实体类
 * 2019-07-31 20:43:23
 */ 


public class CstLost implements Serializable {
	private Integer lstId;//客户流失ID: 主键 标识列
	private String lstCustNo;//客户编号: 外键 cst_customer(cust_no)
	private String lstCustName;//客户名称
	private String lstCustManagerId;//客户经理ID
	private String lstCustManagerName;//客户经理名字
	private Timestamp lstLastOrderDate;//上次下单时间
	private Timestamp lstLostDate;//流失时间
	private String lstDelay;//暂缓措施
	private String lstReason;//流失原因
	private String lstStatus;//状态: 默认值1 1 预警 2 暂缓流失 3 确认流失

	public	CstLost(){}	

	public	CstLost(Integer lstId,String lstCustNo,String lstCustName,String lstCustManagerId,String lstCustManagerName,Timestamp lstLastOrderDate,Timestamp lstLostDate,String lstDelay,String lstReason,String lstStatus){
		 this.lstId=lstId;
		 this.lstCustNo=lstCustNo;
		 this.lstCustName=lstCustName;
		 this.lstCustManagerId=lstCustManagerId;
		 this.lstCustManagerName=lstCustManagerName;
		 this.lstLastOrderDate=lstLastOrderDate;
		 this.lstLostDate=lstLostDate;
		 this.lstDelay=lstDelay;
		 this.lstReason=lstReason;
		 this.lstStatus=lstStatus;
	}

	public void setLstId(Integer lstId){
		this.lstId=lstId;
	}

	public Integer getLstId(){
		return lstId;
	}

	public void setLstCustNo(String lstCustNo){
		this.lstCustNo=lstCustNo;
	}

	public String getLstCustNo(){
		return lstCustNo;
	}

	public void setLstCustName(String lstCustName){
		this.lstCustName=lstCustName;
	}

	public String getLstCustName(){
		return lstCustName;
	}

	public void setLstCustManagerId(String lstCustManagerId){
		this.lstCustManagerId=lstCustManagerId;
	}

	public String getLstCustManagerId(){
		return lstCustManagerId;
	}

	public void setLstCustManagerName(String lstCustManagerName){
		this.lstCustManagerName=lstCustManagerName;
	}

	public String getLstCustManagerName(){
		return lstCustManagerName;
	}

	public void setLstLastOrderDate(Timestamp lstLastOrderDate){
		this.lstLastOrderDate=lstLastOrderDate;
	}

	public Timestamp getLstLastOrderDate(){
		return lstLastOrderDate;
	}

	public void setLstLostDate(Timestamp lstLostDate){
		this.lstLostDate=lstLostDate;
	}

	public Timestamp getLstLostDate(){
		return lstLostDate;
	}

	public void setLstDelay(String lstDelay){
		this.lstDelay=lstDelay;
	}

	public String getLstDelay(){
		return lstDelay;
	}

	public void setLstReason(String lstReason){
		this.lstReason=lstReason;
	}

	public String getLstReason(){
		return lstReason;
	}

	public void setLstStatus(String lstStatus){
		this.lstStatus=lstStatus;
	}

	public String getLstStatus(){
		return lstStatus;
	}

	 public String toString(){
		 return "CstLost[lstId="	+lstId+",lstCustNo="	+lstCustNo+",lstCustName="	+lstCustName+",lstCustManagerId="	+lstCustManagerId+",lstCustManagerName="	+lstCustManagerName+",lstLastOrderDate="	+lstLastOrderDate+",lstLostDate="	+lstLostDate+",lstDelay="	+lstDelay+",lstReason="	+lstReason+",lstStatus="	+lstStatus+"]";
	}
}

