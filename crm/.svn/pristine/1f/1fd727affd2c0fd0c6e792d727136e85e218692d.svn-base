package com.zking.crm.market.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.SalChance;
import com.zking.crm.base.util.CommonUtils;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.market.biz.ISalchanceBiz;

public class SalchanceAction extends BaseAction implements ModelDriven<SalChance> {

	private SalChance salchance = new SalChance();
	private ISalchanceBiz isalchanceBiz;

	public ISalchanceBiz getIsalchanceBiz() {
		return isalchanceBiz;
	}

	public void setIsalchanceBiz(ISalchanceBiz isalchanceBiz) {
		this.isalchanceBiz = isalchanceBiz;
	}

	@Override
	public SalChance getModel() {
		return salchance;
	}

	/**
	 * 添加营销机会
	 * 
	 * @param salChance
	 */
	public String addSalChance() {
		try {
			System.out.println("来过add");
			isalchanceBiz.addSalChance(salchance);
			CommonUtils.toJSONMEssager(response, true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONMEssager(response, false, e.getMessage());
		}
		return null;
	}

	/**
	 * 修改营销机会
	 * 
	 * @param salChance
	 */
	public String editSalChance() {
		try {
			System.out.println("来过edit");
			isalchanceBiz.editSalChance(salchance);
			CommonUtils.toJSONMEssager(response, true, "保存修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONMEssager(response, false, e.getMessage());
		}
		return null;
	}

	/**
	 * 删除营销机会
	 * 
	 * @param salChance
	 */
	public String delSalChance() {
		try {
			System.out.println("来过del");
			isalchanceBiz.delSalChance(salchance);
			CommonUtils.toJSONMEssager(response, true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONMEssager(response, false, e.getMessage());
		}
		return null;
	}

	/**
	 * 修改营销机会
	 * 
	 * @param salChance
	 */
	public String SalChance() {
		try {
			isalchanceBiz.editSalChance(salchance);
			CommonUtils.toJSONMEssager(response, true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONMEssager(response, false, e.getMessage());
		}
		return null;
	}

	/**
	 * 查询单个营销机会
	 * 
	 * @param salChance
	 * @return
	 */
	public SalChance get() {
		return salchance;
	}

	/**
	 * 分页查询所有营销机会信息
	 * 
	 * @param salChance
	 * @param pageBean
	 * @return
	 */
	public String querySalChancePager() {
		try {
			PageBean pageBean = new PageBean();
			System.out.println(request.getParameterValues("dates"));
			System.out.println(request.getParameter("dates"));
			if(null!=request.getParameter("dates")) {
				System.out.println(request.getParameter("dates"));
			}
			if (null != request.getParameterValues("dates")) {
				String[] dates = request.getParameterValues("dates");
				for (String string : dates) {
					System.out.println(string);
				}
			}
			pageBean.setRequest(request);
			if (null != request.getParameter("tjianchance") && !"".equals(request.getParameter("tjianchance"))) {
				String tjian = request.getParameter("tjianchance");
				salchance.setTjian(tjian);
				System.out.println("tjian:" + tjian);
			}
			if (null != request.getParameter("strchance") && !"".equals(request.getParameter("strchance"))) {
				String str = request.getParameter("strchance");
				salchance.setStr(str);
				System.out.println("str:" + str);
			}
			List<SalChance> rows = isalchanceBiz.querySalChancePager(salchance, pageBean);
			CommonUtils.toJSONPager(response, pageBean.getTotal(), rows, true, "ok");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONPager(response, 0, null, false, "no");
		}
		return null;
	}

}
