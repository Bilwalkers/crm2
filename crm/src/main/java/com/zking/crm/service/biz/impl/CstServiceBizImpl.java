package com.zking.crm.service.biz.impl;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.CstService;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.service.biz.ICstServiceBiz;
import com.zking.crm.service.dao.ICstServiceDao;

public class CstServiceBizImpl extends BaseBiz implements ICstServiceBiz {
	
	private ICstServiceDao cstServiceDao;

	public ICstServiceDao getServiceDao() {
		return cstServiceDao;
	}

	public void setServiceDao(ICstServiceDao cstServiceDao) {
		this.cstServiceDao = cstServiceDao;
	}

	@Override
	public void addCstService(CstService cstService) throws Exception {
		cstServiceDao.addCstService(cstService);
	}

	@Override
	public void editCstService(CstService cstService) throws Exception {
		cstServiceDao.editCstService(cstService);
	}

	@Override
	public void delCstService(CstService cstService) throws Exception {
		cstServiceDao.delCstService(cstService);
	}

	@Override
	public CstService byCstService(CstService cstService) throws Exception {
		return cstServiceDao.byCstService(cstService);
	}

	@Override
	public List<CstService> queryCstServicePager(CstService cstService, PageBean pageBean, String startTime, String endTime) throws Exception {
		return cstServiceDao.queryCstServicePager(cstService, pageBean,startTime, endTime);
	}

}
