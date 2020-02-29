package com.zking.crm.reporting.biz.impl;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.entity.CstService;
import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.reporting.biz.IReportingBiz;

class ReportingBizImplTest {
	
	private IReportingBiz reportingBiz;
	Orders orders = new Orders();
	CstCustomer cstCustomer = new CstCustomer();
	CstService cstService = new CstService();
	CstLost cstLost = new CstLost();
	@BeforeEach
	void setUp() throws Exception {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		reportingBiz = ac.getBean("reportingBiz",IReportingBiz.class);
	}

	@Test
	void testContributeReporting() throws Exception {
//		pageBean.setPagination(false);
		List<Orders> order = reportingBiz.contributeReporting(orders);
		for (Orders o : order) {
			System.out.println(o);
		}
	}
	@Test
	void textStructureReporting() throws Exception{
		cstCustomer.setDictType("企业客户等级");
		cstCustomer.setWay("cust_level");
		List<CstCustomer> stur = reportingBiz.structureReporting(cstCustomer);
		for (CstCustomer cst : stur) {
			System.out.println(cst);
		}
	}
	@Test
	void serviceReporting() throws Exception{
		cstService.setSerTime("2019");
		List<CstService> service = reportingBiz.serviceReporting(cstService);
		for (CstService cst : service) {
			System.out.println(cst);
		}
	}
	@Test
	void cstLostReporting() throws Exception{
		cstLost.setLstCustName("按");
		List<CstLost> lost = reportingBiz.cstLostReporting(cstLost);
		for (Object c : lost) {
			System.out.println(c);
		}
	}

}
