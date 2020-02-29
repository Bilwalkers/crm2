package com.zking.crm.reporting.biz.impl;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.entity.CstService;
import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.reporting.biz.IReportingBiz;
import com.zking.crm.reporting.dao.IReportingDao;
/**
 *  报表biz 实现类
 * @author Administrator
 *
 */
public class ReportingBizImpl extends BaseBiz implements IReportingBiz {
	
	private IReportingDao reportingDao;
	public IReportingDao getReportingDao() {
		return reportingDao;
	}
	public void setReportingDao(IReportingDao reportingDao) {
		this.reportingDao = reportingDao;
	}

	/**
	 * 	贡献报表
	 */
	@Override
	public List<Orders> contributeReporting(Orders orders) throws Exception {
		return reportingDao.contributeReporting(orders);
	}
	/**
	 * 	构造报表
	 */
	@Override
	public List<CstCustomer> structureReporting(CstCustomer cstCustomer) throws Exception {
		return reportingDao.structureReporting(cstCustomer);
	}
	/**
	 * 	服务报表
	 */
	@Override
	public List<CstService> serviceReporting(CstService cstService) throws Exception {
		return reportingDao.serviceReporting(cstService);
	}
	/**
	 * 	流失报表
	 */
	@Override
	public List<CstLost> cstLostReporting(CstLost cstLost) throws Exception {
		return reportingDao.cstLostReporting(cstLost);
	}

}
