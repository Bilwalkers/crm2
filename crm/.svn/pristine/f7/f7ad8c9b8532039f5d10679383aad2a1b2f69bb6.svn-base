package com.zking.crm.custmer.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.IOrdersBiz;

public class OrdersAction extends BaseAction implements ModelDriven<Orders> {

	private Orders orders = new Orders();
	private IOrdersBiz ordersBiz;
	
	
	
	public IOrdersBiz getOrdersBiz() {
		return ordersBiz;
	}



	public void setOrdersBiz(IOrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
	}



	@Override
	public Orders getModel() {
		return orders;
	}

	/**
	 * 查询所有历史订单信息
	 * @return
	 */
	public String queryOrdersPager() {
		try {
			String startTime=request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<Orders> ods = null;
			if(startTime!="") {
				ods = ordersBiz.queryOrdersPager(orders, pageBean,startTime,"3000-01-01");
			}
			if(endTime!="") {
				ods = ordersBiz.queryOrdersPager(orders, pageBean,"2000-01-01",endTime);
			}
			if(startTime!=""&&endTime!="") {
				ods = ordersBiz.queryOrdersPager(orders, pageBean,startTime,endTime);
			}
			if(startTime==""&&endTime=="") {
				ods = ordersBiz.queryOrdersPager(orders, pageBean,"1000-01-01","3000-01-01");
			}
			for (Orders or : ods) {
				if(or.getOdrStatus().equals("a")) {
					or.setOdrStatus("已回款");
				}else if(or.getOdrStatus().equals("b")) {
					or.setOdrStatus("未回款");
				}
			}
				
			super.toJSONPager("ok", true, pageBean.getTotal(), ods);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	
}
