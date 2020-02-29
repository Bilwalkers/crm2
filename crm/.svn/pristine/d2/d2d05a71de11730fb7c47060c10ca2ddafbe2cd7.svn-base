package com.zking.crm.custmer.biz.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.CstLinkman;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstLinkmanBiz;

class CstLinkmanBizImplTest {

	ICstLinkmanBiz cstLinkmanBiz;
	CstLinkman cstLinkman=null;
	
	@BeforeEach
	void setUp() throws Exception {
		cstLinkman = new CstLinkman();
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		cstLinkmanBiz=ac.getBean("cstLinkmanBiz",ICstLinkmanBiz.class);
	}

	@Test
	void testAddCstLinkman() throws Exception {
		cstLinkman.setLkmCustNo("3244ds");
		cstLinkman.setLkmCustName("小合");
		cstLinkman.setLkmName("小记得及时");
		cstLinkman.setLkmTel("134274732932");
		cstLinkman.setLkmMobile("182439493822233");
		cstLinkmanBiz.addCstLinkman(cstLinkman);
	}

	@Test
	void testDelCstLinkman() throws Exception {
		cstLinkman.setLkmId(2);
		cstLinkmanBiz.delCstLinkman(cstLinkman);
	}

	@Test
	void testEditCstLinkman() throws Exception {
		cstLinkman.setLkmId(1);
		cstLinkman.setLkmCustNo("3244ds");
		cstLinkman.setLkmCustName("小合");
		cstLinkman.setLkmName("虾米");
		cstLinkman.setLkmTel("134274732932");
		cstLinkman.setLkmMobile("182439493822233");
		cstLinkmanBiz.editCstLinkman(cstLinkman);
	}

	@Test
	void testByCstLinkman() throws Exception {
		cstLinkman.setLkmId(1);
		CstLinkman ckm = cstLinkmanBiz.byCstLinkman(cstLinkman);
		System.out.println(ckm);
	}

	@Test
	void testQueryCstLinkmanPager() throws Exception {
		PageBean pageBean = new PageBean();
		List<CstLinkman> cstLinkmans = cstLinkmanBiz.queryCstLinkmanPager(cstLinkman, pageBean);
		for (CstLinkman ckm : cstLinkmans) {
			System.out.println(ckm);
		}
	}

}
