package com.zking.crm.market.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.SalChance;
import com.zking.crm.base.entity.SalPlan;
import com.zking.crm.base.entity.SalPlanItem;
import com.zking.crm.base.util.CommonUtils;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.market.biz.ISalplanBiz;

public class SalplanAction extends BaseAction implements ModelDriven<SalPlan> {
	private SalPlan salPlan = new SalPlan();
	private ISalplanBiz isalplanBiz;

	public ISalplanBiz getIsalplanBiz() {
		return isalplanBiz;
	}
	public void setIsalplanBiz(ISalplanBiz isalplanBiz) {
		this.isalplanBiz = isalplanBiz;
	}

	@Override
	public SalPlan getModel() {
		return salPlan;
	}
//	/**
//	 * 增加开发计划
//	 * 
//	 * @param salChance
//	 */
//	public String addSalplan() {
//		try {
//			isalplanBiz.addSalplan(salPlan);
//			CommonUtils.toJSONMEssager(response, true, "保存成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			CommonUtils.toJSONMEssager(response, false, e.getMessage());
//		}
//		return null;
//	}
	/**
	 * 修改开发状态(开发成功)
	 * 
	 */
	public String successSalplan() {
		try {
			isalplanBiz.successSalplan(salPlan);
			CommonUtils.toJSONMEssager(response, true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONMEssager(response, false, e.getMessage());
		}
		return null;
	}
	/**
	 * 修改开发状态(终止开发)
	 * 
	 */
	public String delSalplan() {
		try {
			isalplanBiz.delSalplan(salPlan);
			CommonUtils.toJSONMEssager(response, true, "终止开发成功,可到开发机会中查看");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONMEssager(response, false, e.getMessage());
		}
		return null;
	}
	/**
	 * 分页查询所有开发计划信息
	 * 
	 * @param salChance
	 * @param pageBean
	 * @return
	 */
	public String querySalPlanPager() {
		try {
			PageBean pageBean = new PageBean();
			pageBean.setRequest(request);
			if (null != request.getParameter("tjian") && !"".equals(request.getParameter("tjian"))) {
				String tjian = request.getParameter("tjian");
				salPlan.setTjian(tjian);
				System.out.println("tjian:"+tjian);
			}
			if (null != request.getParameter("str") && !"".equals(request.getParameter("str"))) {
				String str = request.getParameter("str");
				salPlan.setStr(str);
				System.out.println("tjian:"+str);
			}			
			List<SalPlan> rows = isalplanBiz.querySalplanPager(salPlan, pageBean);
			CommonUtils.toJSONPager(response, pageBean.getTotal(), rows, true, "ok");
		} catch (Exception e) {
			e.printStackTrace();
			CommonUtils.toJSONPager(response, 0, null, false, "no");
		}
		return null;
	}

}
