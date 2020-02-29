package com.zking.crm.permission.biz.impl;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.Module;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.entity.User;
import com.zking.crm.permission.biz.IModuleBiz;
import com.zking.crm.permission.dao.IModuleDao;

public class ModuleBizImpl extends BaseBiz implements IModuleBiz {

	private IModuleDao moduleDao;
	
	public IModuleDao getModuleDao() {
		return moduleDao;
	}

	public void setModuleDao(IModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	@Override
	public List<Module> queryRootNode(Module module) {
		return moduleDao.queryRootNode(module);
	}

	@Override
	public List<Module> queryModuleAuth() {
		return moduleDao.queryModuleAuth();
	}

	@Override
	public List<Module> queryModuleByPid(Module module) {
		return moduleDao.queryModuleByPid(module);
	}

	@Override
	public List<Module> queryModuleByUserId(String userid) {
		return moduleDao.queryModuleByUserId(userid);
	}

}
