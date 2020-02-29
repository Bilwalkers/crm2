package com.zking.crm.permission.dao.impl;

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
import com.zking.crm.base.entity.User;
import com.zking.crm.base.entity.UserRole;
import com.zking.crm.base.util.PageBean;
import com.zking.crm.base.util.StringUtils;
import com.zking.crm.permission.dao.IUserDao;

public class UserDaoImpl extends BaseDao implements IUserDao {

	
	
	@Override
	public List<User> roleUser(User user) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			List<User> list = new ArrayList<User>();
			public List<User> doInHibernate(Session session) throws HibernateException {
				String sql = "select u.id,u.username,r.* from t_user u,t_user_role ur,t_role r"
						+ " where u.id=ur.userid and ur.roleid=r.roleid and r.rolename"
						+ " like '%"+user.getRolename()+"%'";
				NativeQuery query2 = session.createNativeQuery(sql);
				List<Object> emps = query2.list();
				//遍历结果集
				for (int i = 0; i < emps.size(); i++) {
					//将集合转为object数组 并获取到每一行的元素
					Object[] obj = (Object[])emps.get(i);
					//给每个元素赋值 相应的实体类
					User c= new User((String)obj[0], (String)obj[1],(String)obj[2],(String)obj[3]);
					list.add(c);
				}
				return list;
			}
		});
	}

	
	
	@Override
	public User userLogin(User user) {
		List<User> lst = super.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			public List<User> doInHibernate(Session session) throws HibernateException {
				/*String hql = "from User where username=:uname and password=:pwd";
				Query<User> query = session.createQuery(hql, User.class);
				query.setParameter("uname", user.getUsername());
				query.setParameter("pwd", user.getPassword());
				System.out.println(hql);
				List<User> list = query.list();*/
				List<User> lt=new ArrayList<>();
				String sql="select u.id,u.username,u.password,r.roleid,r.rolename from t_user u,t_user_role ur,t_role r "
						+ "where u.id=ur.userid and ur.roleid=r.roleid "
						+ "and u.username='"+user.getUsername()+"' and u.password='"+user.getPassword()+"'";
				NativeQuery query = session.createNativeQuery(sql);
				List list = query.list();
				for (int i = 0; i < list.size(); i++) {
					Object[] obj = (Object[])list.get(i);
					User us=new User((String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4]);
					lt.add(us);
				}
				return lt;
			}
		});
		if (null != lst && 0 != lst.size())
			return lst.get(0);
		else
			throw new RuntimeException();
	}

	@Override
	public void addUser(User user) {
		super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				user.setId(UUID.randomUUID().toString().replace("-", ""));
				String sql = "insert into t_user(id,username,password,deptment)" + " values('" + user.getId() + "','"
						+ user.getUsername() + "','" + user.getPassword() + "','" + user.getDeptment() + "')";
				NativeQuery<User> query = session.createNativeQuery(sql, User.class);
				Integer i = query.executeUpdate();
				String sql2 = "insert into t_user_role(userid,roleid) values('" + user.getId() + "','"
						+ user.getRoleid() + "')";
				NativeQuery<UserRole> query2 = session.createNativeQuery(sql2, UserRole.class);
				i = query2.executeUpdate();
				return i;
			}
		});
	}

	@Override
	public void delUser(User user) {
		super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String sql = "delete from t_user where id = '" + user.getId() + "'";
				NativeQuery<User> query = session.createNativeQuery(sql, User.class);
				int i = query.executeUpdate();
				String sql2 = "delete from t_user_role where userid = '" + user.getId() + "'";
				NativeQuery<UserRole> query2 = session.createNativeQuery(sql2, UserRole.class);
				i = query2.executeUpdate();
				return i;
			}
		});
	}

	@Override
	public void editUser(User user) {
		super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				String sql = "update t_user set username='"+user.getUsername()+ "'," + " password='" + user.getPassword() + "'," + "deptment='"
						+ user.getDeptment() + "' where id='" + user.getId() + "'";
				NativeQuery<User> query = session.createNativeQuery(sql,User.class);
				int i = query.executeUpdate();
				String sql1 = "update t_user_role set roleid='" + user.getRoleid() +
						"' where userid='" + user.getId()+"'";
				NativeQuery<UserRole> query2 = session.createNativeQuery(sql1,UserRole.class);
				i=query2.executeUpdate();
				return i;
			}
		});

	}

	@Override
	public List<User> queryUserPager(User user, PageBean pageBean) {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			List<User> list = new ArrayList<User>();
			public List<User> doInHibernate(Session session) throws HibernateException {
				// 使用连表查询
				String sql = "SELECT u.*,ro.*,b.dict_item FROM `t_user` u,bas_dict b,t_user_role r,t_role ro "
						+ " where u.deptment=b.dict_value and u.id=r.userid and ro.roleid=r.roleid";
				
				if(StringUtils.isNotBlank(user.getTjian()) && StringUtils.isNotBlank(user.getContent())) {
					sql+=" and "+user.getTjian()+" like '%"+user.getContent()+"%'";
				}
				
				// 得到查询结果集
				NativeQuery query2 = session.createNativeQuery(sql);
				// 分页
				if (pageBean.isPagination()) {
					String hql2 = "select count(1) from User ";
					if(StringUtils.isNotBlank(user.getTjian()) && StringUtils.isNotBlank(user.getContent())) {
						if("dect_item".equals(user.getTjian())) {
							String str = user.getTjian();
							str="dectItem";
							hql2+=" and "+str+" like '%"+user.getContent()+"%'";
						}
					}
					Query query = session.createQuery(hql2);
					List lst = query.list();
					if (null != lst && 0 != lst.size()) {
						pageBean.setTotal(Integer.parseInt(lst.get(0).toString()));
					}
				}
				// 设置起始页和总记录数
				query2.setFirstResult(pageBean.getStartIndex());
				query2.setMaxResults(pageBean.getRows());

				List<Object> emps = query2.list();
				// 遍历结果集
				for (int i = 0; i < emps.size(); i++) {
					// 将集合转为object数组 并获取到每一行的元素
					Object[] obj = (Object[]) emps.get(i);
					// 给每个元素赋值 相应的实体类
					User u = new User((String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3],(Timestamp) obj[4], (String) obj[5],(String)obj[6],(String)obj[7]);
					list.add(u);
				}
				return list;
			}
		});
	}

	@Override
	public User getUser(User user) {
		List<User> lst = super.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
			public List<User> doInHibernate(Session session) throws HibernateException {
				List<User> lt=new ArrayList<>();
				String sql="select u.id,u.username,u.password,r.roleid,r.rolename from t_user u,t_user_role ur,t_role r "
						+ "where u.id=ur.userid and ur.roleid=r.roleid "
						+ "and u.username='"+user.getUsername()+"' and u.password='"+user.getPassword()+"'";
				NativeQuery query = session.createNativeQuery(sql);
				List list = query.list();
				for (int i = 0; i < list.size(); i++) {
					Object[] obj = (Object[])list.get(i);
					User us=new User((String)obj[0], (String)obj[1], (String)obj[2], (String)obj[3], (String)obj[4]);
					lt.add(us);
				}
				return lt;
			}
		});
		if (null != lst && 0 != lst.size())
			return lst.get(0);
		else
			throw new RuntimeException();
	}

}
