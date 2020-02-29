package com.zking.crm.permission.biz;

import java.util.List;

import com.zking.crm.base.entity.Tree;

public interface ITreeBiz {
	/**
	 * 遍历所有的根节点
	 * @return
	 */
	public List<Tree> queryRootNode();
	
}
