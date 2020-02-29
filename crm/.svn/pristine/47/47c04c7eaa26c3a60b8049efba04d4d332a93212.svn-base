package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * T_role_module 权限管理:角色模块表
 * 2019-07-28 19:12:15
 */ 


public class RoleModule implements Serializable {
	private String roleid;//角色编号，依赖于T_Role表中的roleid
	private String moduleid;//模块编号，依赖于T_Module中的id

	public	RoleModule(){}	

	public	RoleModule(String roleid,String moduleid){
		 this.roleid=roleid;
		 this.moduleid=moduleid;
	}

	public void setRoleid(String roleid){
		this.roleid=roleid;
	}

	public String getRoleid(){
		return roleid;
	}

	public void setModuleid(String moduleid){
		this.moduleid=moduleid;
	}

	public String getModuleid(){
		return moduleid;
	}

	 public String toString(){
		 return "TRoleModule[roleid="	+roleid+",moduleid="	+moduleid+"]";
	}
}

