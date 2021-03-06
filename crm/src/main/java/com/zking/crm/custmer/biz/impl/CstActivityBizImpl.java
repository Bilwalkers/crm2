package com.zking.crm.custmer.biz.impl;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.CstActivity;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstActivityBiz;
import com.zking.crm.custmer.dao.ICstActivityDao;

public class CstActivityBizImpl extends BaseBiz implements ICstActivityBiz {

	private ICstActivityDao cstActivityDao;
	
	
	public ICstActivityDao getCstActivityDao() {
		return cstActivityDao;
	}

	public void setCstActivityDao(ICstActivityDao cstActivityDao) {
		this.cstActivityDao = cstActivityDao;
	}

	@Override
	public void addCstActivity(CstActivity cstActivity) throws Exception {
		cstActivityDao.addCstActivity(cstActivity);
	}

	@Override
	public void delCstActivity(CstActivity cstActivity) throws Exception {
		cstActivityDao.delCstActivity(cstActivity);
	}

	@Override
	public void editCstActivity(CstActivity cstActivity) throws Exception {
		cstActivityDao.editCstActivity(cstActivity);
	}

	@Override
	public CstActivity byCstActivity(CstActivity cstActivity) throws Exception {
		return cstActivityDao.byCstActivity(cstActivity);
	}

	@Override
	public List<CstActivity> queryCstActivityPager(CstActivity cstActivity, PageBean pageBean,String startTime, String endTime) throws Exception {
		return cstActivityDao.queryCstActivityPager(cstActivity, pageBean,startTime, endTime);
	}

}
