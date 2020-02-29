package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * Sal_plan 实体类
 * 2019-07-31 20:43:23
 */ 


public final class SalPlan extends SalChance implements Serializable {
	private Integer plaId;//计划ID: 主键 标识列
	private Integer plaChcId;//营销机会ID:外键 营销机会表的ID
	private Timestamp plaDate;//计划执行日期
	private String plaTodo;//计划内容
	private String plaResult;//计划执行结果
	private String tjian = "";//模糊查询条件
	private String str = "";//输入的内容
	
	public String getTjian() {
		return tjian;
	}

	public void setTjian(String tjian) {
		this.tjian = tjian;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public SalPlan(Integer chcId, String chcSource, String chcCustName, String chcTitle, Integer chcRate,
			String chcLinkman, String chcTel, String chcDesc, String chcCreateId, String chcCreateBy,
			Timestamp chcCreateDate, Integer chcDueId, String chcDueTo, Timestamp chcDueDate, String chcStatus,
			Integer plaId, Integer plaChcId, Timestamp plaDate, String plaTodo, String plaResult) {
		super(chcId, chcSource, chcCustName, chcTitle, chcRate, chcLinkman, chcTel, chcDesc, chcCreateId, chcCreateBy,
				chcCreateDate, chcDueId, chcDueTo, chcDueDate, chcStatus);
		this.plaId = plaId;
		this.plaChcId = plaChcId;
		this.plaDate = plaDate;
		this.plaTodo = plaTodo;
		this.plaResult = plaResult;
	}

	public	SalPlan(){
		super();
	}	

	public	SalPlan(Integer plaId,Integer plaChcId,Timestamp plaDate,String plaTodo,String plaResult){
		 this.plaId=plaId;
		 this.plaChcId=plaChcId;
		 this.plaDate=plaDate;
		 this.plaTodo=plaTodo;
		 this.plaResult=plaResult;
	}

	public void setPlaId(Integer plaId){
		this.plaId=plaId;
	}

	public Integer getPlaId(){
		return plaId;
	}

	public void setPlaChcId(Integer plaChcId){
		this.plaChcId=plaChcId;
	}

	public Integer getPlaChcId(){
		return plaChcId;
	}

	public void setPlaDate(Timestamp plaDate){
		this.plaDate=plaDate;
	}

	public Timestamp getPlaDate(){
		return plaDate;
	}

	public void setPlaTodo(String plaTodo){
		this.plaTodo=plaTodo;
	}

	public String getPlaTodo(){
		return plaTodo;
	}

	public void setPlaResult(String plaResult){
		this.plaResult=plaResult;
	}

	public String getPlaResult(){
		return plaResult;
	}

	@Override
	public String toString() {
		return "SalPlan [plaId=" + plaId + ", plaChcId=" + plaChcId + ", plaDate=" + plaDate + ", plaTodo=" + plaTodo
				+ ", plaResult=" + plaResult + ", toString()=" + super.toString() + "]";
	}

}

