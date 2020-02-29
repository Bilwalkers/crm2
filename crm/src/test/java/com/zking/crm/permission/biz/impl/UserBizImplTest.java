package com.zking.crm.permission.biz.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.User;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.permission.biz.IUserBiz;

public class UserBizImplTest {

	private User user=null;
	private IUserBiz userBiz;
	
	@Before
	public void setUp() throws Exception {
		user=new User();
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		userBiz = ac.getBean("userBiz",IUserBiz.class);
	}
	
	@Test
	public void testRoleUser() {
		user.setRolename("客户经理");
		List<User> list = userBiz.roleUser(user);
		for (User u : list) {
			System.out.println(u);
		}
	}
	
	@Test
	public void testUserLogin() {
		user.setUsername("admin");
		user.setPassword("123");
		User u = userBiz.userLogin(user);
		System.out.println(u);
	}

	@Test
	public void testAddUser() {
		user.setUsername("admin");
		user.setPassword("123");
		user.setDeptment("01");
		user.setRoleid("4028ab236c610296016c610c3c4d0000");
		userBiz.addUser(user);
	}

	@Test
	public void testDelUser() {
		user.setId("4459732b78164ac1bff5a07334e4eadb");
		userBiz.delUser(user);
	}

	@Test
	public void testEditUser() {
		user.setId("517e17b2d9814857a8f388c6ebb94fd3");
		user.setUsername("ajj");
		user.setPassword("52013990");
		user.setDeptment("02");
		user.setRoleid("4028ab236c461357016c461359100000");
		userBiz.editUser(user);
	}

	@Test
	public void testQueryUser() {
		String tjian="username";
		String content="m";
		user.setTjian(tjian);
		user.setContent(content);
		PageBean pageBean=new PageBean();
		pageBean.setPage(1);
		List<User> list = userBiz.queryUserPager(user, pageBean);
		for (User u : list) {
			System.out.println(u);
		}
	}

}
