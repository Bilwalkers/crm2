package com.zking.crm.base.jwt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.crm.base.entity.Module;
import com.zking.crm.base.entity.User;
import com.zking.crm.base.util.CommonUtils;
import com.zking.crm.permission.biz.IModuleBiz;
import com.zking.crm.permission.biz.IUserBiz;

import io.jsonwebtoken.Claims;

/**
 * * JWT验证过滤器，配置顺序 ：CorsFilte-->JwtFilter-->struts2中央控制器
 * 
 * @author Administrator
 *
 */
public class JwtFilter implements Filter {

	// 排除的URL，一般为登陆的URL(请改成自己登陆的URL)
	private static String EXCLUDE = "^/userAction_userLogin\\.action?.*$";
	private static Pattern PATTERN = Pattern.compile(EXCLUDE);
	private boolean OFF = false;// true关闭jwt令牌验证功能

	// 默认过滤的jsp页面 action请求操作,来自于后台数据表t_module中pid=所设公共权限的pid
	List<String> publicUrl;

	ApplicationContext ac;
	IModuleBiz moduleBiz;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		moduleBiz = ac.getBean("moduleBiz", IModuleBiz.class);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getServletPath();

		if (OFF || isExcludeUrl(url)) {// 登陆直接放行
			chain.doFilter(request, response);
			return;
		}
		// 从客户端请求头中获得令牌并验证
		String jwt = req.getHeader(JwtUtils.JWT_HEADER_KEY);
		Claims claims = this.validateJwtToken(jwt);
		if (null == claims) {
			resp.setCharacterEncoding("UTF-8");
			resp.sendError(403, "JWT令牌已过期或已失效");
			return;
		} else {
			String newJwt = JwtUtils.copyJwt(jwt, JwtUtils.JWT_WEB_TTL);
			resp.setHeader(JwtUtils.JWT_HEADER_KEY, newJwt);
			List<Module> auth = moduleBiz.queryModuleAuth();
			publicUrl = new ArrayList<String>();
//			System.out.println(auth);
			for (Module mod : auth) {
				publicUrl.add(mod.getUrl());
			}

			// 如果是公共路径
			if (publicUrl.contains(url)) {
				chain.doFilter(request, response);
			} else {// 如果不是公共路径 那么就要设置访问权限了
				// 用户登陆超时 或者没有登陆直接跳转到其他页面
				if (null == claims) {
					CommonUtils.toJSONMEssager(resp, false, "登陆超时,请重新登陆");
				} else {// 现在用户已经登陆了
					System.out.println("直接得到方法路径即可" + url);
					IUserBiz userBiz = ac.getBean("userBiz", IUserBiz.class);
					String username = (String) claims.get("username");
					String password = (String) claims.get("password");
					User user = new User();
					user.setUsername(username);
					user.setPassword(password);
					User user2 = userBiz.userLogin(user);
					// 将当前请求路径与session中的user对象中的角色权限进行判断
					if (isAccess(url, user2)) {// 用户对象还没写到
						// 有权限则放行
						chain.doFilter(request, response);
					} else {
						CommonUtils.toJSONMEssager(resp, false, "无权限,请联系管理员!");
					}
				}
			}
		}

	}

	public boolean isAccess(String url, User us) {
		System.out.println("树:" + url);
		boolean b = false;
		// 获取user的所有权限
		List<Module> lists = moduleBiz.queryModuleByUserId(us.getId());
		for (Module mod : lists) {
			if(url.equals(mod.getUrl())) {
				b=true;
				break;
			}
		}
		
		return b;
	}

	/**
	 * 验证jwt令牌，验证通过返回声明(包括公有和私有)，返回null则表示验证失败
	 */
	private Claims validateJwtToken(String jwt) {
		Claims claims = null;
		try {
			if (null != jwt) {
				claims = JwtUtils.parseJwt(jwt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claims;
	}

	/**
	 * 是否为排除的URL
	 * 
	 * @param path
	 * @return
	 */
	private boolean isExcludeUrl(String path) {
		Matcher matcher = PATTERN.matcher(path);
		return matcher.matches();
	}

	// public static void main(String[] args) {
	// String path = "/sys/userAction_doLogin.action?username=zs&password=123";
	// Matcher matcher = PATTERN.matcher(path);
	// boolean b = matcher.matches();
	// System.out.println(b);
	// }

}
