package com.zking.crm.custmer.biz.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.CstActivity;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstActivityBiz;

class CstActivityBizImplTest {

	ICstActivityBiz cstActivityBiz;
	
	CstActivity cstActivity=null;
	
	private 
	@BeforeEach
	void setUp() throws Exception {
		cstActivity = new CstActivity();
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		cstActivityBiz=ac.getBean("cstActivityBiz",ICstActivityBiz.class);
	}

	@Test
	void testAddCstActivity() throws Exception {
		cstActivity.setAtvPlace("梅溪湖");
		cstActivity.setAtvTitle("交接活动");
		cstActivityBiz.addCstActivity(cstActivity);
	}

	@Test
	void testDelCstActivity() throws Exception {
		cstActivity.setAtvId(2);
		cstActivityBiz.delCstActivity(cstActivity);
	}

	@Test
	void testEditCstActivity() throws Exception {
		cstActivity.setAtvId(3);
		cstActivity.setAtvCustName("小米");
		cstActivity.setAtvPlace("园路");
		cstActivity.setAtvTitle("团队活动");
		cstActivityBiz.editCstActivity(cstActivity);
	}

	@Test
	void testByCstActivity() throws Exception {
		cstActivity.setAtvId(1);
		CstActivity b = cstActivityBiz.byCstActivity(cstActivity);
		System.out.println(b);
	}

	@Test
	void testQueryCstActivityPager() throws Exception {
		/*PageBean pageBean = new PageBean();
		List<CstActivity> cstActivitys = cstActivityBiz.queryCstActivityPager(cstActivity, pageBean);
		for (CstActivity cst : cstActivitys) {
			System.out.println(cst);
		}*/
	}

}
