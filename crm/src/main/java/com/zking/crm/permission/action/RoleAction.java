package com.zking.crm.permission.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.Role;
import com.zking.crm.base.entity.RoleModule;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.permission.biz.IRoleBiz;

public class RoleAction extends BaseAction implements ModelDriven<Role> {

	private Role role=new Role();
	private IRoleBiz roleBiz;
	
	
	public IRoleBiz getRoleBiz() {
		return roleBiz;
	}


	public void setRoleBiz(IRoleBiz roleBiz) {
		this.roleBiz = roleBiz;
	}

	@Override
	public Role getModel() {
		return role;
	}

	/**
	 * 查询所有 用于判重
	 * @return
	 */
	public String queryRole() {
		try {
			List<Role> list = roleBiz.queryRole(role);
			super.toJSONObject(true, list);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONObject(false, null);
		}
		return null;
	}
	
	/**
	 * 新增角色
	 * @return
	 */
	public String addRole() {
		try {
			roleBiz.addRole(role);
			super.toJSONMessage("添加角色成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 新增角色
	 * @return
	 */
	public String delRole() {
		try {
			roleBiz.delRole(role);
			super.toJSONMessage("删除角色成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 修改角色
	 * @return
	 */
	public String editRole() {
		try {
			roleBiz.editRole(role);
			super.toJSONMessage("修改角色信息成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 分页查询角色信息
	 * @return
	 */
	public List<Role> queryRolePager(){
		try {
			String rolename=request.getParameter("rolename");
			role.setRolename(rolename);
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<Role> roles = roleBiz.queryRolePager(role, pageBean);
			super.toJSONPager("ok", true, pageBean.getTotal(), roles);
		} catch (Exception e) {
			super.toJSONPager(e.getMessage(), true, 0, null);
			e.printStackTrace();
		}
		return null;
	}
	
	public String addRoleModule() {
		try {
			String roleid=request.getParameter("roleid");
			String mod=request.getParameter("moduleid");
			System.out.println(mod);
			RoleModule rm=new RoleModule();
			rm.setRoleid(roleid);
			rm.setModuleid(mod);
			roleBiz.addRoleModule(rm);
			super.toJSONMessage("授权成功!", true);
		} catch (Exception e) {
			super.toJSONMessage("no", false);
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> queryModuleRoleId(){
		try {
			List<String> list = roleBiz.queryModuleRoleId(role);
			super.toJSONObject(true, list);
		} catch (Exception e) {
			super.toJSONObject(false, null);
			e.printStackTrace();
		}
		return null;
	}
	
	
}
