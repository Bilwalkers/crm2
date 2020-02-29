package com.zking.crm.custmer.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.entity.User;
import com.zking.crm.base.jwt.JwtUtils;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstCustomerBiz;

public class CstCustomerAction extends BaseAction implements ModelDriven<CstCustomer> {

	private CstCustomer cstCustomer = new CstCustomer();
	private ICstCustomerBiz cstCustomerBiz;
	

	public ICstCustomerBiz getCstCustomerBiz() {
		return cstCustomerBiz;
	}


	public void setCstCustomerBiz(ICstCustomerBiz cstCustomerBiz) {
		this.cstCustomerBiz = cstCustomerBiz;
	}


	@Override
	public CstCustomer getModel() {
		return cstCustomer;
	}


	/**
	 * 删除客户信息
	 * @return
	 */
	public String delCstCustomer() {
		try {
			cstCustomerBiz.delCstCustomer(cstCustomer);
			super.toJSONMessage("删除客户信息成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 修改客户信息
	 * @return
	 */
	public String editCstCustomer() {
		try {
			cstCustomerBiz.editCstCustomer(cstCustomer);
			super.toJSONMessage("修改客户信息成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 修改客户状态
	 * @return
	 */
	public String ByeditCstCustomer() {
		try {
			cstCustomerBiz.ByeditCstCustomer(cstCustomer);
			super.toJSONMessage("客户状态改变成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 添加客户信息
	 * @return
	 */
	public String addCstCustomer() {
		try {
			cstCustomerBiz.addCstCustomer(cstCustomer);
			super.toJSONMessage("新增客户成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 查询客户信息
	 * @return
	 */
	public String queryCstCustomerPager() {
		try {
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<CstCustomer> ctm = cstCustomerBiz.queryCstCustomerPager(cstCustomer, pageBean);
			super.toJSONPager("ok", true, pageBean.getTotal(), ctm);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	
}
