package com.zking.crm.custmer.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.entity.OrdersLine;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.IOrdersLineBiz;

public class OrdersLineAction extends BaseAction implements ModelDriven<OrdersLine> {

	private OrdersLine ordersLine = new OrdersLine();
	private IOrdersLineBiz ordersLineBiz;
	

	
	public IOrdersLineBiz getOrdersLineBiz() {
		return ordersLineBiz;
	}



	public void setOrdersLineBiz(IOrdersLineBiz ordersLineBiz) {
		this.ordersLineBiz = ordersLineBiz;
	}



	@Override
	public OrdersLine getModel() {
		return ordersLine;
	}

	/**
	 * 查询所有单个订单的明细
	 * @return
	 */
	public String queryOrdersPager() {
		/*try {
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<OrdersLine> ode = ordersLineBiz.queryOrdersLinePager(ordersLine, pageBean);
			super.toJSONPager("ok", true, pageBean.getTotal(), ode);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;*/
		
		try {
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<Map> list = ordersLineBiz.queryOrdersLinePager(ordersLine,pageBean);
			//计算 总金额
			for (Map map : list) {
				System.out.println(map);
				map.put("sumPrice", Integer.valueOf(map.get("odd_count").toString()) * Float.valueOf(map.get("odd_price").toString()));
			}

			//super.toJSONPager(response, pageBean.getTotal(), list, true, "OK");
			super.toJSONPager("OK", true, pageBean.getTotal(), list);
		} catch (Exception e) {
			//CommonUtils.toJSONPager(response, 0, null, true, "NO OK");
			super.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	
}
