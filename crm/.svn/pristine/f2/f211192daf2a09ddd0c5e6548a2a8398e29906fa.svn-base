package com.zking.crm.permission.biz.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.Role;
import com.zking.crm.base.entity.RoleModule;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.permission.biz.IRoleBiz;

class RoleBizImplTest {

	private Role role=null;
	private IRoleBiz roleBiz;
	
	@BeforeEach
	void setUp() throws Exception {
		role=new Role();
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		roleBiz=ac.getBean("roleBiz",IRoleBiz.class);
	}

	@Test
	void testAddRole() {
		role.setRolename("销售主管");
		roleBiz.addRole(role);
	}

	@Test
	void testDelRole() {
		role.setRoleid("4028ab236c460ec4016c460ec6de0000");
		roleBiz.delRole(role);
	}

	@Test
	void testEditRole() {
		role.setRoleid("ff8080816c5c17bd016c5c4507520002");
		role.setRolename("高管2222");
		roleBiz.editRole(role);
	}

	@Test
	void testQueryRolePager() {
		PageBean pageBean=new PageBean();
		List<Role> list = roleBiz.queryRolePager(role, pageBean);
		for (Role r : list) {
			System.out.println(r);
		}
	}

	@Test
	void testAddRoleModule() {
		RoleModule rm=new RoleModule();
		rm.setRoleid("4028ab236c461357016c461359100000");
		rm.setModuleid("13,14,1401");
		roleBiz.addRoleModule(rm);
	}

	@Test
	void testQueryModuleRoleId() {
		role.setRoleid("4028ab236c461357016c461359100000");
		List<String> roles = roleBiz.queryModuleRoleId(role);
		for (String str : roles) {
			System.out.println(str);
		}
	}

}
