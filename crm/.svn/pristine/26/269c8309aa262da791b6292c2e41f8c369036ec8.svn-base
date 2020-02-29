package com.zking.crm.market.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.SalPlanItem;
import com.zking.crm.base.util.CommonUtils;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.market.biz.ISalplanBiz;

public class SalplanitemAction extends BaseAction implements ModelDriven<SalPlanItem> {
	SalPlanItem salplanItem = new SalPlanItem();
	private ISalplanBiz isalplanBiz;

	public ISalplanBiz getIsalplanBiz() {
		return isalplanBiz;
	}

	public void setIsalplanBiz(ISalplanBiz isalplanBiz) {
		this.isalplanBiz = isalplanBiz;
	}

	@Override
	public SalPlanItem getModel() {
		return salplanItem;
	}

	/**
	 * 修改计划项
	 */
	public void editPlanItem() {
		try {
			isalplanBiz.editPlanItem(salplanItem);
			super.toJSONMessage("保存成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage("保存失败", false);
		}
	}

	/**
	 * 删除计划项
	 */
	public void delPlanItem() {
		try {
			isalplanBiz.delPlanItem(salplanItem);
			super.toJSONMessage("删除成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage("删除失败", false);
		}
	}

	/**
	 * 增加开发计划项
	 * 
	 */
	public String addSalPlanItem() {
		try {
			isalplanBiz.addSalplan(salplanItem);
			CommonUtils.toJSONMEssager(response, true, "计划项保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONMEssager(response, false, e.getMessage());
		}
		return null;
	}

	/**
	 * 查询单个计划对应的所有计划项
	 */
	public void querySalplanItem() {
		try {
			PageBean pageBean = new PageBean();
			pageBean.setRequest(request);
			List<SalPlanItem> items = isalplanBiz.querySalplanItem(salplanItem, pageBean);
			System.out.println("items" + items);
			CommonUtils.toJSONPager(response, pageBean.getTotal(), items, true, "ok");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONPager(response, 0, null, false, "no");
		}
	}
}
