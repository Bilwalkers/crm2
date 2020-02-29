package com.zking.crm.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {
	
	public static <T> void toJSONPager(HttpServletResponse resp,int total,List<T> rows
			,boolean flag,String msg) {
		try {
			ObjectMapper mapper=new ObjectMapper();
			Map<String, Object> json=new HashMap<>();
			json.put("total", total);
			json.put("rows", rows);
			json.put("success", flag);
			json.put("msg", msg);
			mapper.writeValue(resp.getOutputStream(), json);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 方法用于增删改，将信息转换JSON，传递的前
	 * @param resp
	 * @param falg
	 * @param msg
	 */
	public static void toJSONMEssager(HttpServletResponse resp,boolean flag,String msg) {
		try {
			ObjectMapper mapper=new ObjectMapper();
			Map<String, Object> json=new HashMap<>();
			json.put("success", flag);
			json.put("msg", msg);
			mapper.writeValue(resp.getOutputStream(), json);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将ResultSet结果集转换成list《T》
	 * 
	 * @param rs
	 * @param cla
	 * @return
	 */
	public static <T> List<T> toList(ResultSet rs, Class<T> cla) {
		List<T> list = new ArrayList<>();
		try {
			//获取ResultSet的metdata列信息
			ResultSetMetaData metaData = rs.getMetaData();
			//定义实体对象
			T obj = null;
			//获取类对象中的所有手续数组
			Field[] field = cla.getDeclaredFields();
			//遍历Resultset结果集
			while (rs.next()) {
				obj = cla.newInstance();

				//遍历metadata列信息
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					//获取ResultSet结果集中的列名
					String columnName = metaData.getColumnName(i + 1);
					//遍历Field属性数组
					for (Field d : field) {
						//获取属性名
						String name = d.getName();
						//将属性名与列名进行比较
						if (name.toUpperCase().equals(columnName.toUpperCase())) {
							String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
							//返射调用方法
							Method me = cla.getDeclaredMethod(methodName, d.getType());
							//设置权限
							me.setAccessible(true);
							
							me.invoke(obj, rs.getObject(columnName));
							break;
						}
					}
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 将ResultSet结果集转换成list<map>集合
	 * @param rs
	 * @return
	 */
	public static List<Map<String, Object>> toList(ResultSet rs){
		List<Map<String, Object>> list=new ArrayList<>();
		try {
			//获取ResultSet的metadate列信息
			ResultSetMetaData metaData = rs.getMetaData();
			//定义map对象，
			Map<String, Object> item=null;
			//遍历ResultSet结果集
			while(rs.next()) {
				item=new HashMap<String, Object>();
				//遍历metadate列信息
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					//获取列名
					String cloName=metaData.getColumnLabel(i+1);
					item.put(cloName, rs.getObject(cloName));
				}
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
