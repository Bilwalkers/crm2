package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * Storage 实体类
 * 2019-07-31 20:43:23
 */ 


public class Storage extends Product implements Serializable {
	private Integer stkId;//库存ID: 主键 标识列
	private Integer stkProdId;//产品ID: 外键 引用product(prod_id)
	private String stkWarehouse;//仓库
	private String stkWare;//货位
	private Integer stkCount;//件数
	private String stkMemo;//备注
	private String prodNamestr;//名称
	


	public String getProdNamestr() {
		return prodNamestr;
	}


	public void setProdNamestr(String prodNamestr) {
		this.prodNamestr = prodNamestr;
	}


	public	Storage(){}	

	
	public Storage(String prodName, Integer stkId, String stkWarehouse, String stkWare, Integer stkCount,
			String stkMemo) {
		super(prodName);
		this.stkId = stkId;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
		this.stkMemo = stkMemo;
	}


	public	Storage(Integer stkId,Integer stkProdId,String stkWarehouse,String stkWare,Integer stkCount,String stkMemo){
		 this.stkId=stkId;
		 this.stkProdId=stkProdId;
		 this.stkWarehouse=stkWarehouse;
		 this.stkWare=stkWare;
		 this.stkCount=stkCount;
		 this.stkMemo=stkMemo;
	}

	public void setStkId(Integer stkId){
		this.stkId=stkId;
	}

	public Integer getStkId(){
		return stkId;
	}

	public void setStkProdId(Integer stkProdId){
		this.stkProdId=stkProdId;
	}

	public Integer getStkProdId(){
		return stkProdId;
	}

	public void setStkWarehouse(String stkWarehouse){
		this.stkWarehouse=stkWarehouse;
	}

	public String getStkWarehouse(){
		return stkWarehouse;
	}

	public void setStkWare(String stkWare){
		this.stkWare=stkWare;
	}

	public String getStkWare(){
		return stkWare;
	}

	public void setStkCount(Integer stkCount){
		this.stkCount=stkCount;
	}

	public Integer getStkCount(){
		return stkCount;
	}

	public void setStkMemo(String stkMemo){
		this.stkMemo=stkMemo;
	}

	public String getStkMemo(){
		return stkMemo;
	}
	@Override
	public String toString() {
		return "Storage [stkId=" + stkId + ", stkProdId=" + stkProdId + ", stkWarehouse=" + stkWarehouse + ", stkWare="
				+ stkWare + ", stkCount=" + stkCount + ", stkMemo=" + stkMemo + ", prodNamestr=" + prodNamestr
				+ ", toString()=" + super.toString() + "]";
	}



}

