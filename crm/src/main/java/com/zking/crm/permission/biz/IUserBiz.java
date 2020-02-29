package com.zking.crm.permission.biz;

import java.util.List;

import com.zking.crm.base.entity.User;
import com.zking.crm.base.util.PageBean;

public interface IUserBiz {
	
	
	/**
	 * 根据角色查询用户
	 * @param user
	 * @return
	 */
	public List<User> roleUser(User user);

	
	/**
	 * 根据用户id查询单个用户对象信息
	 * @param user
	 * @return
	 */
	public User getUser(User user) ;
	
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	public User userLogin(User user);
	/**
	 * 新增用户
	 * @param user
	 */
	public void addUser(User user);
	/**
	 * 删除用户
	 * @param user
	 */
	public void delUser(User user);
	/**
	 * 编辑用户信息
	 * @param user
	 */
	public void editUser(User user);
	/**
	 * 查询用户
	 * @param user
	 * @param pageBean
	 * @return
	 */
	public List<User> queryUserPager(User user,PageBean pageBean);
}
