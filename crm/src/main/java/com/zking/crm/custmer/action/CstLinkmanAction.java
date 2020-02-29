package com.zking.crm.custmer.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.CstLinkman;
import com.zking.crm.base.entity.User;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstLinkmanBiz;

public class CstLinkmanAction extends BaseAction implements ModelDriven<CstLinkman> {

	
	private CstLinkman cstLinkman = new CstLinkman();
	private ICstLinkmanBiz cstLinkmanBiz;

	
	
	public ICstLinkmanBiz getCstLinkmanBiz() {
		return cstLinkmanBiz;
	}



	public void setCstLinkmanBiz(ICstLinkmanBiz cstLinkmanBiz) {
		this.cstLinkmanBiz = cstLinkmanBiz;
	}



	@Override
	public CstLinkman getModel() {
		return cstLinkman;
	}

	
	/**
	 * 删除联系人
	 * @return
	 */
	public String delCstLinkman() {
		try {
			cstLinkmanBiz.delCstLinkman(cstLinkman);
			super.toJSONMessage("删除联系人成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 修改联系人信息
	 * @return
	 */
	public String editCstLinkman() {
		try {
			cstLinkmanBiz.editCstLinkman(cstLinkman);
			super.toJSONMessage("修改联系人信息成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 添加联系人
	 * @return
	 */
	public String addCstLinkman() {
		try {
			cstLinkmanBiz.addCstLinkman(cstLinkman);
			super.toJSONMessage("新增联系人成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 查询所有联系人
	 * @return
	 */
	public String queryCstLinkmanPager() {
		try {
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<CstLinkman> ckm = cstLinkmanBiz.queryCstLinkmanPager(cstLinkman, pageBean);
			for (CstLinkman cst : ckm) {
				cst.setLkmPostion("客户经理");
			}
			super.toJSONPager("ok", true, pageBean.getTotal(), ckm);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager(e.getMessage(), false, 0, null);
		}
		return null;
	}
	
}
