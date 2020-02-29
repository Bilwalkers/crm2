package com.zking.crm.market.biz;

import java.util.List;

import com.zking.crm.base.entity.SalChance;
import com.zking.crm.base.util.PageBean;

public interface ISalchanceBiz {
	/**
	 * 添加营销机会
	 * @param salChance
	 */
	public void addSalChance(SalChance salChance);
	/**
	 * 删除营销机会
	 * @param salChance
	 */
	public void delSalChance(SalChance salChance);
	/**
	 * 修改营销机会
	 * @param salChance
	 */
	public void editSalChance(SalChance salChance);
	/**
	 * 查询单个营销机会
	 * @param salChance
	 * @return
	 */
	public SalChance get(SalChance salChance);
	/**
	 * 分页查询所有营销机会信息
	 * @param salChance
	 * @param pageBean
	 * @return
	 */
	public List<SalChance> querySalChancePager(SalChance salChance,PageBean pageBean);
}
