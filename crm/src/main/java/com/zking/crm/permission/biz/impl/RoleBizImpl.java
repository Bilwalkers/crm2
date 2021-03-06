package com.zking.crm.permission.biz.impl;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.Role;
import com.zking.crm.base.entity.RoleModule;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.permission.biz.IRoleBiz;
import com.zking.crm.permission.dao.IRoleDao;

public class RoleBizImpl extends BaseBiz implements IRoleBiz {

	private IRoleDao roleDao;
	
	public IRoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public void addRole(Role role) {
		roleDao.addRole(role);

	}

	@Override
	public void delRole(Role role) {
		roleDao.delRole(role);
	}

	@Override
	public void editRole(Role role) {
		roleDao.editRole(role);
	}

	@Override
	public List<Role> queryRolePager(Role role, PageBean pageBean) {
		return roleDao.queryRolePager(role, pageBean);
	}

	@Override
	public void addRoleModule(RoleModule rm) {
		roleDao.addRoleModule(rm);
	}

	@Override
	public List<String> queryModuleRoleId(Role role) {
		return roleDao.queryModuleRoleId(role);
	}

	@Override
	public List<Role> queryRole(Role role) {
		return roleDao.queryRole(role);
	}

}
