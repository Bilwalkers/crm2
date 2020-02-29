package com.zking.crm.dictionary.biz;

import java.util.List;

import com.zking.crm.base.entity.Storage;
import com.zking.crm.base.util.PageBean;

public interface IStorageBiz {
	/**
	 * 分页查询所有仓库数据
	 * @return
	 */
	public List<Storage> queryStoragePager(Storage storage,PageBean pageBean);
}
