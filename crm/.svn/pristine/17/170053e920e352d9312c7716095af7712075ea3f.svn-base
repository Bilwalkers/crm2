package com.zking.crm.market.dao;

import java.util.List;

import com.zking.crm.base.entity.SalPlan;
import com.zking.crm.base.entity.SalPlanItem;
import com.zking.crm.base.util.PageBean;

public interface ISalplanDao {
	/**
	 * 添加营销计划项
	 * @param salPlanItem
	 */
	public void addSalplan(SalPlanItem salPlanItem);
	/**
	 * 修改营销计划项
	 * @param salPlan
	 */
	public void editSalplan(SalPlan salPlan);
	/**
	 * 开发成功方法
	 * @param salPlan
	 */
	public void successSalplan(SalPlan salPlan);
	/**
	 * 删除开发计划
	 * @param salPlan
	 */
	public void delSalplan(SalPlan salPlan);
	/**
	 * 查询所有单个计划对应的所有计划项
	 * @param salPlanItem
	 * @return
	 */
	public List<SalPlanItem> querySalplanItem(SalPlanItem salPlanItem,PageBean pageBean);
	/**
	 * 分页查询所有计划
	 * @param salPlan
	 * @return
	 */
	public List<SalPlan> querySalplanPager(SalPlan salPlan,PageBean pageBean);
	/**
	 * 查询单个
	 * @param salPlan
	 * @return
	 */
	public SalPlan get(SalPlan salPlan);
	/**
	 * 开发计划项结果修改
	 * @param salPlanItem
	 */
	public void editPlanItem(SalPlanItem salPlanItem);
	/**
	 * 开发计划项删除
	 * @param salPlanItem
	 */
	public void delPlanItem(SalPlanItem salPlanItem);
	
}
