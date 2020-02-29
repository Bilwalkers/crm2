package com.zking.crm.custmer.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.CstLost;
import com.zking.crm.base.entity.User;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstLostBiz;

public class CstLostAction extends BaseAction implements ModelDriven<CstLost> {
	
	private CstLost cstLost = new CstLost();
	private ICstLostBiz cstLostBiz;
	


	public ICstLostBiz getCstLostBiz() {
		return cstLostBiz;
	}



	public void setCstLostBiz(ICstLostBiz cstLostBiz) {
		this.cstLostBiz = cstLostBiz;
	}



	@Override
	public CstLost getModel() {
		return cstLost;
	}
	
	/**
	 * 删除流失信息
	 * @return
	 */
	public String delCstLost() {
		try {
			cstLostBiz.delCstLost(cstLost);
			super.toJSONMessage("删除流失信息成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 修改流失信息
	 * @return
	 */
	public String editCstLost() {
		try {
			System.out.println("========================"+cstLost);
			if(cstLost.getLstStatus().equals("预警")) {
				cstLost.setLstStatus("1");
			}else if(cstLost.getLstStatus().equals("暂缓流失")) {
				cstLost.setLstStatus("2");
			}else if(cstLost.getLstStatus().equals("确认流失")) {
				cstLost.setLstStatus("3");
			}
			cstLostBiz.editCstLost(cstLost);
			super.toJSONMessage("记录成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage("记录失败！！！", false);
		}
		return null;
	}
	
	/**
	 * 添加流失信息
	 * @return
	 */
	public String addCstLost() {
		try {
			cstLostBiz.addCstLost(cstLost);
			super.toJSONMessage("新增流失信息成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 查询所有流失信息
	 * @return
	 */
	public String queryCstLostPager() {
		try {
			if(cstLost.getLstStatus().equals("预警")) {
				cstLost.setLstStatus("1");
			}else if(cstLost.getLstStatus().equals("暂缓流失")) {
				cstLost.setLstStatus("2");
			}else if(cstLost.getLstStatus().equals("确认流失")) {
				cstLost.setLstStatus("3");
			}
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<CstLost> cst = cstLostBiz.queryCstLostPager(cstLost, pageBean);
			for (CstLost cs : cst) {
				if(cs.getLstStatus().equals("1")) {
					cs.setLstStatus("预警");
				}else if(cs.getLstStatus().equals("2")) {
					cs.setLstStatus("暂缓流失");
				}else if(cs.getLstStatus().equals("3")) {
					cs.setLstStatus("确认流失");
				}
				
			}
			super.toJSONPager("ok", true, pageBean.getTotal(), cst);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	

}
