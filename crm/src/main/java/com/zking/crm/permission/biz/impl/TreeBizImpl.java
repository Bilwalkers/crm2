package com.zking.crm.permission.biz.impl;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.permission.biz.ITreeBiz;
import com.zking.crm.permission.dao.ITreeDao;

public class TreeBizImpl extends BaseBiz implements ITreeBiz {

	private ITreeDao treeDao;
	
	public ITreeDao getTreeDao() {
		return treeDao;
	}

	public void setTreeDao(ITreeDao treeDao) {
		this.treeDao = treeDao;
	}

	@Override
	public List<Tree> queryRootNode() {
		return treeDao.queryRootNode();
	}

	

}
