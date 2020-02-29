package com.zking.crm.permission.dao;

import java.util.List;

import com.zking.crm.base.entity.Module;
import com.zking.crm.base.entity.Tree;

public interface ITreeDao {
	/**
	 * 遍历所有的根节点
	 * @return
	 */
	public List<Tree> queryRootNode();
	
	/**
	 * 无限极分类的核心思想:根节点的id是字节点的pid,子节点依据根节点的id(即子节点本身的pid)查询出所有根节点下的子节点集合
	 * @param pid 根节点的id
	 * @param module 根模块
	 */
	public void queryTreeByPid(Integer pid,Tree tree);
}
