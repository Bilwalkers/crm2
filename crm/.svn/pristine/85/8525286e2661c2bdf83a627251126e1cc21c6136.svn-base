package com.zking.crm.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Tree implements Serializable {

	public Tree() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer id;
	private Integer pid;
	private String lable;
	
	private List<Tree> children=new ArrayList<Tree>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public Tree(Integer id, Integer pid, String lable) {
		super();
		this.id = id;
		this.pid = pid;
		this.lable = lable;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Tree [id=" + id + ", pid=" + pid + ", lable=" + lable + ", children=" + children + "]";
	}

	
	
	
}
