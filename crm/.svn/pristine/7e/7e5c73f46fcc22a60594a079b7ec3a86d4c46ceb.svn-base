package com.zking.crm.dictionary.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.Product;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.dictionary.dao.IProductDao;

public class ProductDaoImpl extends BaseDao implements IProductDao {

	@Override
	public List<Product> queryProductPager(Product product, PageBean pageBean) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<Product>>() {
			List<Product> list = new ArrayList<Product>();
			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT prod_id,prod_name,prod_type,prod_batch,prod_unit,prod_price,prod_memo FROM product WHERE 1=1";
				if(StringUtils.isNotBlank(product.getProdName())) {//根据名称
					sql+=" and prod_name like '%"+product.getProdName()+"%'";
				}
				if(StringUtils.isNotBlank(product.getProdType())){//型号
					sql+=" and prod_type like '%"+product.getProdType()+"%'";
				}
				if(StringUtils.isNotBlank(product.getProdBatch())) {//批次
					sql+=" and prod_batch like '%"+product.getProdBatch()+"%'";
				}
				sql+=" ORDER BY prod_id DESC";
				NativeQuery query = session.createNativeQuery(sql);
				if(pageBean.isPagination()) {
					String sql2 = "SELECT count(prod_id) FROM product WHERE 1=1";
					if(StringUtils.isNotBlank(product.getProdName())) {//根据名称
						sql2+=" and prod_name like '%"+product.getProdName()+"%'";
					}
					if(StringUtils.isNotBlank(product.getProdType())){//型号
						sql2+=" and prod_type like '%"+product.getProdType()+"%'";
					}
					if(StringUtils.isNotBlank(product.getProdBatch())) {//批次
						sql2+=" and prod_batch like '%"+product.getProdBatch()+"%'";
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
					Product product = 
							new Product((Integer)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4], (Float)obj[5], (String)obj[6]);
					list.add(product);
				}
				return list;
			}
		});
	}

}
