package com.zking.crm.custmer.biz;

import java.util.List;

import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;

/**
 * 历史订单
 * @author Admin
 *
 */
public interface IOrdersBiz {

	/**
	 * 增加
	 * @param orders
	 */
	public void addOrders(Orders orders) throws Exception;
	/**
	 * 删除
	 * @param orders
	 */
	public void delOrders(Orders orders) throws Exception;
	/**
	 * 修改
	 * @param orders
	 */
	public void editOrders(Orders orders) throws Exception;
	/**
	 * 查询单个
	 * @param orders
	 * @return
	 */
	public Orders byOrders(Orders orders) throws Exception;
	/**
	 * 查询所有（分页）
	 * @param orders
	 * @param pageBean
	 * @return
	 */
	public List<Orders> queryOrdersPager(Orders orders,PageBean pageBean, String startTime, String endTime) throws Exception;
}
