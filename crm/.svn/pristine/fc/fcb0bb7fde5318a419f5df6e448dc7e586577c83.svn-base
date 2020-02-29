package com.zking.crm.custmer.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.custmer.dao.IOrdersDao;

public class OrdersDaoImpl extends BaseDao implements IOrdersDao {

	@Override
	public void addOrders(Orders orders) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delOrders(Orders orders) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void editOrders(Orders orders) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Orders byOrders(Orders orders) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> queryOrdersPager(Orders orders, PageBean pageBean, String startTime, String endTime) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Orders>>() {

			@Override
			public List<Orders> doInHibernate(Session session) throws HibernateException {
				String hql="from Orders where 1=1";
				if(StringUtils.isNotBlank(orders.getOdrCustomer())) {
					hql+=" and odr_customer like '%"+orders.getOdrCustomer()+"%'";
				}
				if(StringUtils.isNotBlank(orders.getOdrStatus())) {
					hql+=" and odr_status like '%"+orders.getOdrStatus()+"%'";
				}
				if(null!=startTime && null!=endTime) {
					hql += " and odr_date >= '"+startTime+"' AND odr_date <= '"+endTime+"'";
				}
				hql+=" order by odr_id desc";
				
				Query<Orders> query = session.createQuery(hql, Orders.class);
				
				if(pageBean.isPagination()) {
					String hql2="select count(odr_id) from Orders where 1=1";
					if(StringUtils.isNotBlank(orders.getOdrCustomer())) {
						hql+=" and odr_customer like '%"+orders.getOdrCustomer()+"%'";
					}
					if(StringUtils.isNotBlank(orders.getOdrStatus())) {
						hql+=" and odr_status like '%"+orders.getOdrStatus()+"%'";
					}
					if(null!=startTime && null!=endTime) {
						hql += " and odr_date >= '"+startTime+"' AND odr_date <= '"+endTime+"'";
					}
					Query query2 = session.createQuery(hql2);
					List list = query2.list();
					if(null!=list&0!=list.size()) {
						pageBean.setTotal(Integer.valueOf(list.get(0).toString()));
						
					}
				}
				query.setFirstResult(pageBean.getStartIndex());
				query.setMaxResults(pageBean.getRows());
				return query.list();
			}
		});
	}
	

}
