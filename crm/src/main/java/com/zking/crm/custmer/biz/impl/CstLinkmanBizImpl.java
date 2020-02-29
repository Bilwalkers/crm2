package com.zking.crm.custmer.biz.impl;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.CstLinkman;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.custmer.biz.ICstLinkmanBiz;
import com.zking.crm.custmer.dao.ICstLinkmanDao;

public class CstLinkmanBizImpl extends BaseBiz implements ICstLinkmanBiz {

	private ICstLinkmanDao cstLinkmanDao;
	
	public ICstLinkmanDao getCstLinkmanDao() throws Exception {
		return cstLinkmanDao;
	}

	public void setCstLinkmanDao(ICstLinkmanDao cstLinkmanDao) throws Exception {
		this.cstLinkmanDao = cstLinkmanDao;
	}

	@Override
	public void addCstLinkman(CstLinkman cstLinkman) throws Exception {
		cstLinkmanDao.addCstLinkman(cstLinkman);
	}

	@Override
	public void delCstLinkman(CstLinkman cstLinkman) throws Exception {
		cstLinkmanDao.delCstLinkman(cstLinkman);
	}

	@Override
	public void editCstLinkman(CstLinkman cstLinkman) throws Exception {
		cstLinkmanDao.editCstLinkman(cstLinkman);
	}

	@Override
	public CstLinkman byCstLinkman(CstLinkman cstLinkman) throws Exception {
		return cstLinkmanDao.byCstLinkman(cstLinkman);
	}

	@Override
	public List<CstLinkman> queryCstLinkmanPager(CstLinkman cstLinkman, PageBean pageBean) throws Exception {
		return cstLinkmanDao.queryCstLinkmanPager(cstLinkman, pageBean);
	}

}
