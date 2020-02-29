package com.zking.crm.permission.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.permission.biz.ITreeBiz;

public class TreeAction extends BaseAction implements ModelDriven<Tree> {

	private Tree tree=new Tree();
	private ITreeBiz treeBiz;
	
	
	public ITreeBiz getTreeBiz() {
		return treeBiz;
	}

	public void setTreeBiz(ITreeBiz treeBiz) {
		this.treeBiz = treeBiz;
	}

	@Override
	public Tree getModel() {
		return tree;
	}

	public List<Tree> queryRootNode(){
		try {
			List<Tree> nodes = treeBiz.queryRootNode();
			super.toJSONObject(true, nodes);
		} catch (Exception e) {
			super.toJSONObject(false, null);
			e.printStackTrace();
		}
		return null;
	}
	
}
