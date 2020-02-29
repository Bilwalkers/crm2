package com.zking.crm.market.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.SalChance;
import com.zking.crm.base.entity.SalPlan;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.market.dao.ISalchanceDao;

public class SalChanceDaoImpl extends BaseDao implements ISalchanceDao {

	@Override
	public void addSalChance(SalChance salChance) {
		if (!"2".equals(salChance.getChcStatus())) {
			salChance.setChcDueDate(null);
		}
		this.getHibernateTemplate().save(salChance);
		if ("2".equals(salChance.getChcStatus())) {// 2表示已指派，所以向营销计划表中插入数据
			SalPlan salPlan = new SalPlan();
			salPlan.setPlaChcId(salChance.getChcId());
			this.getHibernateTemplate().save(salPlan);
		}
	}

	@Override
	public void delSalChance(SalChance salChance) {
		SalChance chance = this.get(salChance);
		if (null != chance) {
			this.getHibernateTemplate().delete(chance);
		}
	}

	@Override
	public void editSalChance(SalChance salChance) {
		this.getHibernateTemplate().execute(new HibernateCallback<SalChance>() {
			@Override
			public SalChance doInHibernate(Session session) throws HibernateException {
				if ("2".equals(salChance.getChcStatus())) {
					String planitemdel = "DELETE from sal_plan_item where pla_id_item =(SELECT pla_id from sal_plan where pla_chc_id="
							+ salChance.getChcId() + ")";
					int i = session.createNativeQuery(planitemdel).executeUpdate();
					String plandelsql = "delete from sal_plan where pla_chc_id =" + salChance.getChcId();
					int m = session.createNativeQuery(plandelsql).executeUpdate();
				}
				String sql = "";
				if (null != salChance.getChcDueTo() && !"".equals(salChance.getChcDueTo())) {
					salChance.setChcStatus("2");
					sql = "update sal_chance set chc_source='" + salChance.getChcSource() + "',chc_cust_name='"
							+ salChance.getChcCustName() + "',\r\n" + "chc_title='" + salChance.getChcTitle()
							+ "',chc_rate='" + salChance.getChcRate() + "',chc_linkman='" + salChance.getChcLinkman()
							+ "',\r\n" + "chc_tel='" + salChance.getChcTel() + "',\r\n" + "chc_due_to='"
							+ salChance.getChcDueTo() + "',chc_due_date='" + salChance.getChcDueDate() + "',\r\n"
							+ "chc_status='" + salChance.getChcStatus() + "' where chc_id=" + salChance.getChcId();
					session.createNativeQuery(sql).executeUpdate();
				} else {
					salChance.setChcStatus("1");
					sql = "update sal_chance set chc_source='" + salChance.getChcSource() + "',chc_cust_name='"
							+ salChance.getChcCustName() + "',\r\n" + "chc_title='" + salChance.getChcTitle()
							+ "',chc_rate='" + salChance.getChcRate() + "',chc_linkman='" + salChance.getChcLinkman()
							+ "',\r\n" + "chc_tel='" + salChance.getChcTel() + "',\r\n" + "chc_status='"
							+ salChance.getChcStatus() + "' where chc_id=" + salChance.getChcId();
					session.createNativeQuery(sql).executeUpdate();
				}
				return null;
			}
		});
		if (!"".equals(salChance.getChcDueTo()) && null != salChance.getChcDueTo()) {
			SalPlan salPlan = new SalPlan();
			salPlan.setPlaChcId(salChance.getChcId());
			this.getHibernateTemplate().save(salPlan);
		}
	}

