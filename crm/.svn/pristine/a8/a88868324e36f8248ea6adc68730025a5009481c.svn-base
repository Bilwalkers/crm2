package com.zking.crm.base.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

 /**
 * Cst_service 实体类
 * 2019-07-31 20:43:23
 */ 


public class CstService implements Serializable {
	private Integer svrId;//服务ID:主键 标识列
	private String svrType;//服务类型:数据字典(服务类型)
	private String svrTitle;//概要
	private String svrCustNo;//客户编号: 外键 cst_customer(cust_no)
	private String svrCustName;//客户名字
	private String svrStatus;//服务状态: 默认值 '新创建'
	private String svrRequest;//服务请求(要求)
	private String svrCreateId;//创建人ID
	private String svrCreateBy;//创建人名字
	private Timestamp svrCreateDate;//创建日期时间:默认值为系统当前日期时间
	private String svrDueId;//派给人ID
	private String svrDueTo;//派给人名字
	private Timestamp svrDueDate;//指派日期时间
	private String svrDeal;//服务处理
	private String svrDealId;//处理人-某人ID
	private String svrDealBy;//处理人-某人名字
	private Timestamp svrDealDate;//处理日期时间
	private String svrResult;//处理结果
	private Integer svrSatisfy;//满意度

	
	private String dictItem; //代表字典表的服务类型（3个）
	private BigInteger serviceCount; //统计数量
	private String serTime; //接收前端的年份然后查询
	public String getSerTimeDate() {
		return serTimeDate;
	}

	public void setSerTimeDate(String serTimeDate) {
		this.serTimeDate = serTimeDate;
	}

	private String serTimeDate;	
	
	public CstService(String dictItem, BigInteger serviceCount) {
		super();
		this.dictItem = dictItem;
		this.serviceCount = serviceCount;
	}

	public String getDictItem() {
		return dictItem;
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public BigInteger getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(BigInteger serviceCount) {
		this.serviceCount = serviceCount;
	}

	public String getSerTime() {
		return serTime;
	}

	public void setSerTime(String serTime) {
		this.serTime = serTime;
	}

	public	CstService(){}	

	public	CstService(Integer svrId,String svrType,String svrTitle,String svrCustNo,String svrCustName,String svrStatus,String svrRequest,String svrCreateId,String svrCreateBy,Timestamp svrCreateDate,String svrDueId,String svrDueTo,Timestamp svrDueDate,String svrDeal,String svrDealId,String svrDealBy,Timestamp svrDealDate,String svrResult,Integer svrSatisfy){
		 this.svrId=svrId;
		 this.svrType=svrType;
		 this.svrTitle=svrTitle;
		 this.svrCustNo=svrCustNo;
		 this.svrCustName=svrCustName;
		 this.svrStatus=svrStatus;
		 this.svrRequest=svrRequest;
		 this.svrCreateId=svrCreateId;
		 this.svrCreateBy=svrCreateBy;
		 this.svrCreateDate=svrCreateDate;
		 this.svrDueId=svrDueId;
		 this.svrDueTo=svrDueTo;
		 this.svrDueDate=svrDueDate;
		 this.svrDeal=svrDeal;
		 this.svrDealId=svrDealId;
		 this.svrDealBy=svrDealBy;
		 this.svrDealDate=svrDealDate;
		 this.svrResult=svrResult;
		 this.svrSatisfy=svrSatisfy;
	}

	public void setSvrId(Integer svrId){
		this.svrId=svrId;
	}

	public Integer getSvrId(){
		return svrId;
	}

	public void setSvrType(String svrType){
		this.svrType=svrType;
	}

	public String getSvrType(){
		return svrType;
	}

	public void setSvrTitle(String svrTitle){
		this.svrTitle=svrTitle;
	}

	public String getSvrTitle(){
		return svrTitle;
	}

	public void setSvrCustNo(String svrCustNo){
		this.svrCustNo=svrCustNo;
	}

	public String getSvrCustNo(){
		return svrCustNo;
	}

	public void setSvrCustName(String svrCustName){
		this.svrCustName=svrCustName;
	}

	public String getSvrCustName(){
		return svrCustName;
	}

	public void setSvrStatus(String svrStatus){
		this.svrStatus=svrStatus;
	}

	public String getSvrStatus(){
		return svrStatus;
	}

	public void setSvrRequest(String svrRequest){
		this.svrRequest=svrRequest;
	}

	public String getSvrRequest(){
		return svrRequest;
	}

	public void setSvrCreateId(String svrCreateId){
		this.svrCreateId=svrCreateId;
	}

	public String getSvrCreateId(){
		return svrCreateId;
	}

	public void setSvrCreateBy(String svrCreateBy){
		this.svrCreateBy=svrCreateBy;
	}

	public String getSvrCreateBy(){
		return svrCreateBy;
	}

	public void setSvrCreateDate(Timestamp svrCreateDate){
		this.svrCreateDate=svrCreateDate;
	}

	public Timestamp getSvrCreateDate(){
		return svrCreateDate;
	}

	public void setSvrDueId(String svrDueId){
		this.svrDueId=svrDueId;
	}

	public String getSvrDueId(){
		return svrDueId;
	}

	public void setSvrDueTo(String svrDueTo){
		this.svrDueTo=svrDueTo;
	}

	public String getSvrDueTo(){
		return svrDueTo;
	}

	public void setSvrDueDate(Timestamp svrDueDate){
		this.svrDueDate=svrDueDate;
	}

	public Timestamp getSvrDueDate(){
		return svrDueDate;
	}

	public void setSvrDeal(String svrDeal){
		this.svrDeal=svrDeal;
	}

	public String getSvrDeal(){
		return svrDeal;
	}

	public void setSvrDealId(String svrDealId){
		this.svrDealId=svrDealId;
	}

	public String getSvrDealId(){
		return svrDealId;
	}

	public void setSvrDealBy(String svrDealBy){
		this.svrDealBy=svrDealBy;
	}

	public String getSvrDealBy(){
		return svrDealBy;
	}

	public void setSvrDealDate(Timestamp svrDealDate){
		this.svrDealDate=svrDealDate;
	}

	public Timestamp getSvrDealDate(){
		return svrDealDate;
	}

	public void setSvrResult(String svrResult){
		this.svrResult=svrResult;
	}

	public String getSvrResult(){
		return svrResult;
	}

	public void setSvrSatisfy(Integer svrSatisfy){
		this.svrSatisfy=svrSatisfy;
	}

	public Integer getSvrSatisfy(){
		return svrSatisfy;
	}

	 public String toString(){
		 return "CstService[svrId="	+svrId+",svrType="	+svrType+",svrTitle="	+svrTitle+",svrCustNo="	+svrCustNo+",svrCustName="	+svrCustName+",svrStatus="	+svrStatus+",svrRequest="	+svrRequest+",svrCreateId="	+svrCreateId+",svrCreateBy="	+svrCreateBy+",svrCreateDate="	+svrCreateDate+",svrDueId="	+svrDueId+",svrDueTo="	+svrDueTo+",svrDueDate="	+svrDueDate+",svrDeal="	+svrDeal+",svrDealId="	+svrDealId+",svrDealBy="	+svrDealBy+",svrDealDate="	+svrDealDate+",svrResult="	+svrResult+",svrSatisfy="	+svrSatisfy+"]";
	}
}

