package com.zking.crm.custmer.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.custmer.dao.ICstLostDao;

public class CstLostDaoImpl extends BaseDao implements ICstLostDao {

	@Override
	public void addCstLost(CstLost cstLost) throws Exception {
		this.getHibernateTemplate().save(cstLost);
	}

	@Override
	public void delCstLost(CstLost cstLost) throws Exception {
		this.getHibernateTemplate().delete(cstLost);
	}

	@Override
	public void editCstLost(CstLost cstLost) throws Exception {
		this.getHibernateTemplate().execute(new HibernateCallback<CstLost>() {

			@Override
			public CstLost doInHibernate(Session session) throws HibernateException {
				if(cstLost.getLstStatus().equals("2")) {
					String sql="update cst_lost set lst_delay=?,lst_status=? where lst_id=?";
					session.createSQLQuery(sql).setParameter(0, cstLost.getLstDelay()).setParameter(1, cstLost.getLstStatus()).setParameter(2, cstLost.getLstId()).executeUpdate();
				}else if(cstLost.getLstStatus().equals("3")) {
					String sql="update cst_lost set lst_lost_date=?,lst_reason=?,lst_status=? where lst_id=?";
					session.createSQLQuery(sql).setParameter(0, new Timestamp(System.currentTimeMillis())).setParameter(1, cstLost.getLstReason()).setParameter(2, cstLost.getLstStatus()).setParameter(3, cstLost.getLstId()).executeUpdate();
				}
				
				return null;
			}
		});
		
	}

	@Override
	public CstLost byCstLost(CstLost cstLost) throws Exception {
		CstLost cst = this.getHibernateTemplate().get(CstLost.class, cstLost.getLstId());
		return cst;
	}

	@Override
	public List<CstLost> queryCstLostPager(CstLost cstLost, PageBean pageBean) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<CstLost>>() {

			@Override
			public List<CstLost> doInHibernate(Session session) throws HibernateException {
				String hql="from CstLost where 1=1";
				if(StringUtils.isNotBlank(cstLost.getLstCustName())) {
					hql+=" and lst_cust_name like '%"+cstLost.getLstCustName()+"%'";
				}
				if(StringUtils.isNotBlank(cstLost.getLstCustManagerName())) {
					hql+=" and lst_cust_manager_name like '%"+cstLost.getLstCustManagerName()+"%'";
				}
				if(StringUtils.isNotBlank(cstLost.getLstStatus())) {
					hql+=" and lst_Status like '%"+cstLost.getLstStatus()+"%'";
				}
				hql+=" order by lst_id desc";
				Query<CstLost> query = session.createQuery(hql, CstLost.class);
				
				if(pageBean.isPagination()) {
					String hql2="select count(lst_id) from CstLost where 1=1";
					if(StringUtils.isNotBlank(cstLost.getLstCustName())) {
						hql+=" and lst_cust_name like '%"+cstLost.getLstCustName()+"%'";
					}
					if(StringUtils.isNotBlank(cstLost.getLstCustManagerName())) {
						hql+=" and lst_cust_manager_name like '%"+cstLost.getLstCustManagerName()+"%'";
					}
					if(StringUtils.isNotBlank(cstLost.getLstStatus())) {
						hql+=" and lst_Status like '%"+cstLost.getLstStatus()+"%'";
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
