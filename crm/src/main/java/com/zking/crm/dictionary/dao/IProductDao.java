package com.zking.crm.dictionary.dao;

import java.util.List;

import com.zking.crm.base.entity.Product;
import com.zking.crm.base.util.PageBean;

public interface IProductDao {
	public List<Product> queryProductPager(Product product,PageBean pageBean);

}
