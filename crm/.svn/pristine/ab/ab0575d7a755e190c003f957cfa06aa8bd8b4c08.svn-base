package com.zking.crm.permission.biz.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.Tree;
import com.zking.crm.permission.biz.ITreeBiz;

class TreeBizImplTest {

	private Tree tree;
	private ITreeBiz treeBiz;
	
	
	@BeforeEach
	void setUp() throws Exception {
		tree=new Tree();
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		treeBiz=ac.getBean("treeBiz",ITreeBiz.class);
	}

	@Test
	void testQueryRootNode() {
		List<Tree> list = treeBiz.queryRootNode();
		for (Tree tree : list) {
			System.out.println(tree);
		}
	}

}
