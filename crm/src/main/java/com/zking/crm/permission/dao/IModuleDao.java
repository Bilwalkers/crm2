package com.zking.crm.permission.dao;

import java.util.List;

import com.zking.crm.base.entity.Module;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.entity.User;

public interface IModuleDao {

	/**
	 * 查询所有的模块信息
	 * 在这里给定公共权限 pid=99
	 * @return
	 */
	public List<Module> queryModuleAuth();
	
	/**
	 * 根据模块pid查询对应模块的信息
	 * 子节点的pid是父节点的id
	 * @param module
	 * @return
	 */
	public List<Module> queryModuleByPid(Module module);
	
	/**
	 * 先放着不写....
	 * 根据用户id查询该用户对应的角色权限
	 * @param userid 用户id
	 * @return
	 */
	public List<Module> queryModuleByUserId(String userid);
	
	/**
	 * 遍历所有的根节点
	 * @return
	 */
	public List<Module> queryRootNode(Module module);
	
	/**
	 * 无限极分类的核心思想:根节点的id是字节点的pid,子节点依据根节点的id(即子节点本身的pid)查询出所有根节点下的子节点集合
	 * @param pid 根节点的id
	 * @param module 根模块
	 */
	public void queryModuleByPid(Integer pid,Module module);
	
}
