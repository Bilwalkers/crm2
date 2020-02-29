package com.zking.crm.reporting.dao.impl;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.entity.CstService;
import com.zking.crm.base.entity.Orders;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.reporting.dao.IReportingDao;
/**
 *	报表 实现类
 * @author Administrator
 *
 */
public class ReportingDaoImpl extends BaseDao implements IReportingDao {
	/**
	 * 	贡献报表
	 */
	@Override
	public List<Orders> contributeReporting(Orders orders) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Orders>>() {
			List<Orders> list = new ArrayList<Orders>();
			@Override
			public List<Orders> doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT u.odr_id,u.odr_customer,b.odd_price FROM orders u,orders_line b WHERE u.odr_id=b.odd_order_id";
				if(StringUtils.isNotBlank(orders.getOdrCustomer())) {
					sql+= " AND odr_customer LIKE '%"+orders.getOdrCustomer()+"%'";
				}
				if(null != orders.getOrdersTime()) {
					sql += " AND odr_date LIKE '%"+orders.getOrdersTime()+"%'";
				}
				sql += " ORDER BY odd_price DESC";
				NativeQuery query2 = session.createNativeQuery(sql);
				List<Object> emps = query2.list();
				//遍历结果集
				for (int i = 0; i < emps.size(); i++) {
					//将集合转为object数组 并获取到每一行的元素
					Object[] obj = (Object[])emps.get(i);
					//给每个元素赋值 相应的实体类
					Orders o= new Orders((Integer)obj[0], (String)obj[1], (Float)obj[2]);
					list.add(o);
				}
				return list;
			}
		});
	}
	/**
	 *  构造报表
	 */
	@Override
	public List<CstCustomer> structureReporting(CstCustomer cstCustomer) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<CstCustomer>>() {
			List<CstCustomer> list = new ArrayList<CstCustomer>();
			@Override
			public List<CstCustomer> doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT bk.dict_item,COUNT(1) FROM"
						 + " (SELECT  b.dict_item,c.*,b.dict_value FROM cst_customer c, bas_dict b"
						 + " WHERE b.dict_type like '%"+cstCustomer.getDictType()+"%' AND b.dict_value=c."+cstCustomer.getWay()+") bk"
						 + " GROUP BY "+cstCustomer.getWay()+" ORDER BY dict_value DESC";
				NativeQuery query2 = session.createNativeQuery(sql);
				List<Object> emps = query2.list();
				//遍历结果集
				for (int i = 0; i < emps.size(); i++) {
					//将集合转为object数组 并获取到每一行的元素
					Object[] obj = (Object[])emps.get(i);
					//给每个元素赋值 相应的实体类
					CstCustomer c= new CstCustomer((String)obj[0], (BigInteger)obj[1]);
					list.add(c);
				}
				return list;
			}
		});
	}
	/**
	 * 	服务报表
	 */
	@Override
	public List<CstService> serviceReporting(CstService cstService) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<CstService>>() {
			List<CstService> list = new ArrayList<CstService>();
			@Override
			public List<CstService> doInHibernate(Session session) throws HibernateException {
				String sql =  "SELECT bk.dict_item,COUNT(1) FROM (SELECT  b.dict_item,b.dict_value,c.* "
							+ "FROM cst_service c, bas_dict b WHERE b.dict_type='服务类型' AND b.dict_value=c.svr_type"
							+ " AND svr_create_date LIKE '%"+cstService.getSerTime()+"%') bk GROUP BY dict_value";
				NativeQuery query2 = session.createNativeQuery(sql);
				List<Object> emps = query2.list();
				//遍历结果集
				for (int i = 0; i < emps.size(); i++) {
					//将集合转为object数组 并获取到每一行的元素
					Object[] obj = (Object[])emps.get(i);
					//给每个元素赋值 相应的实体类
					CstService c= new CstService((String)obj[0], (BigInteger)obj[1]);
					list.add(c);
				}
				return list;
			}

		});
	}
	/**
	 * 	流失报表
	 */
	@Override
	public List<CstLost> cstLostReporting(CstLost cstLost) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<CstLost>>() {
			@Override
			public List<CstLost> doInHibernate(Session session) throws HibernateException {
				String hql =" FROM CstLost WHERE lstStatus = 3";
				if(StringUtils.isNotBlank(cstLost.getLstCustName())) {
					hql += " and lstCustName like '%"+cstLost.getLstCustName()+"%'";
				}
				if(StringUtils.isNotBlank(cstLost.getLstCustManagerName())) {
					hql += " and lstCustManagerName like '%"+cstLost.getLstCustManagerName()+"%'";
				}
				hql += " ORDER BY lst_id DESC";
				
				Query<CstLost> query = session.createQuery(hql,CstLost.class);
				
				List<CstLost> list = query.list();
				
				return list;
			}
		});
	}
	

}
