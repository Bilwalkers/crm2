package com.zking.crm.custmer.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.CstLinkman;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.custmer.dao.ICstLinkmanDao;

public class CstLinkmanDaoImpl extends BaseDao implements ICstLinkmanDao {

	@Override
	public void addCstLinkman(CstLinkman cstLinkman) throws Exception {
		this.getHibernateTemplate().save(cstLinkman);
	}

	@Override
	public void delCstLinkman(CstLinkman cstLinkman) throws Exception {
		this.getHibernateTemplate().delete(cstLinkman);
	}

	@Override
	public void editCstLinkman(CstLinkman cstLinkman) throws Exception {
		this.getHibernateTemplate().update(cstLinkman);
	}

	@Override
	public CstLinkman byCstLinkman(CstLinkman cstLinkman) throws Exception {
		CstLinkman ckm = this.getHibernateTemplate().get(CstLinkman.class, cstLinkman.getLkmId());
		return ckm;
	}

	@Override
	public List<CstLinkman> queryCstLinkmanPager(CstLinkman cstLinkman, PageBean pageBean) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<CstLinkman>>() {

			@Override
			public List<CstLinkman> doInHibernate(Session session) throws HibernateException {
				String hql="from CstLinkman where 1=1";
				if(StringUtils.isNotBlank(cstLinkman.getLkmCustNo())) {
					hql+=" and lkm_cust_no like '%"+cstLinkman.getLkmCustNo()+"%'";
				}
				if(StringUtils.isNotBlank(cstLinkman.getLkmCustName())) {
					hql+=" and lkm_cust_name like '%"+cstLinkman.getLkmCustName()+"%'";
				}
				if(StringUtils.isNotBlank(cstLinkman.getLkmName())) {
					hql+=" and lkm_name like '%"+cstLinkman.getLkmName()+"%'";
				}
				if(StringUtils.isNotBlank(cstLinkman.getLkmSex())) {
					hql+=" and lkm_sex like '%"+cstLinkman.getLkmSex()+"%'";
				}
				if(StringUtils.isNotBlank(cstLinkman.getLkmPostion())) {
					hql+=" and lkm_postion like '%"+cstLinkman.getLkmPostion()+"%'";
				}
				hql+=" order by lkm_id desc";
				
				Query<CstLinkman> query = session.createQuery(hql, CstLinkman.class);
				
				if(pageBean.isPagination()) {
					String hql2="select count(lkm_id) from CstLinkman where 1=1";
					if(StringUtils.isNotBlank(cstLinkman.getLkmCustNo())) {
						hql+=" and lkm_cust_no like '%"+cstLinkman.getLkmCustNo()+"%'";
					}
					if(StringUtils.isNotBlank(cstLinkman.getLkmCustName())) {
						hql+=" and lkm_cust_name like '%"+cstLinkman.getLkmCustName()+"%'";
					}
					if(StringUtils.isNotBlank(cstLinkman.getLkmName())) {
						hql+=" and lkm_name like '%"+cstLinkman.getLkmName()+"%'";
					}
					if(StringUtils.isNotBlank(cstLinkman.getLkmSex())) {
						hql+=" and lkm_sex like '%"+cstLinkman.getLkmSex()+"%'";
					}
					if(StringUtils.isNotBlank(cstLinkman.getLkmPostion())) {
						hql+=" and lkm_postion like '%"+cstLinkman.getLkmPostion()+"%'";
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
