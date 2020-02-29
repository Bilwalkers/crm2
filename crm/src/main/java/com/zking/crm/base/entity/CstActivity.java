package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * Cst_activity 实体类
 * 2019-07-31 20:43:23
 */ 


public class CstActivity implements Serializable {
	private Integer atvId;//交往记录ID: 主键 标识列
	private String atvCustNo;//客户编号: 外键 cst_customer(cust_no)
	private String atvCustName;//客户名称
	private Timestamp atvDate;//交往日期: 默认系统当前时间
	private String atvPlace;//交往地点
	private String atvTitle;//概要
	private String atvRemark;//备注
	private String atvDesc;//详情

	public	CstActivity(){}	

	public	CstActivity(Integer atvId,String atvCustNo,String atvCustName,Timestamp atvDate,String atvPlace,String atvTitle,String atvRemark,String atvDesc){
		 this.atvId=atvId;
		 this.atvCustNo=atvCustNo;
		 this.atvCustName=atvCustName;
		 this.atvDate=atvDate;
		 this.atvPlace=atvPlace;
		 this.atvTitle=atvTitle;
		 this.atvRemark=atvRemark;
		 this.atvDesc=atvDesc;
	}

	public void setAtvId(Integer atvId){
		this.atvId=atvId;
	}

	public Integer getAtvId(){
		return atvId;
	}

	public void setAtvCustNo(String atvCustNo){
		this.atvCustNo=atvCustNo;
	}

	public String getAtvCustNo(){
		return atvCustNo;
	}

	public void setAtvCustName(String atvCustName){
		this.atvCustName=atvCustName;
	}

	public String getAtvCustName(){
		return atvCustName;
	}

	public void setAtvDate(Timestamp atvDate){
		this.atvDate=atvDate;
	}

	public Timestamp getAtvDate(){
		return atvDate;
	}

	public void setAtvPlace(String atvPlace){
		this.atvPlace=atvPlace;
	}

	public String getAtvPlace(){
		return atvPlace;
	}

	public void setAtvTitle(String atvTitle){
		this.atvTitle=atvTitle;
	}

	public String getAtvTitle(){
		return atvTitle;
	}

	public void setAtvRemark(String atvRemark){
		this.atvRemark=atvRemark;
	}

	public String getAtvRemark(){
		return atvRemark;
	}

	public void setAtvDesc(String atvDesc){
		this.atvDesc=atvDesc;
	}

	public String getAtvDesc(){
		return atvDesc;
	}

	 public String toString(){
		 return "CstActivity[atvId="	+atvId+",atvCustNo="	+atvCustNo+",atvCustName="	+atvCustName+",atvDate="	+atvDate+",atvPlace="	+atvPlace+",atvTitle="	+atvTitle+",atvRemark="	+atvRemark+",atvDesc="	+atvDesc+"]";
	}
}

