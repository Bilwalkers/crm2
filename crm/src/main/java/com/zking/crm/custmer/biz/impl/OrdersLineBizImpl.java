package com.zking.crm.custmer.biz.impl;

import java.util.List;
import java.util.Map;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.OrdersLine;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.IOrdersLineBiz;
import com.zking.crm.custmer.dao.IOrdersLineDao;

public class OrdersLineBizImpl extends BaseBiz implements IOrdersLineBiz {

	private IOrdersLineDao ordersLineDao;
	
	
	public IOrdersLineDao getOrdersLineDao() throws Exception {
		return ordersLineDao;
	}

	public void setOrdersLineDao(IOrdersLineDao ordersLineDao) throws Exception {
		this.ordersLineDao = ordersLineDao;
	}

	@Override
	public void addOrdersLine(OrdersLine ordersLine) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delOrdersLine(OrdersLine ordersLine) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void editOrdersLine(OrdersLine ordersLine) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public OrdersLine byOrdersLine(OrdersLine ordersLine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map> queryOrdersLinePager(OrdersLine ordersLine, PageBean pageBean) throws Exception {
		return ordersLineDao.queryOrdersLinePager(ordersLine, pageBean);
	}

	
}
