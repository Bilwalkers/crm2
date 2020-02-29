package com.zking.crm.dictionary.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.BasDict;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.dictionary.biz.IBasdictBiz;

public class BasdictAction extends BaseAction implements ModelDriven<BasDict> {
	private BasDict basDict = new BasDict();
	private IBasdictBiz ibasdictBiz;
	
	public IBasdictBiz getIbasdictBiz() {
		return ibasdictBiz;
	}

	public void setIbasdictBiz(IBasdictBiz ibasdictBiz) {
		this.ibasdictBiz = ibasdictBiz;
	}

	@Override
	public BasDict getModel() {
		return basDict;
	}
	public List<BasDict> queryBasDictDept(){
		try {
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<BasDict> list = ibasdictBiz.queryBasDictDept(basDict, pageBean);
			super.toJSONPager("ok", true, pageBean.getTotal(), list);
		} catch (Exception e) {
			super.toJSONPager("no", false, 0, null);
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 添加字典数据
	 */
	public void addBasdict() {
		try {
			ibasdictBiz.addBasdict(basDict);
			super.toJSONMessage("保存成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage("保存失败", false);
		}
	}
	/**
	 * 删除字典数据
	 */
	public void delBasdict() {
		try {
			ibasdictBiz.delBasdict(basDict);
			super.toJSONMessage("删除成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage("删除失败", false);
		}
	}
	/**
	 * 添加字典数据
	 */
	public void editBasdict() {
		try {
			ibasdictBiz.editBasdict(basDict);
			super.toJSONMessage("编辑成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage("编辑失败", false);
		}
	}
	/**
	 * 分页查询字典数据
	 */
	public void queryBasdictPager() {
		try {
			PageBean pageBean = new PageBean(); 
			pageBean.setRequest(request);
			List<BasDict> list = ibasdictBiz.queryBasdictPager(basDict, pageBean);
			super.toJSONPager("OK", true, pageBean.getTotal(), list);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager("No", false, 0, null);
		}
	}

}
