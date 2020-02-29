package com.zking.crm.custmer.biz.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstLostBiz;

class CstLostBizImplTest {

	ICstLostBiz cstLostBiz;
	CstLost cstLost=null;
	
	@BeforeEach
	void setUp() throws Exception {
		cstLost = new CstLost();
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		cstLostBiz= ac.getBean("cstLostBiz",ICstLostBiz.class);
	}

	@Test
	void testAddCstLost() throws Exception {
		cstLost.setLstCustNo("3dn3nwkqw32");
		cstLost.setLstCustName("第三款");
		cstLost.setLstCustManagerId("dshdsd");
		cstLost.setLstCustManagerName("小天");
		cstLost.setLstStatus("2");
		cstLostBiz.addCstLost(cstLost);
	}

	@Test
	void testDelCstLost() throws Exception {
		cstLost.setLstId(1);
		cstLostBiz.delCstLost(cstLost);
	}

	@Test
	void testEditCstLost() throws Exception {
		cstLost.setLstId(4);
		cstLost.setLstStatus("2");
		cstLost.setLstDelay("圣马可");
		System.out.println("============================="+cstLost);
		cstLostBiz.editCstLost(cstLost);
	}

	@Test
	void testByCstLost() throws Exception {
		cstLost.setLstId(2);
		CstLost lost = cstLostBiz.byCstLost(cstLost);
		System.out.println(lost);
	}

	@Test
	void testQueryCstLostPager() throws Exception {
		System.out.println("===================获取当前时间====================");
		System.out.println("dsdjf"+new Timestamp(System.currentTimeMillis()));
		PageBean pageBean = new PageBean();
		List<CstLost> cstLosts = cstLostBiz.queryCstLostPager(cstLost, pageBean);
		for (CstLost cst : cstLosts) {
			System.out.println(cst);
		}
	}

}
