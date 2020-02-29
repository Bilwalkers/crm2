package com.zking.crm.reporting.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.entity.CstService;
import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.reporting.biz.IReportingBiz;
/**
 * 	客户贡献报表action层
 * @author Administrator
 *
 */
public class ReportingAction extends BaseAction implements ModelDriven<Orders> {
	
	private Orders orders = new Orders();
	
	private IReportingBiz reportingBiz;

	@Override
	public Orders getModel() {
		return orders;
	}
	public IReportingBiz getReportingBiz() {
		return reportingBiz;
	}
	public void setReportingBiz(IReportingBiz reportingBiz) {
		this.reportingBiz = reportingBiz;
	}

	/**
	 * 	贡献报表
	 * @return
	 */
	public List<Orders> contributeReporting(){
		String ordersTime=request.getParameter("odrDate");
		orders.setOrdersTime(ordersTime);
		try {
			List<Orders> query = reportingBiz.contributeReporting(orders);
			this.toJSONPager("OK", true, 0, query);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	/**
	 * 	构成报表
	 * @return
	 */
	public List<CstCustomer> structureReporting(){
		CstCustomer cstCustomer = new CstCustomer();
		String dictType=request.getParameter("dictType");
		String way = request.getParameter("way");
		cstCustomer.setDictType(dictType);
		cstCustomer.setWay(way);
		try {
			List<CstCustomer> cst = reportingBiz.structureReporting(cstCustomer);
			this.toJSONPager("OK", true, 0, cst);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	/**
	 * 	服务报表
	 * @return
	 */
	public List<CstService> serviceReporting(){
		CstService cstService = new CstService();
		String serTime = request.getParameter("serTime");
		cstService.setSerTime(serTime);
		
		try {
			List<CstService> service = reportingBiz.serviceReporting(cstService);
			this.toJSONPager("OK", true, 0, service);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	/**
	 * 	流失报表
	 * @return
	 */
	public List<CstLost> cstLostReporting(){
		CstLost cstLost = new CstLost();
		String lstCustName = request.getParameter("lstCustName");
		String lstCustManagerName = request.getParameter("lstCustManagerName");
		cstLost.setLstCustName(lstCustName);
		cstLost.setLstCustManagerName(lstCustManagerName);
		try {
			List<CstLost> lost = reportingBiz.cstLostReporting(cstLost);
			this.toJSONPager("OK", true, 0, lost);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONPager(e.getMessage(), false, 0, null);
		}
		
		return null;
	}
}
