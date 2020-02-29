package com.zking.crm.market.biz.imp;

import java.util.List;

import com.zking.crm.base.biz.BaseBiz;
import com.zking.crm.base.entity.SalChance;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.market.biz.ISalchanceBiz;
import com.zking.crm.market.dao.ISalchanceDao;
import com.zking.crm.market.dao.imp.SalChanceDaoImpl;

public class ISalchanceBizImpl extends BaseBiz implements ISalchanceBiz {
	private ISalchanceDao isalchanceDao = new SalChanceDaoImpl();
	
	public ISalchanceDao getIsalchanceDao() {
		return isalchanceDao;
	}

	public void setIsalchanceDao(ISalchanceDao isalchanceDao) {
		this.isalchanceDao = isalchanceDao;
	}

	@Override
	public void addSalChance(SalChance salChance) {
		isalchanceDao.addSalChance(salChance);
	}

	@Override
	public void delSalChance(SalChance salChance) {
		isalchanceDao.delSalChance(salChance);
	}

	@Override
	public void editSalChance(SalChance salChance) {
		isalchanceDao.editSalChance(salChance);
	}

	@Override
	public SalChance get(SalChance salChance) {
		return isalchanceDao.get(salChance);
	}

	@Override
	public List<SalChance> querySalChancePager(SalChance salChance, PageBean pageBean) {
		return isalchanceDao.querySalChancePager(salChance, pageBean);
	}

}
