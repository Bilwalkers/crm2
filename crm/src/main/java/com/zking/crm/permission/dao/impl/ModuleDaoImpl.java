package com.zking.crm.permission.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.Module;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.entity.User;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.permission.dao.IModuleDao;

public class ModuleDaoImpl extends BaseDao implements IModuleDao {

	@Override
	public List<Module> queryRootNode(Module module) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Module>>() {
			@Override
			public List<Module> doInHibernate(Session session) throws HibernateException {
				String hql="from Module where pid=-1";
				Query<Module> query = session.createQuery(hql,Module.class);
				List<Module> list = query.list();
				for (Module mod : list) {
					queryModuleByPid(mod.getId(), mod);
				}
				return list;
				/*String sql = "select m.* from t_role r,t_role_module rm,t_module m "
						+ "where r.roleid=rm.roleid and rm.moduleid=m.id and r.roleid='" + module.getRoleid() + "'";
				List<Module> lst = session.createNativeQuery(sql, Module.class).list();
				for (Module mod : lst) {
					queryModuleByPid(mod.getId(), mod);
				}
				return lst;*/
			}
		});

	}

	@Override
	public void queryModuleByPid(Integer pid, Module module) {
		List<Module> lst = super.getHibernateTemplate().execute(new HibernateCallback<List<Module>>() {

			@Override
			public List<Module> doInHibernate(Session session) throws HibernateException {
				String hql = "from Module where pid=:pid";
				Query<Module> query = session.createQuery(hql, Module.class);
				query.setParameter("pid", pid);
//				System.out.println(pid+"pppppp");
				List<Module> list = query.list();
				for (Module mod : list) {
					// 暂时不用
//					queryModuleByPid(mod.getId(), mod);
				}
				return list;
			}
		});
		module.setChildren(lst);
	}

	@Override
	public List<Module> queryModuleAuth() {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Module>>() {
			public List<Module> doInHibernate(Session session) throws HibernateException {
				String hql = "from Module where pid=99";
				Query<Module> query = session.createQuery(hql, Module.class);
				return query.list();
			}
		});
	}

	@Override
	public List<Module> queryModuleByPid(Module module) {
		super.getHibernateTemplate().execute(new HibernateCallback<List<Module>>() {
			public List<Module> doInHibernate(Session session) throws HibernateException {
				String hql = "from Module where pid=:pid";
				Query<Module> query = session.createQuery(hql, Module.class);
				query.setParameter("pid", module.getPid());
//				query.setParameter("id", module.getId());
				return query.list();
			}
		});
		return null;
	}

	@Override
	/*public List<Tree> queryModuleByUserId(String userid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Tree>>() {
			List<Tree> lst = new ArrayList<Tree>();

			public List<Tree> doInHibernate(Session session) throws HibernateException {
				String sql = "select m.id,m.pid,m.text from t_user u,t_user_role ur,t_role_module rm,t_module m "
						+ " where u.id=ur.userid and ur.roleid=rm.roleid and rm.moduleid=m.id and u.id='" + userid
						+ "'";
				Query query = session.createNativeQuery(sql);
				List list = query.list();
				for (int i = 0; i < list.size(); i++) {
					// 将集合转为object数组 并获取到每一行的元素
					Object[] obj = (Object[]) list.get(i);
					Tree mod = new Tree((Integer) obj[0], (Integer) obj[1], (String) obj[2]);
					lst.add(mod);
				}
				return lst;
			}
		});
	}*/

	
	public List<Module> queryModuleByUserId(String userid) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Module>>() {

			public List<Module> doInHibernate(Session session) throws HibernateException {
				String sql = "select m.* from t_user u,t_user_role ur,t_role_module rm,t_module m "
						+ " where u.id=ur.userid and ur.roleid=rm.roleid and rm.moduleid=m.id and u.id='" + userid
						+ "'";
				Query<Module> query = session.createNativeQuery(sql,Module.class);
				List<Module> list = query.list();
				/*for (Module mod : list) {
					queryModuleByPid(mod.getId(), mod);
				}*/
				return list;
			}
		});
	}
}
