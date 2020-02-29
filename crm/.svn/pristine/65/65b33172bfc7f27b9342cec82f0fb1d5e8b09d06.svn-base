package com.zking.crm.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

 /**
 * T_module 权限管理:模块表
 * 2019-07-28 19:12:15
 */ 


public class Module implements Serializable {
	public Module(Integer id, Integer pid, String text) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
	}

	private Integer id;
	private Integer pid;
	private String text;
	private String icon;
	private String url;
	private Integer sort;
	
	private String roleid;


	public Module(Integer id, Integer pid, String text, String icon, String url, Integer sort) {
		super();
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.icon = icon;
		this.url = url;
		this.sort = sort;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}


	private List<Module> children=new ArrayList<Module>();
	
	public	Module(){}

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<Module> getChildren() {
		return children;
	}

	public void setChildren(List<Module> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", pid=" + pid + ", text=" + text + ", icon=" + icon + ", url=" + url + ", sort="
				+ sort + ", children=" + children + "]";
	}	

	
}

