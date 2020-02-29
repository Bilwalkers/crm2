package com.zking.crm.permission.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.permission.dao.ITreeDao;

public class TreeDaoImpl extends BaseDao implements ITreeDao {

	@Override
	public List<Tree> queryRootNode() {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Tree>>() {

			@Override
			public List<Tree> doInHibernate(Session session) throws HibernateException {
				String hql = "from Tree where pid=-1";
				Query<Tree> query = session.createQuery(hql, Tree.class);
				List<Tree> list = query.list();
				for (Tree mod : list) {
					queryTreeByPid(mod.getId(), mod);
				}
				return list;
			}
		});
	}

	@Override
	public void queryTreeByPid(Integer pid, Tree tree) {
		List<Tree> lst = super.getHibernateTemplate().execute(new HibernateCallback<List<Tree>>() {

			@Override
			public List<Tree> doInHibernate(Session session) throws HibernateException {
				String hql = "from Tree where pid=:pid";
				Query<Tree> query = session.createQuery(hql, Tree.class);
				query.setParameter("pid", pid);
				List<Tree> list = query.list();
				for (Tree mod : list) {
					// 暂时不用
					queryTreeByPid(mod.getId(), mod);
				}
				return list;
			}
		});
		tree.setChildren(lst);
	}


}
