package com.zking.crm.permission.biz;

import java.util.List;

import com.zking.crm.base.entity.Module;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.entity.User;

public interface IModuleBiz {
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
}
