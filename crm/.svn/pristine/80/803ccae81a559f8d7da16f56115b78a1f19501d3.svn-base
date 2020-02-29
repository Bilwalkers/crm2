package com.zking.crm.permission.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.Role;
import com.zking.crm.base.entity.RoleModule;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.permission.dao.IRoleDao;

public class RoleDaoImpl extends BaseDao implements IRoleDao {

	@Override
	public void addRole(Role role) {
		super.getHibernateTemplate().save(role);
	}

	@Override
	public void delRole(Role role) {
		super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String sql1 = "delete from t_role where roleid = '" + role.getRoleid() + "'";
				NativeQuery query = session.createNativeQuery(sql1);
				int i = query.executeUpdate();
				String sql2 = "delete from t_role_module where roleid = '" + role.getRoleid() + "'";
				NativeQuery query2 = session.createNativeQuery(sql2);
				i = query2.executeUpdate();
				return i;
			}
		});
	}

	@Override
	public void editRole(Role role) {
		super.getHibernateTemplate().update(role);
	}

	@Override
	public List<Role> queryRolePager(Role role, PageBean pageBean) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Role>>() {
			public List<Role> doInHibernate(Session session) throws HibernateException {
				String hql = "from Role where 1=1 ";
				
				if (StringUtils.isNotBlank(role.getRolename())) {
					hql+=" and rolename like '%"+role.getRolename()+"%'";
				}
				if (pageBean.isPagination()) {
					String hql2 = "select count(1) from Role ";
					if (StringUtils.isNotBlank(role.getRolename())) {
						hql2 += " where rolename like '%" + role.getRolename() + "%'";
					}
					List list = session.createQuery(hql2).list();
					if (null != list && 0 != list.size()) {
						// 获取总数 并赋值给total
						pageBean.setTotal(Integer.parseInt(list.get(0).toString()));
					}
				}
				Query<Role> query = session.createQuery(hql, Role.class);
				query.setFirstResult(pageBean.getStartIndex());
				query.setMaxResults(pageBean.getRows());
				return query.list();
			}
		});
	}

	@Override
	public void addRoleModule(RoleModule rm) {
		super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				String sql1 = "delete from t_role_module where roleid = '" + rm.getRoleid() + "'";
				NativeQuery query2 = session.createNativeQuery(sql1);
				int i = query2.executeUpdate();
				String sql = "insert into t_role_module(roleid,moduleid) values";
				String[] moduleids = rm.getModuleid().split(",");
				for (String moduleid : moduleids) {
					sql += "('" + rm.getRoleid() + "','" + moduleid + "'),";
				}
				// 最后一个逗号必须截取掉!!
				sql = sql.substring(0, sql.length() - 1);
				Query query = session.createNativeQuery(sql);
				i = query.executeUpdate();
				return i;
			}

		});
	}

	@Override
	public List<String> queryModuleRoleId(Role role) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<String>>() {
			public List<String> doInHibernate(Session session) throws HibernateException {
				List<String> list = new ArrayList<String>();
				String sql = "select moduleid from t_role_module where roleid = '" + role.getRoleid() + "'";
				NativeQuery query = session.createNativeQuery(sql);
				List lst = query.list();
				list.addAll(lst);
				return list;
			}
		});
	}

	public void queryModuleId() {

	}

	@Override
	public List<Role> queryRole(Role role) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Role>>() {
			public List<Role> doInHibernate(Session session) throws HibernateException {
				String hql="from Role";
				Query<Role> query = session.createQuery(hql,Role.class);
				return query.list();
			}
		});
	}

}
