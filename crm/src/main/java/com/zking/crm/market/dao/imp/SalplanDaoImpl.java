package com.zking.crm.market.dao.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateCallback;

import com.zking.crm.base.dao.BaseDao;
import com.zking.crm.base.entity.SalPlan;
import com.zking.crm.base.entity.SalPlanItem;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.market.dao.ISalplanDao;

public class SalplanDaoImpl extends BaseDao implements ISalplanDao {

	@Override
	public void addSalplan(SalPlanItem salPlanItem) {
		this.getHibernateTemplate().save(salPlanItem);
	}

	@Override
	public void editSalplan(SalPlan salPlan) {
		this.getHibernateTemplate().update(salPlan);
	}

	@Override
	public void editPlanItem(SalPlanItem salPlanItem) {
		this.getHibernateTemplate().execute(new HibernateCallback<SalPlanItem>() {

			@Override
			public SalPlanItem doInHibernate(Session session) throws HibernateException {
				String sql = "update sal_plan_item set pla_result_item='" + salPlanItem.getPlaResultItem()
						+ "' where pitem_id = " + salPlanItem.getPitemId();
				session.createNativeQuery(sql).executeUpdate();
				return null;
			}
		});
	}

	@Override
	public void delPlanItem(SalPlanItem salPlanItem) {
		this.getHibernateTemplate().execute(new HibernateCallback<SalPlanItem>() {

			@Override
			public SalPlanItem doInHibernate(Session session) throws HibernateException {
				String sql = "delete from sal_plan_item where pitem_id = " + salPlanItem.getPitemId();
				session.createNativeQuery(sql).executeUpdate();
				return null;
			}
		});
	}

	@Override
	public void delSalplan(SalPlan salPlan) {
		this.getHibernateTemplate().execute(new HibernateCallback<SalPlan>() {

			@Override
			public SalPlan doInHibernate(Session session) throws HibernateException {
				String planitemdel = "DELETE from sal_plan_item where pla_id_item =" + salPlan.getPlaId();
				session.createNativeQuery(planitemdel).executeUpdate();
				String sql = "delete from sal_plan where pla_chc_id =" + salPlan.getPlaChcId();
				String sql2 = "update sal_chance set chc_status = 4,chc_due_id='" + 0
						+ "',chc_due_to='',chc_due_date = '" + new Timestamp(System.currentTimeMillis())
						+ "' where chc_id=" + salPlan.getPlaChcId();
				session.createNativeQuery(sql2).executeUpdate();
				session.createNativeQuery(sql).executeUpdate();
				return null;
			}
		});
	}

	@Override
	public void successSalplan(SalPlan salPlan) {
		this.getHibernateTemplate().execute(new HibernateCallback<SalPlan>() {

			@Override
			public SalPlan doInHibernate(Session session) throws HibernateException {
				String cno = UUID.randomUUID().toString().replace("-", "");
				String sql = "delete from sal_plan where pla_chc_id =" + salPlan.getPlaChcId();
				String sql2 = "update sal_chance set chc_status = 3 where chc_id=" + salPlan.getPlaChcId();
				String sql3 = "insert into cst_customer(cust_no,cust_name,cust_manager_id,cust_manager_name,cust_tel)\r\n"
						+ "values('" + cno + "','" + salPlan.getChcCustName() + "','" + "1" + "','"
						+ salPlan.getChcDueTo() + "','" + salPlan.getChcTel() + "')";
				String sql4 = "insert into cst_linkman (lkm_cust_no,lkm_cust_name,lkm_name,lkm_tel) VALUES('" + cno
						+ "','" + salPlan.getChcCustName() + "','" + salPlan.getChcLinkman() + "','"
						+ salPlan.getChcTel() + "')";
				session.createNativeQuery(sql).executeUpdate();
				session.createNativeQuery(sql2).executeUpdate();
				// 向客户信息表插入数据
				session.createNativeQuery(sql3).executeUpdate();
				// 向联系人表插入记录
				session.createNativeQuery(sql4).executeUpdate();
				return null;
			}
		});
	}

