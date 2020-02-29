package com.zking.crm.custmer.biz.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.IOrdersBiz;

class OrdersBizImplTest {

	IOrdersBiz ordersBiz;
	Orders orders=null;
	
	@BeforeEach
	void setUp() throws Exception {
		orders = new Orders();
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ordersBiz = ac.getBean("ordersBiz",IOrdersBiz.class);
	}

	@Test
	void testQueryOrdersPager() throws Exception {
		PageBean pageBean = new PageBean();
		/*List<Orders> order = ordersBiz.queryOrdersPager(orders, pageBean);
		for (Orders ods : order) {
			System.out.println(ods);
		}*/
	}

}
