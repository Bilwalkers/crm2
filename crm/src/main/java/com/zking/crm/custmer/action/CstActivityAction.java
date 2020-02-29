package com.zking.crm.custmer.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.CstActivity;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstActivityBiz;

public class CstActivityAction extends BaseAction implements ModelDriven<CstActivity> {

	private CstActivity cstActivity = new CstActivity();
	private ICstActivityBiz cstActivityBiz;
	
	
	public ICstActivityBiz getCstActivityBiz() {
		return cstActivityBiz;
	}


	public void setCstActivityBiz(ICstActivityBiz cstActivityBiz) {
		this.cstActivityBiz = cstActivityBiz;
	}


	@Override
	public CstActivity getModel() {
		return cstActivity;
	}
	
	/**
	 * 删除交往记录
	 * @return
	 */
	public String delCstActivity() {
		try {
			cstActivityBiz.delCstActivity(cstActivity);
			super.toJSONMessage("删除交往记录成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 修改交往记录
	 * @return
	 */
	public String editCstActivity() {
		try {
			cstActivityBiz.editCstActivity(cstActivity);
			super.toJSONMessage("修改交往记录成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 添加交往记录
	 * @return
	 */
	public String addCstActivity() {
		try {
			cstActivityBiz.addCstActivity(cstActivity);
			super.toJSONMessage("新增交往记录成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 查询交往记录（分页）
	 * @return
	 */
	public String queryCstActivityPager() {
		try {
			String startTime=request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<CstActivity> cat = null;
			if(startTime!="") {
				cat = cstActivityBiz.queryCstActivityPager(cstActivity, pageBean,startTime,"3000-01-01");
			}
			if(endTime!="") {
				cat = cstActivityBiz.queryCstActivityPager(cstActivity, pageBean,"2000-01-01",endTime);
			}
			if(startTime!=""&&endTime!="") {
				cat = cstActivityBiz.queryCstActivityPager(cstActivity, pageBean,startTime,endTime);
			}
			if(startTime==""&&endTime=="") {
				cat = cstActivityBiz.queryCstActivityPager(cstActivity, pageBean,"1000-01-01","3000-01-01");
			}
			super.toJSONPager("ok", true, pageBean.getTotal(), cat);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	
	

}
