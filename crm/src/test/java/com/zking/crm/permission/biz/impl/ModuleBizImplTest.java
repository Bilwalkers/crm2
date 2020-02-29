package com.zking.crm.permission.biz.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.Module;
import com.zking.crm.permission.biz.IModuleBiz;

class ModuleBizImplTest {

	private Module module;
	private IModuleBiz moduleBiz;
	
	
	@BeforeEach
	void setUp() throws Exception {
		module=new Module();
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		moduleBiz=ac.getBean("moduleBiz",IModuleBiz.class);
	}

	
	@Test
	void testQueryRootNode() {
	}

	@Test
	void testQueryModuleAuth() {
		List<Module> list = moduleBiz.queryModuleAuth();
		for (Module mod : list) {
			System.out.println(mod);
		}
	}

	@Test
	void testQueryModuleByPid() {
	}

	@Test
	void testQueryModuleByUserId() {
		String userid="51b51e3681934c95b88440c3da80ed9a";
		List<Module> query = moduleBiz.queryModuleByUserId(userid);
		for (Module mod : query) {
			System.out.println(mod);
		}
	}

}
