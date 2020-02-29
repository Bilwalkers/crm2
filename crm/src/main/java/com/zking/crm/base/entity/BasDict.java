package com.zking.crm.base.entity;

import java.io.Serializable;

 /**
 * Bas_dict 实体类
 * 2019-07-31 20:43:23
 */ 


public class BasDict implements Serializable {
	private Integer dictId;//字典ID: 主键 标识列
	private String dictType;//字典类型
	private String dictItem;//字典条目: 一般用来生成下拉框的文本
	private String dictValue;//字典值: 一般用来生成下拉框的值
	private Integer dictIsEditable;//能否编辑: 1 可 0 不可

	public	BasDict(){}	

	public	BasDict(Integer dictId,String dictType,String dictItem,String dictValue,Integer dictIsEditable){
		 this.dictId=dictId;
		 this.dictType=dictType;
		 this.dictItem=dictItem;
		 this.dictValue=dictValue;
		 this.dictIsEditable=dictIsEditable;
	}

	public void setDictId(Integer dictId){
		this.dictId=dictId;
	}

	public Integer getDictId(){
		return dictId;
	}

	public void setDictType(String dictType){
		this.dictType=dictType;
	}

	public String getDictType(){
		return dictType;
	}

	public void setDictItem(String dictItem){
		this.dictItem=dictItem;
	}

	public String getDictItem(){
		return dictItem;
	}

	public void setDictValue(String dictValue){
		this.dictValue=dictValue;
	}

	public String getDictValue(){
		return dictValue;
	}

	public void setDictIsEditable(Integer dictIsEditable){
		this.dictIsEditable=dictIsEditable;
	}

	public Integer getDictIsEditable(){
		return dictIsEditable;
	}

	 public String toString(){
		 return "BasDict[dictId="	+dictId+",dictType="	+dictType+",dictItem="	+dictItem+",dictValue="	+dictValue+",dictIsEditable="	+dictIsEditable+"]";
	}
}

