package com.zking.crm.reporting.dao;
/**
 * 	报表接口
 * @author Administrator
 *
 */

import java.util.List;

import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.entity.CstService;
import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;

public interface IReportingDao {
	/**
	 * 	贡献报表
	 * @param odrCustomer
	 * @param odrDate
	 * @return
	 * @throws Exception
	 */
	public List<Orders> contributeReporting(Orders orders) throws Exception;
	
	/**
	 * 	客户构造报表
	 * @param cstCustomer
	 * @return
	 * @throws Exception
	 */
	public List<CstCustomer> structureReporting (CstCustomer cstCustomer) throws Exception;
	/**
	 * 	服务报表
	 * @param cstService
	 * @return
	 * @throws Exception
	 */
	public List<CstService> serviceReporting(CstService cstService) throws Exception;
	/**
	 * 	流失报表
	 * @param cstLost
	 * @return
	 * @throws Exception
	 */
	public List<CstLost> cstLostReporting(CstLost cstLost) throws Exception;
}
