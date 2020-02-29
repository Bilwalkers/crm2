package com.zking.crm.custmer.biz.impl;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstCustomerBiz;

class CstCustomerBizImplTest {

	ICstCustomerBiz cstCustomerBiz;
	
	CstCustomer cstCustomer=null;
	
	@BeforeEach
	void setUp() throws Exception {
		cstCustomer = new CstCustomer();
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		cstCustomerBiz=ac.getBean("cstCustomerBiz",ICstCustomerBiz.class);
	}

	@Test
	void testAddCstCustomer() throws Exception {
		cstCustomer.setCustName("天代码");
		cstCustomer.setCustStatus("1");
		cstCustomerBiz.addCstCustomer(cstCustomer);
	}

	@Test
	void testDelCstCustomer() throws Exception {
		cstCustomer.setCustNo("32j2jd");
		cstCustomerBiz.delCstCustomer(cstCustomer);
	}

	@Test
	void testEditCstCustomer() throws Exception {
		cstCustomer.setCustNo("32j2jd");
		cstCustomer.setCustName("天机");
		cstCustomer.setCustStatus("2");
		cstCustomerBiz.editCstCustomer(cstCustomer);
	}

	@Test
	void testByEditCstCustomer() throws Exception {
		cstCustomer.setCustNo("8423sj2302jksd323232n2k23n232234");
		cstCustomer.setCustName("环保有限公司");
		cstCustomer.setCustStatus("2");
		cstCustomerBiz.ByeditCstCustomer(cstCustomer);
	}
	
	@Test
	void testByCstCustomer() throws Exception {
		cstCustomer.setCustNo("4028ab8b6c46ee86016c46ee8d6d0000");
		CstCustomer bcm = cstCustomerBiz.byCstCustomer(cstCustomer);
		System.out.println(bcm);
	}

	@Test
	void testQueryCstCustomerPager() throws Exception {
		PageBean pageBean = new PageBean();
		List<CstCustomer> cstCustomers = cstCustomerBiz.queryCstCustomerPager(cstCustomer, pageBean);
		for (CstCustomer ctm : cstCustomers) {
			System.out.println(ctm);
		}
	}

}
