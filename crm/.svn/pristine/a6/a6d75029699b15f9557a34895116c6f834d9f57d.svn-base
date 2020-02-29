package com.zking.crm.custmer.biz.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.OrdersLine;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.IOrdersLineBiz;

class OrdersLineBizImplTest {

	IOrdersLineBiz ordersLineBiz;
	OrdersLine ordersLine=null;
	
	
	@BeforeEach
	void setUp() throws Exception {
		ordersLine = new OrdersLine();
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ordersLineBiz = ac.getBean("ordersLineBiz",IOrdersLineBiz.class);
	}

	@Test
	void testQueryOrdersLinePager() throws Exception {
		PageBean pageBean = new PageBean();
		List<Map> ordersLines = ordersLineBiz.queryOrdersLinePager(ordersLine, pageBean);
	}

}
