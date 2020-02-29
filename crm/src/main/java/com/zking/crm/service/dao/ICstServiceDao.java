package com.zking.crm.service.dao;

import java.util.List;

import com.zking.crm.base.entity.CstService;
import com.zking.crm.base.util.PageBean;
/**
 * 	服务管理接口
 * @author Administrator
 *
 */
public interface ICstServiceDao {
	/**
	 * 	服务创建（新建服务）
	 * @param cstService
	 */
	public void addCstService(CstService cstService) throws Exception;
	/**
	 * 	服务分配（修改：分配人，状态）;
	 * 	服务处理（修改：服务处理方法，处理人（当前登录的用户），
	 * 	处理时间（系统时间），状态（已处理））;
	 * 	服务反馈：（修改：处理结果，满意度，状态（满意度>3，修改已归档；满意度<3，不修改)）
	 * @param cstService
	 */
	public void editCstService(CstService cstService) throws Exception;
	/**
	 * 	删除
	 * @param cstService
	 */
	public void delCstService(CstService cstService) throws Exception;
	/**
	 *  查询单个
	 * @param cstService
	 * @return
	 */
	public CstService byCstService(CstService cstService) throws Exception;
	/**
	 * 	分页查询
	 * @param cstService
	 * @param pageBean
	 * @return
	 */
	public List<CstService> queryCstServicePager(CstService cstService,PageBean pageBean, String startTime, String endTime) throws Exception;
} 
