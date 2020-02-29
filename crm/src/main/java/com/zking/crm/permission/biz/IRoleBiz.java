package com.zking.crm.permission.biz;

import java.util.List;

import com.zking.crm.base.entity.Role;
import com.zking.crm.base.entity.RoleModule;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.util.PageBean;

public interface IRoleBiz {
	
	/**
	 * 查询所有 用来判重的
	 * @param role
	 * @return
	 */
	public List<Role> queryRole(Role role);
	/**
	 * 新增角色
	 * @param role
	 */
	public void addRole(Role role);
	/**
	 * 删除角色
	 * 1.删除该角色的信息
	 * 2.删除角色对应的模块
	 * @param role
	 */
	public void delRole(Role role);
	/**
	 * 编辑角色信息
	 * @param role
	 */
	public void editRole(Role role);
	/**
	 * 分页查询角色  暂时没有做分页!
	 * @param role
	 * @param pageBean
	 * @return
	 */
	public List<Role> queryRolePager(Role role,PageBean pageBean);
	/**
	 * 添加角色权限(对应的模块)
	 * 1.删除该角色的所有权限
	 * 2.添加现在的新权限
	 * @param rm
	 */
	public void addRoleModule(RoleModule rm);
	/**
	 * 通过id查询角色对应的权限(页面级权限)
	 * @param role
	 * @return
	 */
	public List<String> queryModuleRoleId(Role role);
}
