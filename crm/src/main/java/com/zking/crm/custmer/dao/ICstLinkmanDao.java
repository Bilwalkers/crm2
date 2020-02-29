package com.zking.crm.custmer.dao;

import java.util.List;

import com.zking.crm.base.entity.CstLinkman;
import com.zking.crm.base.util.PageBean;

/**
 *	联系人
 * @author Admin
 *
 */
public interface ICstLinkmanDao {

	/**
	 * 增加
	 * @param cstLinkman
	 */
	public void addCstLinkman(CstLinkman cstLinkman) throws Exception;
	/**
	 * 删除
	 * @param cstLinkman
	 */
	public void delCstLinkman(CstLinkman cstLinkman) throws Exception;
	/**
	 * 修改
	 * @param cstLinkman
	 */
	public void editCstLinkman(CstLinkman cstLinkman) throws Exception;
	/**
	 * 查询单个
	 * @param cstLinkman
	 * @return
	 */
	public CstLinkman byCstLinkman(CstLinkman cstLinkman) throws Exception;
	/**
	 * 查询所有（分页）
	 * @param cstLinkman
	 * @param pageBean
	 * @return
	 */
	public List<CstLinkman> queryCstLinkmanPager(CstLinkman cstLinkman,PageBean pageBean) throws Exception;

}
