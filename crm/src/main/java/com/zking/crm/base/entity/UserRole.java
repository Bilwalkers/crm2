package com.zking.crm.base.entity;

import java.io.Serializable;
import java.sql.Timestamp;

 /**
 * T_user_role 权限管理:用户角色表
 * 2019-07-28 19:12:15
 */ 


public class UserRole implements Serializable {
	private String userid;//用户编号，依赖于T_User表中的id
	private String roleid;//角色编号，依赖于T_Role表中的roleid

	public	UserRole(){}	

	public	UserRole(String userid,String roleid){
		 this.userid=userid;
		 this.roleid=roleid;
	}

	public void setUserid(String userid){
		this.userid=userid;
	}

	public String getUserid(){
		return userid;
	}

	public void setRoleid(String roleid){
		this.roleid=roleid;
	}

	public String getRoleid(){
		return roleid;
	}

	 public String toString(){
		 return "TUserRole[userid="	+userid+",roleid="	+roleid+"]";
	}
}

