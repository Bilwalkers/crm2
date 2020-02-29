package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * T_role 权限管理:用户角色表
 * 2019-07-28 19:12:15
 */ 


public class Role implements Serializable {
	private String roleid;//角色编号
	private String rolename;//角色名称

	public	Role(){}	

	public	Role(String roleid,String rolename){
		 this.roleid=roleid;
		 this.rolename=rolename;
	}

	public void setRoleid(String roleid){
		this.roleid=roleid;
	}

	public String getRoleid(){
		return roleid;
	}

	public void setRolename(String rolename){
		this.rolename=rolename;
	}

	public String getRolename(){
		return rolename;
	}

	 public String toString(){
		 return "TRole[roleid="	+roleid+",rolename="	+rolename+"]";
	}
}

