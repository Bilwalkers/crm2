package com.zking.crm.service.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.CstService;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.service.biz.ICstServiceBiz;

public class CstServiceAction extends BaseAction implements ModelDriven<CstService> {
	
	private CstService cstService = new CstService();
	
	private ICstServiceBiz cstServiceBiz;
	
	public ICstServiceBiz getCstServiceBiz() {
		return cstServiceBiz;
	}
	public void setCstServiceBiz(ICstServiceBiz cstServiceBiz) {
		this.cstServiceBiz = cstServiceBiz;
	}

	@Override
	public CstService getModel() {
		return cstService;
	}
	/**
	 * 服务创建
	 * @return
	 */
	public String addCstService() {
		try {
			cstServiceBiz.addCstService(cstService);
			this.toJSONMessage("服务创建成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONMessage("服务创建失败", false);
		}
		return null;
	}
	/**
	 * 修改服务信息
	 * @return
	 */
	public String editCstService() {
		try {
			cstServiceBiz.editCstService(cstService);
			this.toJSONMessage("服务信息保存成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONMessage("服务信息保存成功", false);
		}
		return null;
	}
	/**
	 * 删除服务信息
	 * @return
	 */
	public String delCstService() {
		try {
			cstServiceBiz.delCstService(cstService);
			this.toJSONMessage("删除服务成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONMessage("删除服务失败", false);
		}
		return null;
	}
	/**
	 * 查询单个
	 * @return
	 */
	public CstService byCstService() {
		try {
			CstService byService = cstServiceBiz.byCstService(cstService);
			this.toJSONObject(true, byService);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONObject(false, null);
		}
		return null;
	}
	
	/**
	 * 分页模糊查询
	 * @return
	 */
	public List<CstService> queryCstServicePager(){
		PageBean pageBean = new PageBean();
		
		String startTime=request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String serTimeDate = request.getParameter("serTimeDate");
		cstService.setSerTimeDate(serTimeDate);
		pageBean.setRequest(request);
		List<CstService> query = null;
		try {
			if(startTime!="") {
				query = cstServiceBiz.queryCstServicePager(cstService, pageBean,startTime,"3000-01-01");
			}
			if(endTime!="") {
				query = cstServiceBiz.queryCstServicePager(cstService, pageBean,"2000-01-01",endTime);
			}
			if(startTime!=""&&endTime!="") {
				query = cstServiceBiz.queryCstServicePager(cstService, pageBean,startTime,endTime);
			}
			if(startTime==""&&endTime=="") {
				query = cstServiceBiz.queryCstServicePager(cstService, pageBean,"1000-01-01","3000-01-01");
			}
			this.toJSONPager("OK", true, pageBean.getTotal(), query);
		} catch (Exception e) {
			e.printStackTrace();
			this.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}

}
