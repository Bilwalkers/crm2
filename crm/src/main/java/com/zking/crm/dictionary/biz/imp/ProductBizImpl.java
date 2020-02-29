package com.zking.crm.dictionary.biz.imp;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.Product;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.dictionary.biz.IProductBiz;
import com.zking.crm.dictionary.dao.IProductDao;
import com.zking.crm.dictionary.dao.imp.ProductDaoImpl;

public class ProductBizImpl extends BaseBiz implements IProductBiz {
	private IProductDao iproductDao = new ProductDaoImpl();
	
	public IProductDao getIproductDao() {
		return iproductDao;
	}

	public void setIproductDao(IProductDao iproductDao) {
		this.iproductDao = iproductDao;
	}

	@Override
	public List<Product> queryProductPager(Product product, PageBean pageBean) {
		return iproductDao.queryProductPager(product, pageBean);
	}

}
