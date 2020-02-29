package com.zking.crm.dictionary.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.Product;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.dictionary.biz.IProductBiz;

public class ProductAction extends BaseAction implements ModelDriven<Product> {
	private Product product = new Product();
	private IProductBiz iproductBiz;
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public IProductBiz getIproductBiz() {
		return iproductBiz;
	}

	public void setIproductBiz(IProductBiz iproductBiz) {
		this.iproductBiz = iproductBiz;
	}

	@Override
	public Product getModel() {
		return product;
	}
	/**
	 * 分页查询产品信息
	 */
	public void queryProductPager() {
		try {
			PageBean pageBean = new PageBean();
			pageBean.setRequest(request);
			List<Product> list = iproductBiz.queryProductPager(product, pageBean);
			super.toJSONPager("Ok", true, pageBean.getTotal(), list);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager("No", false, 0, null);
		}
	}

}
