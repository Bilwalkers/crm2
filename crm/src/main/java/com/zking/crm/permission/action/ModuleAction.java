package com.zking.crm.permission.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.Module;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.entity.User;
import com.zking.crm.permission.biz.IModuleBiz;

public class ModuleAction extends BaseAction implements ModelDriven<Module>{

	private Module module=new Module();
//	private String userid=request.getParameter("userid");
	private IModuleBiz moduleBiz;
	
	public IModuleBiz getModuleBiz() {
		return moduleBiz;
	}


	public void setModuleBiz(IModuleBiz moduleBiz) {
		this.moduleBiz = moduleBiz;
	}


	@Override
	public Module getModel() {
		return module;
	}
	
	
	/**
	 * 查询所有的根节点 左侧菜单栏
	 * @return
	 */
	public String queryRootNode() {
		try {
			/*String roleid= request.getParameter("roleid");
			module.setRoleid(roleid);*/
			List<Module> nodes = moduleBiz.queryRootNode(module);
			super.toJSONObject(true, nodes);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONObject(false, null);
		}
		return null;
	}
	
	/**
	 * 查询所有模块信息
	 * @return
	 */
	public List<Module> queryModuleAuth(){
		try {
			List<Module> list = moduleBiz.queryModuleAuth();
			super.toJSONObject(true, list);
		} catch (Exception e) {
			super.toJSONObject(false, null);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据模块pid查询所有子模块信息
	 * @return
	 */
	public List<Module> queryModuleByPid(){
		try {
			List<Module> list = moduleBiz.queryModuleByPid(module);
			super.toJSONObject(true, list);
		} catch (Exception e) {
			super.toJSONObject(false, null);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据用户查询用户对应的模块
	 * @return
	 */
	public List<Module> queryModuleByUserId(){
		try {
			String userid=request.getParameter("userid");
			List<Module> list = moduleBiz.queryModuleByUserId(userid);
			super.toJSONObject(true, list);
		} catch (Exception e) {
			super.toJSONObject(false, null);
			e.printStackTrace();
		}
		return null;
	}
	
	

}
