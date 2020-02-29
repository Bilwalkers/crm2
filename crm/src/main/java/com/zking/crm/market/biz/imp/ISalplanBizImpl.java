package com.zking.crm.market.biz.imp;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.SalPlan;
import com.zking.crm.base.entity.SalPlanItem;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.market.biz.ISalplanBiz;
import com.zking.crm.market.dao.ISalplanDao;
import com.zking.crm.market.dao.imp.SalplanDaoImpl;

public class ISalplanBizImpl extends BaseBiz implements ISalplanBiz {
	private ISalplanDao isalplanDao = new SalplanDaoImpl();
	public ISalplanDao getIsalplanDao() {
		return isalplanDao;
	}

	public void setIsalplanDao(ISalplanDao isalplanDao) {
		this.isalplanDao = isalplanDao;
	}

	@Override
	public void addSalplan(SalPlanItem salPlanItem) {
		isalplanDao.addSalplan(salPlanItem);
	}

	@Override
	public void editSalplan(SalPlan salPlan) {
		isalplanDao.editSalplan(salPlan);
	}

	@Override
	public void delSalplan(SalPlan salPlan) {
		isalplanDao.delSalplan(salPlan);
	}

	@Override
	public List<SalPlan> querySalplanPager(SalPlan salPlan, PageBean pageBean) {
		return isalplanDao.querySalplanPager(salPlan, pageBean);
	}

	@Override
	public SalPlan get(SalPlan salPlan) {
		return isalplanDao.get(salPlan);
	}

	@Override
	public List<SalPlanItem> querySalplanItem(SalPlanItem salPlanItem,PageBean pageBean) {
		return isalplanDao.querySalplanItem(salPlanItem,pageBean);
	}

	@Override
	public void successSalplan(SalPlan salPlan) {
		isalplanDao.successSalplan(salPlan);
	}

	@Override
	public void editPlanItem(SalPlanItem salPlanItem) {
		isalplanDao.editPlanItem(salPlanItem);
	}

	@Override
	public void delPlanItem(SalPlanItem salPlanItem) {
		isalplanDao.delPlanItem(salPlanItem);
	}

}
