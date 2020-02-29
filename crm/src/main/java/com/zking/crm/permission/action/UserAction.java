package com.zking.crm.permission.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.zking.crm.base.action.BaseAction;
import com.zking.crm.base.entity.User;
import com.zking.crm.base.jwt.JwtUtils;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.permission.biz.IUserBiz;

public class UserAction extends BaseAction implements ModelDriven<User> {

	private User user=new User();
	private IUserBiz userBiz;
	
	public IUserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(IUserBiz userBiz) {
		this.userBiz = userBiz;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	/**
	 * 根据角色查询用户
	 * @return
	 */
	public String roleUser() {
		try {
			String rolename = request.getParameter("rolename");
			user.setRolename(rolename);
			List<User> users = userBiz.roleUser(user);
			super.toJSONPager("ok", true, 0, users);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager("no", false, 0, null);
		}
		return null;
	}

	
	
	/**
	 * 查询用户所有信息
	 * @return
	 */
	public String getUser() {
		try {
			User us = userBiz.getUser(user);
			super.toJSONObject(true, us);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONObject(false, null);
		}
		return null;
	}

	/**
	 * 用户登陆
	 * @return
	 */
	public String userLogin() {
		try {
			//私有要求claim
			Map<String, Object> json=new HashMap<String, Object>();
			json.put("username", user.getUsername());
			json.put("password", user.getPassword());
			//生成JWT,并设置带response响应头中
			String jwt=JwtUtils.createJwt(json, JwtUtils.JWT_WEB_TTL);
			response.setHeader(JwtUtils.JWT_HEADER_KEY, jwt);
			User u = userBiz.userLogin(user);
			super.toJSONObject(true, u);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONObject(false, null);
		}
		return null;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String delUser() {
		try {
			userBiz.delUser(user);
			super.toJSONMessage("删除用户成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 修改用户信息
	 * @return
	 */
	public String editUser() {
		try {
			userBiz.editUser(user);
			super.toJSONMessage("修改用户信息成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	public String addUser() {
		try {
			userBiz.addUser(user);
			super.toJSONMessage("新增用户成功!", true);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONMessage(e.getMessage(), false);
		}
		return null;
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public String queryUserPager() {
		try {
			
			String tjian=request.getParameter("tjian");
			String content=request.getParameter("content");
			user.setTjian(tjian);
			user.setContent(content);
			PageBean pageBean=new PageBean();
			pageBean.setRequest(request);
			List<User> users = userBiz.queryUserPager(user, pageBean);
			super.toJSONPager("ok", true, pageBean.getTotal(), users);
		} catch (Exception e) {
			e.printStackTrace();
			super.toJSONPager("no", false, 0, null);
		}
		return null;
	}
	
}
