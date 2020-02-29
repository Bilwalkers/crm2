package com.zking.crm.custmer.biz;

import java.util.List;

import com.zking.crm.base.entity.CstCustomer;
import com.zking.crm.base.util.PageBean;

/**
 * 客户信息
 * @author Admin
 *
 */
public interface ICstCustomerBiz {

	/**
	 * 增加
	 * @param cstCustomer
	 */
	public void addCstCustomer(CstCustomer cstCustomer) throws Exception;
	/**
	 * 删除
	 * @param cstCustomer
	 */
	public void delCstCustomer(CstCustomer cstCustomer) throws Exception;
	/**
	 * 修改
	 * @param cstCustomer
	 */
	public void editCstCustomer(CstCustomer cstCustomer) throws Exception;
	/**
	 * 修改客户状态
	 * @param cstCustomer
	 * @throws Exception
	 */
	public void ByeditCstCustomer(CstCustomer cstCustomer) throws Exception;
	/**
	 * 查询单个
	 * @param cstCustomer
	 * @return
	 */
	public CstCustomer byCstCustomer(CstCustomer cstCustomer) throws Exception;
	/**
	 * 查询所有（分页）
	 * @param cstCustomer
	 * @param pageBean
	 * @return
	 */
	public List<CstCustomer> queryCstCustomerPager(CstCustomer cstCustomer,PageBean pageBean) throws Exception;
}
