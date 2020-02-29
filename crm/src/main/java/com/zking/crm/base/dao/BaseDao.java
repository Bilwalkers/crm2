package com.zking.crm.base.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zking.crm.base.util.PageBean;


public abstract class BaseDao extends HibernateDaoSupport {

	public Session getSession() {
		return (Session) SessionFactoryUtils.getDataSource(this.getSessionFactory());
	}
	
	/**
	 * 设置Query的查询参数
	 * @param params
	 * @param query
	 * @return
	 */
	public void setParamters(Map<String,Object> params,Query query) {
		if(null==params||0==params.size())
			return;
		
		Set<Entry<String, Object>> set = params.entrySet();
		String name=null;
		Object value=null;
		for (Entry<String, Object> entry : set) {
			name=entry.getKey();
			value=entry.getValue();
			//判断参数是否是Collection，一般用于List/Set集合参数时使用
			if(value instanceof Collection)
				query.setParameterList(name, (Collection)value);
			//判断参数是否是Object[]
			else if(value instanceof Object[]) 
				query.setParameterList(name, (Object[])value);
			else 
				query.setParameter(name, value);
		}
	}
	
	/**
	 * 将普通hql语句转换成查询总记录数的hql语句
	 * @param hql
	 * @return
	 */
	public String countSql(String hql) {
		//from Book
		//select * from Book
		int start=hql.toUpperCase().indexOf("FROM");
		return "select count(1) "+hql.substring(start);
	}
	
	/**
	 * 查询(支持分页)
	 * @param hql       普通hql语句
	 * @param params    请求参数
	 * @param pageBean  分页对象
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List executeQuery(String hql,Map<String,Object> params,PageBean pageBean) {
		Session session=getSession();
		Query query=null;
		//1.根据满足条件查询总记录数
		if(null!=pageBean&&pageBean.isPagination()) {
			//select count(1) from Book where 
			String countHql=this.countSql(hql);
			query = session.createQuery(countHql);
			this.setParamters(params, query);
		}
		query=session.createQuery(hql);
		//2.根据满足条件查询分页记录
		if(null!=pageBean&&pageBean.isPagination()) {
			query.setFirstResult(pageBean.getStartIndex());
			query.setMaxResults(pageBean.getRows());
		}
		this.setParamters(params, query);
		return query.list();
	}
}
