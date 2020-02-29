package com.zking.crm.dictionary.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.Storage;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.dictionary.dao.IStorageDao;

public class StorageDaoImpI extends BaseDao implements IStorageDao {

	@Override
	public List<Storage> queryStoragePager(Storage storage,PageBean pageBean) {
		
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Storage>>() {
			List<Storage> list = new ArrayList<Storage>();
			@Override
			public List<Storage> doInHibernate(Session session) throws HibernateException {
				String sql = "select p.prod_name,s.stk_id,s.stk_warehouse,s.stk_ware,s.stk_count,s.stk_memo from storage s,product p where s.stk_prod_id=p.prod_id";
				if(StringUtils.isNotBlank(storage.getProdNamestr())) {
					sql+=" and p.prod_name like '%"+storage.getProdNamestr()+"%'";
				}
				if(StringUtils.isNotBlank(storage.getStkWarehouse())) {
					sql+=" and s.stk_warehouse like '%"+storage.getStkWarehouse()+"%'";
				}
				sql+="  ORDER BY s.stk_id DESC";
				@SuppressWarnings("rawtypes")
				NativeQuery query = session.createNativeQuery(sql);
				if(pageBean.isPagination()) {
					String sql2 = "select count(s.stk_id) from storage s,product p where s.stk_prod_id=prod_id";
					if(StringUtils.isNotBlank(storage.getProdName())) {
						sql2+=" and p.prod_name like '%"+storage.getProdName()+"%'";
					}
					if(StringUtils.isNotBlank(storage.getStkWarehouse())) {
						sql2+=" and s.stk_warehouse like '%"+storage.getStkWarehouse()+"%'";
					}
					Query query2 = session.createNativeQuery(sql2);
					List lit = query2.list();
					if(null!=lit&&0!=lit.size()) {
						pageBean.setTotal(Integer.parseInt(lit.get(0).toString()));
					}
				}
					query.setFirstResult(pageBean.getStartIndex());
					query.setMaxResults(pageBean.getRows());
					List emps = query.list();
					for (int i = 0; i < emps.size(); i++) {
						// 将集合转为object数组 并获取到每一行的元素
						Object[] obj = (Object[]) emps.get(i);
						// 给每个元素赋值 相应的实体类
						Storage storage = new Storage((String)obj[0],(Integer)obj[1], (String)obj[2], (String)obj[3],(Integer)obj[4], (String)obj[5]);
						list.add(storage);
					}
				return list;
			}
		});
	}

}
