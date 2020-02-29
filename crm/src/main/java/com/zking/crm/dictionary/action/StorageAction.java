package com.zking.crm.dictionary.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.Storage;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.dictionary.biz.IStorageBiz;

public class StorageAction extends BaseAction implements ModelDriven<Storage> {
	private Storage storage = new Storage();
	private IStorageBiz istorageBiz;
	
	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public IStorageBiz getIstorageBiz() {
		return istorageBiz;
	}

	public void setIstorageBiz(IStorageBiz istorageBiz) {
		this.istorageBiz = istorageBiz;
	}

	@Override
	public Storage getModel() {
		return storage;
	}
	/**
	 * 分页查询仓库数据
	 */
	public void queryStoragePager() {
		try {
			PageBean pageBean = new PageBean();
			pageBean.setRequest(request);
			List<Storage> list = istorageBiz.queryStoragePager(storage, pageBean);
			System.out.println(list);
			super.toJSONPager("OK", true,pageBean.getTotal(),list);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager("No", false, 0, null);
		}
	}

}
