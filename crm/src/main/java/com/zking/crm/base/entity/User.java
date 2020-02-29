package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * T_user 权限管理:用户表 2019-07-28 19:12:15
 */

public class User implements Serializable {
	private String id;// 用户ID
	private String username;// 登录用户名
	private String password;// 登录密码
	private String deptment;// 所属部门
	private Timestamp createdate;// 创建时期

	// 用于连表查询 用户-->对应角色-->具备权限
	private String roleid;
	private List<Module> module=new ArrayList<Module>();
	private String rolename;
	private String dictItem;

	public User(String id, String username, String roleid, String rolename) {
		super();
		this.id = id;
		this.username = username;
		this.roleid = roleid;
		this.rolename = rolename;
	}

	//用于模糊查询
	private String tjian;
	private String content;
	

	public User(String id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}

	public String getTjian() {
		return tjian;
	}

	public void setTjian(String tjian) {
		this.tjian = tjian;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User(String id, String username, String password, String roleid, String rolename) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleid = roleid;
		this.rolename = rolename;
	}

	public User(String id, String username, String password, String deptment, Timestamp createdate, String roleid,
			String rolename) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.deptment = deptment;
		this.createdate = createdate;
		this.roleid = roleid;
		this.rolename = rolename;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	

	public String getDictItem() {
		return dictItem;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", deptment=" + deptment
				+ ", createdate=" + createdate + ", roleid=" + roleid + ", module=" + module + ", rolename=" + rolename
				+ ", dictItem=" + dictItem + "]";
	}

	public void setDictItem(String dictItem) {
		this.dictItem = dictItem;
	}

	public User() {
	}

	/*public User(Timestamp createdate, String deptment, String dictItem, String id, String password, String roleid,
			String rolename, String username) {
		super();
		this.createdate = createdate;
		this.deptment = deptment;
		this.dictItem = dictItem;
		this.id = id;
		this.password = password;
		this.roleid = roleid;
		this.rolename = rolename;
		this.username = username;
	}*/

	public void setId(String id) {
		this.id = id;
	}

	public User(String id, String username, String password, String deptment, Timestamp createdate, String roleid,
			String rolename, String dictItem) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.deptment = deptment;
		this.createdate = createdate;
		this.roleid = roleid;
		this.rolename = rolename;
		this.dictItem = dictItem;
	}

	public String getId() {
		return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setDeptment(String deptment) {
		this.deptment = deptment;
	}

	public String getDeptment() {
		return deptment;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

}
