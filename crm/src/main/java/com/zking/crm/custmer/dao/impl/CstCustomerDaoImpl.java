package com.zking.crm.custmer.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.custmer.dao.ICstCustomerDao;

public class CstCustomerDaoImpl extends BaseDao implements ICstCustomerDao {

	@Override
	public void addCstCustomer(CstCustomer cstCustomer) throws Exception {
		this.getHibernateTemplate().save(cstCustomer);
	}

	@Override
	public void delCstCustomer(CstCustomer cstCustomer) throws Exception {
		//慎重，客户删除在客户流失确定才有这功能
		this.getHibernateTemplate().delete(cstCustomer);
	}

	@Override
	public void editCstCustomer(CstCustomer cstCustomer) throws Exception {
		this.getHibernateTemplate().update(cstCustomer);
	}
	
	
	@Override
	public CstCustomer byCstCustomer(CstCustomer cstCustomer) throws Exception {
		//根据字符串查询
		CstCustomer customer = this.getHibernateTemplate().get(CstCustomer.class, cstCustomer.getCustNo());
		return customer;
	}

	@Override
	public List<CstCustomer> queryCstCustomerPager(CstCustomer cstCustomer, PageBean pageBean) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<CstCustomer>>() {

			@Override
			public List<CstCustomer> doInHibernate(Session session) throws HibernateException {
				String hql="from CstCustomer where 1=1";
				if(StringUtils.isNotBlank(cstCustomer.getCustName())) {
					hql+=" and cust_name like '%"+cstCustomer.getCustName()+"%'";
				}
				if(StringUtils.isNotBlank(cstCustomer.getCustManagerName())) {
					hql+=" and cust_manager_name like '%"+cstCustomer.getCustManagerName()+"%'";
				}
				if(StringUtils.isNotBlank(cstCustomer.getCustRegion())) {
					hql+=" and cust_region like '%"+cstCustomer.getCustRegion()+"%'";
				}
				if(StringUtils.isNotBlank(cstCustomer.getCustStatus())) {
					hql+=" and cust_status like '%"+cstCustomer.getCustStatus()+"%'";
				}
				Query<CstCustomer> query = session.createQuery(hql,CstCustomer.class);
				if(pageBean.isPagination()) {
					String hql2="select count(1) from CstCustomer where 1=1";
					if(StringUtils.isNotBlank(cstCustomer.getCustName())) {
						hql+=" and cust_name like '%"+cstCustomer.getCustName()+"%'";
					}
					if(StringUtils.isNotBlank(cstCustomer.getCustManagerName())) {
						hql+=" and cust_manager_name like '%"+cstCustomer.getCustManagerName()+"%'";
					}
					if(StringUtils.isNotBlank(cstCustomer.getCustRegion())) {
						hql+=" and cust_region like '%"+cstCustomer.getCustRegion()+"%'";
					}
					if(StringUtils.isNotBlank(cstCustomer.getCustStatus())) {
						hql+=" and cust_status like '%"+cstCustomer.getCustStatus()+"%'";
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

	@Override
	public void ByeditCstCustomer(CstCustomer cstCustomer) throws Exception {
		this.getHibernateTemplate().execute(new HibernateCallback<CstCustomer>() {

			@Override
			public CstCustomer doInHibernate(Session session) throws HibernateException {
				//String sql="update cst_customer set cust_status='"+cstCustomer.getCustStatus()+"' where cust_no like '%"+cstCustomer.getCustNo()+"%' and cust_name like '%"+cstCustomer.getCustName()+"%' ";
				String sql="update cst_customer set cust_status=? where cust_no like ? and cust_name like ? ";
				session.createSQLQuery(sql).setParameter(0, cstCustomer.getCustStatus()).setParameter(1, cstCustomer.getCustNo()).setParameter(2, cstCustomer.getCustName()).executeUpdate();
				return null;
			}
			
		});
	}
	

}
