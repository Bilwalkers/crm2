package com.zking.crm.dictionary.dao.imp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.BasDict;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.dictionary.dao.IBasdictDao;

public class BasdictDaoImpl extends BaseDao implements IBasdictDao {

	@Override
	public void addBasdict(BasDict basDict) {
		this.getHibernateTemplate().save(basDict);
	}

	@Override
	public void delBasdict(BasDict basDict) {
		BasDict dict = get(basDict);
		if (null != dict) {
			this.getHibernateTemplate().delete(dict);
		}
	}

	@Override
	public void editBasdict(BasDict basDict) {
		this.getHibernateTemplate().update(basDict);
	}

	@Override
	public List<BasDict> queryBasdictPager(BasDict basDict, PageBean pageBean) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<BasDict>>() {
			@Override
			public List<BasDict> doInHibernate(Session session) throws HibernateException {
				String hql = "FROM BasDict WHERE 1=1";
				if (StringUtils.isNotBlank(basDict.getDictType())) {
					hql += " and dictType like '%" + basDict.getDictType() + "%'";
				}
				if (StringUtils.isNotBlank(basDict.getDictItem())) {
					hql += " and dictItem like '%" + basDict.getDictItem() + "%'";
				}
				if (StringUtils.isNotBlank(basDict.getDictValue())) {
					hql += " and dictValue like '%" + basDict.getDictValue() + "%'";
				}
				hql += " Order by dictId desc";
				Query<BasDict> query = session.createQuery(hql, BasDict.class);
				if(pageBean.isPagination()) {
					String hql2 = "select count(dictId) FROM BasDict WHERE 1=1";
					if (StringUtils.isNotBlank(basDict.getDictType())) {
						hql2 += " and dictType like '%" + basDict.getDictType() + "%'";
					}
					if (StringUtils.isNotBlank(basDict.getDictItem())) {
						hql2 += " and dictItem like '%" + basDict.getDictItem() + "%'";
					}
					if (StringUtils.isNotBlank(basDict.getDictValue())) {
						hql2 += " and dictValue like '%" + basDict.getDictValue() + "%'";
					}
					Query query2 = session.createQuery(hql2);
					List lit = query2.list();
					if(null!=lit&&0!=lit.size()) {
						pageBean.setTotal(Integer.parseInt(lit.get(0).toString()));
					}
				}
				query.setFirstResult(pageBean.getStartIndex());
				query.setMaxResults(pageBean.getRows());
				return query.list();
			}
		});
	}

	@Override
	public BasDict get(BasDict basDict) {
		BasDict dict = this.getHibernateTemplate().get(BasDict.class, basDict.getDictId());
		return dict;
	}

	@Override
	 public List<BasDict> queryBasDictDept(BasDict bd, PageBean pageBean) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<BasDict>>() {
			public List<BasDict> doInHibernate(Session session) throws HibernateException {
				String sql="select * from bas_dict where dict_type = '所属部门'  ";
				NativeQuery<BasDict> query = session.createNativeQuery(sql,BasDict.class);
				return query.list();
			}
		});
	}

}