	@Override
	public List<SalChance> querySalChancePager(SalChance salChance, PageBean pageBean) {

		return this.getHibernateTemplate().execute(new HibernateCallback<List<SalChance>>() {
			List<SalChance> rows = new ArrayList<SalChance>();

			@Override
			public List<SalChance> doInHibernate(Session session) throws HibernateException {
				String sqls = "select\r\n" + "		chc_id,\r\n" + "		chc_source,\r\n"
						+ "		chc_cust_name,\r\n" + "		chc_title,\r\n" + "		chc_rate,\r\n"
						+ "		chc_linkman,\r\n" + "		chc_tel,\r\n" + "		chc_desc,\r\n"
						+ "		chc_create_id,\r\n" + "		chc_create_by,\r\n" + "		chc_create_date,\r\n"
						+ "		chc_due_id,\r\n" + "		chc_due_to,\r\n" + "		chc_due_date,\r\n"
						+ "		chc_status\r\n" + "		from sal_chance where 1=1";
				if (StringUtils.isNotBlank(salChance.getTjian()) && StringUtils.isNotBlank(salChance.getStr())) {
					try {
//						String tjian = camelName(salChance.getTjian());//驼峰命名
						sqls += " and " + salChance.getTjian() + " like '%" + salChance.getStr() + "%'";
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				sqls += " and chc_status !=3 order by chc_id desc";
				NativeQuery query = session.createNativeQuery(sqls);
				// 设置参数
				if (pageBean.isPagination()) {
					String sql = "select count(chc_id) from sal_chance where 1=1";
					if (StringUtils.isNotBlank(salChance.getTjian()) && StringUtils.isNotBlank(salChance.getStr())) {
						sql += " and " + salChance.getTjian() + " like '%" + salChance.getStr() + "%'";
					}
					sql += "  and chc_status !=3";
					Query query2 = session.createNativeQuery(sql);
					List list = query2.list();
					if (null != list && 0 != list.size()) {
						pageBean.setTotal(Integer.parseInt(list.get(0).toString()));
					}
				}
				query.setFirstResult(pageBean.getStartIndex());
				query.setMaxResults(pageBean.getRows());
				List emps = query.list();
				for (int i = 0; i < emps.size(); i++) {
					// 将集合转为object数组 并获取到每一行的元素
					Object[] obj = (Object[]) emps.get(i);
					// 给每个元素赋值 相应的实体类
					SalChance salChance = new SalChance((Integer) obj[0], (String) obj[1], (String) obj[2],
							(String) obj[3], (Integer) obj[4], (String) obj[5], (String) obj[6], (String) obj[7],
							(String) obj[8], (String) obj[9], (Timestamp) obj[10], (Integer) obj[11], (String) obj[12],
							(Timestamp) obj[13], (String) obj[14]);
					rows.add(salChance);
				}
				return rows;
			}
		});
	}

	@Override
	public SalChance get(SalChance salChance) {
		SalChance sal = this.getHibernateTemplate().get(SalChance.class, salChance.getChcId());
		return sal;
	}

//	/**
//	 * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。
//	 * 例如：HELLO_WORLD->HelloWorld
//	 * 
//	 * @param name 转换前的下划线大写方式命名的字符串
//	 * @return 转换后的驼峰式命名的字符串
//	 */
//	public static String camelName(String name) {
//		StringBuilder result = new StringBuilder();
//		// 快速检查
//		if (name == null || name.isEmpty()) {
//			// 没必要转换
//			return "";
//		} else if (!name.contains("_")) {
//			// 不含下划线，仅将首字母小写
//			return name.substring(0, 1).toLowerCase() + name.substring(1);
//		}
//		// 用下划线将原始字符串分割
//		String camels[] = name.split("_");
//		for (String camel : camels) {
//			// 跳过原始字符串中开头、结尾的下换线或双重下划线
//			if (camel.isEmpty()) {
//				continue;
//			}
//			// 处理真正的驼峰片段
//			if (result.length() == 0) {
//				// 第一个驼峰片段，全部字母都小写
//				result.append(camel.toLowerCase());
//			} else {
//				// 其他的驼峰片段，首字母大写
//				result.append(camel.substring(0, 1).toUpperCase());
//				result.append(camel.substring(1).toLowerCase());
//			}
//		}
//		return result.toString();
//	}

}
