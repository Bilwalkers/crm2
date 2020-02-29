package com.zking.crm.custmer.biz.impl;


import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstCustomerBiz;
import com.zking.crm.custmer.dao.ICstCustomerDao;

public class CstCustomerBizImpl extends BaseBiz implements ICstCustomerBiz {

	private ICstCustomerDao cstCustomerDao;
	
	
	public ICstCustomerDao getCstCustomerDao() throws Exception {
		return cstCustomerDao;
	}

	public void setCstCustomerDao(ICstCustomerDao cstCustomerDao) throws Exception {
		this.cstCustomerDao = cstCustomerDao;
	}

	@Override
	public void addCstCustomer(CstCustomer cstCustomer) throws Exception {
		cstCustomerDao.addCstCustomer(cstCustomer);
	}

	@Override
	public void delCstCustomer(CstCustomer cstCustomer) throws Exception {
		cstCustomerDao.delCstCustomer(cstCustomer);
	}

	@Override
	public void editCstCustomer(CstCustomer cstCustomer) throws Exception {
		cstCustomerDao.editCstCustomer(cstCustomer);
	}

	@Override
	public CstCustomer byCstCustomer(CstCustomer cstCustomer) throws Exception {
		return cstCustomerDao.byCstCustomer(cstCustomer);
	}

	@Override
	public List<CstCustomer> queryCstCustomerPager(CstCustomer cstCustomer, PageBean pageBean) throws Exception {
		return cstCustomerDao.queryCstCustomerPager(cstCustomer, pageBean);
	}

	@Override
	public void ByeditCstCustomer(CstCustomer cstCustomer) throws Exception {
		cstCustomerDao.ByeditCstCustomer(cstCustomer);
	}

}
