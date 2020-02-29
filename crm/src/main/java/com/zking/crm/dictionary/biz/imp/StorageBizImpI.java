package com.zking.crm.dictionary.biz.imp;

import java.util.List;

import com.zking.crm.base.entity.Storage;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.dictionary.biz.IStorageBiz;
import com.zking.crm.dictionary.dao.IStorageDao;
import com.zking.crm.dictionary.dao.imp.StorageDaoImpI;

public class StorageBizImpI implements IStorageBiz {
	private IStorageDao istorageDao = new StorageDaoImpI();
	
	public IStorageDao getIstorageDao() {
		return istorageDao;
	}

	public void setIstorageDao(IStorageDao istorageDao) {
		this.istorageDao = istorageDao;
	}

	@Override
	public List<Storage> queryStoragePager(Storage storage, PageBean pageBean) {
		
		return istorageDao.queryStoragePager(storage, pageBean);
	}


}
