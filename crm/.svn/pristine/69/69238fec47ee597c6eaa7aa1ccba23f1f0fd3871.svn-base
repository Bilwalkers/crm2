package com.zking.crm.permission.dao.impl;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.Module;
import com.zking.crm.base.entity.Tree;
import com.zking.crm.base.entity.User;
import com.zking.crm.permission.biz.IModuleBiz;

public class ModuleDaoImplTest {

	private Module module;
	private IModuleBiz moduleBiz;
	
	
	@Before
	public void setUp() throws Exception {
		module=new Module();
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		moduleBiz=ac.getBean("moduleBiz",IModuleBiz.class);
	}

	@Test
	public void testQueryRootNode() {
		
//		module.setRoleid("4028ab236c5660af016c5660b1820000");
		/*List<Module> list = moduleBiz.queryRootNode(module);
		
		for (Module mod : list) {
			System.out.println(mod);
		}*/
		
		String str="51b51e3681934c95b88440c3da80ed9a";
		List<Module> nodes = moduleBiz.queryModuleByUserId(str);
		for (Module mod : nodes) {
			System.out.println(mod);
		}
		
	}

}
