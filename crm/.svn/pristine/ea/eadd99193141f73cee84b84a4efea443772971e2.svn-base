package com.zking.crm.custmer.biz.impl;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstLostBiz;
import com.zking.crm.custmer.dao.ICstLostDao;

public class CstLostBizImpl extends BaseBiz implements ICstLostBiz {

	private ICstLostDao cstLostDao;
	
	public ICstLostDao getCstLostDao() {
		return cstLostDao;
	}

	public void setCstLostDao(ICstLostDao cstLostDao) {
		this.cstLostDao = cstLostDao;
	}

	@Override
	public void addCstLost(CstLost cstLost) throws Exception {
		cstLostDao.addCstLost(cstLost);
	}

	@Override
	public void delCstLost(CstLost cstLost) throws Exception {
		cstLostDao.delCstLost(cstLost);
	}

	@Override
	public void editCstLost(CstLost cstLost) throws Exception {
		cstLostDao.editCstLost(cstLost);
	}

	@Override
	public CstLost byCstLost(CstLost cstLost) throws Exception {
		return cstLostDao.byCstLost(cstLost);
	}

	@Override
	public List<CstLost> queryCstLostPager(CstLost cstLost, PageBean pageBean) throws Exception {
		return cstLostDao.queryCstLostPager(cstLost, pageBean);
	}

}
