package com.zking.crm.dictionary.biz;

import java.util.List;

import com.zking.crm.base.entity.BasDict;
import com.zking.crm.base.util.PageBean;

public interface IBasdictBiz {
	
	/**
	 * 分页查询所有字典数据
	 * @param bd
	 * @param pageBean
	 * @return
	 */
	public List<BasDict> queryBasDictDept(BasDict bd,PageBean pageBean);
	
	/**
	 * 添加字典条目
	 * @param basDict
	 */
	public void addBasdict(BasDict basDict);
	/**
	 * 删除字典条目
	 * @param basDict
	 */
	public void delBasdict(BasDict basDict);
	/**
	 * 修改字典条目
	 * @param basDict
	 */
	public void editBasdict(BasDict basDict);
	/**
	 * 查询字典条目
	 * @param basDict
	 * @param pageBean
	 * @return
	 */
	public List<BasDict> queryBasdictPager(BasDict basDict,PageBean pageBean);
	/**
	 * 查询单个
	 * @param basDict
	 * @return
	 */
	public BasDict get(BasDict basDict);
}