	public List<SalPlanItem> querySalplanItem(SalPlanItem salPlanItem, PageBean pageBean) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<SalPlanItem>>() {

			@Override
			public List<SalPlanItem> doInHibernate(Session session) throws HibernateException {
				String hql = " from SalPlanItem where plaIdItem=" + salPlanItem.getPlaIdItem();
				Query<SalPlanItem> query = session.createQuery(hql, SalPlanItem.class);
				if (pageBean.isPagination()) {
					String hql2 = "select count(plaIdItem) from SalPlanItem where plaIdItem="
							+ salPlanItem.getPlaIdItem();
					Query query2 = session.createQuery(hql2);
					List lit = query2.list();
					if (null != lit && 0 != lit.size()) {
						pageBean.setTotal(Integer.parseInt(lit.get(0).toString()));
					}
				}
				query.setFirstResult(pageBean.getStartIndex());
				query.setMaxResults(pageBean.getRows());
				return query.list();
			}
		});
	}

	@Override
	public List<SalPlan> querySalplanPager(SalPlan salPlan, PageBean pageBean) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<SalPlan>>() {
			List<SalPlan> list = new ArrayList<>();

			@Override // select c.* from sal_chance c,sal_plan p where c.chc_id=p.pla_chc_id
			public List<SalPlan> doInHibernate(Session session) throws HibernateException {
				String sql = "select c.*,p.* from sal_chance c,sal_plan p where c.chc_id=p.pla_chc_id";
				if (StringUtils.isNotBlank(salPlan.getTjian()) && StringUtils.isNotBlank(salPlan.getStr())) {// 不同条件模糊查询
					if (salPlan.getTjian().subSequence(0, 3).equals("pla")) {
						sql += " and p." + salPlan.getTjian() + " like '%" + salPlan.getStr() + "%'";
					} else {
						sql += " and c." + salPlan.getTjian() + " like '%" + salPlan.getStr() + "%'";
					}
				}
//				sql +=" and pla_todo is null or pla_todo=' '";
				sql += " and chc_status !=4 order by p.pla_id desc";
//				sql +=" GROUP BY p.pla_chc_id";
				NativeQuery query2 = session.createNativeQuery(sql);
				if (pageBean.isPagination()) {
					String sql2 = "select count(c.chc_id) from sal_chance c,sal_plan p where c.chc_id=p.pla_chc_id";
					if (StringUtils.isNotBlank(salPlan.getTjian()) && StringUtils.isNotBlank(salPlan.getStr())) {// 不同条件模糊查询
						if (salPlan.getTjian().subSequence(0, 3).equals("pla")) {
							sql2 += " and p." + salPlan.getTjian() + " like '%" + salPlan.getStr() + "%'";
						} else {
							sql2 += " and c." + salPlan.getTjian() + " like '%" + salPlan.getStr() + "%'";
						}
					}
//					sql2 +=" and pla_todo is null or pla_todo=' '";
					sql2 += "  and chc_status !=4";
//					sql2 +=" GROUP BY p.pla_chc_id";
					Query query = session.createNativeQuery(sql2);
					List lit = query.list();
					if (null != lit && 0 != lit.size()) {
						pageBean.setTotal(Integer.parseInt(lit.get(0).toString()));
					}
				}
				query2.setFirstResult(pageBean.getStartIndex());
				query2.setMaxResults(pageBean.getRows());
				List emps = query2.list();
				for (int i = 0; i < emps.size(); i++) {
					// 将集合转为object数组 并获取到每一行的元素
					Object[] obj = (Object[]) emps.get(i);
					// 给每个元素赋值 相应的实体类
					SalPlan salPlan = new SalPlan((Integer) obj[0], (String) obj[1], (String) obj[2], (String) obj[3],
							(Integer) obj[4], (String) obj[5], (String) obj[6], (String) obj[7], (String) obj[8],
							(String) obj[9], (Timestamp) obj[10], (Integer) obj[11], (String) obj[12],
							(Timestamp) obj[13], (String) obj[14], (Integer) obj[15], (Integer) obj[16],
							(Timestamp) obj[17], (String) obj[18], (String) obj[19]);
					list.add(salPlan);
				}
				return list;
			}
		});
	}

	@Override
	public SalPlan get(SalPlan salPlan) {
		SalPlan salPlan2 = this.getHibernateTemplate().get(SalPlan.class, salPlan.getPlaId());
		return salPlan2;
	}

//	public static void main(String[] args) {
//		SalplanDaoImpl salplanDaoImpl = new SalplanDaoImpl();
//		SalPlanItem salPlanItem = new SalPlanItem();
//		salPlanItem.setPlaIdItem(9);
//		List<SalPlanItem> item = salplanDaoImpl.querySalplanItem(salPlanItem);
//		for (SalPlanItem sal : item) {
//			System.out.println(sal);
//		}
//	}
}
