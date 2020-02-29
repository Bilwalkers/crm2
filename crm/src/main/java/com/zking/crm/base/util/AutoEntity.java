package com.zking.crm.base.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AutoEntity {
	private String packageOutPath;// 指定实体生成所在包的路径
	private String outPath;//写出到那个项目下的路径 ， 非包路径
	private String tablename;// 表名
	private String CamelCaseTableName;//驼峰命名法表名（类名）
	private String databasename;// 数据库名
	private List<String> tablenames;// 拿到对应数据库中所有的实体类（实体类需要与其他表明做区分）
	private List<String> colnames; // 实体类列名集合
	private List<String> colSqlNAME;//数据库列名集合
	private String colPrimary;//数据库主键列名
	private String colPrimaryType;//数据库主键列类型
	private List<String> colTypes; // 实体类列名类型集合
	private List<String> columnComments;//实体类（数据库）列名的备注
	private boolean CamelCase;//是否需要驼峰命名法;
	private boolean f_util = false; // 是否需要导入包java.util.*
	private boolean f_sql = false; // 是否需要导入包java.sql.*

	/**
	 * 构造函数 赋值
	 * @param packageOutPath 要存放的包名
	 * @param outPath   作者名字
	 * @param tablename  表名
	 * @param databasename  数据库名   （表名数据库名只要其中一个就可以）
	 */
	public AutoEntity(String packageOutPath,String outPath,String tablename,String databasename,boolean CamelCase) {
		this.packageOutPath = packageOutPath;
		this.outPath = outPath;
		this.tablename = tablename;
		this.databasename = databasename;
		this.CamelCase=CamelCase;
	}

	/**
	 * 创建多个实体类
	 * @param tablenames 表名集合
	 * @param conn Connection 连接数据库（已没用）
	 */
	private void genEntity(List<String> tablenames,String databasename, Connection conn) {
		// 使用第归生成文件
		for (String tablename : tablenames) {
			this.genEntity(tablename, databasename, conn);
		}
	}

	/**
	 * 创建单个实体类
	 * @param tablename  表名
	 * @param conn   Connection 连接数据库（已没用）
	 */
	private void genEntity(String tablename,String databasename,Connection conn) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSetMetaData rsmd = null;
		ResultSet rs=null;
		try {
			con = DBHelper.getCon(databasename);
			//SQL语句  查询对应的表
			String sql = "select * from " + tablename;
			pstmt = con.prepareStatement(sql);
			rsmd = pstmt.getMetaData();
			// 统计有多少列（多少个字段）
			int size = rsmd.getColumnCount(); 
			//创建列名集合
			colnames = new ArrayList<String>();
			//创建实体类列名类型集合
			colTypes = new ArrayList<String>();
			//创建列名的备注集合
			columnComments=new ArrayList<String>();
			colSqlNAME=new ArrayList<>();
			//有多少列  循环多少次
			for (int i = 0; i < size; i++) {
				//添加列名到集合中（字段名）驼峰命名法
				if(CamelCase) {
					if(rsmd.getColumnName(i + 1).contains("_")) {
						String[] s = rsmd.getColumnName(i + 1).split("_");
						String news=s[0];
						for (int j=1;j<=s.length-1;j++) {
							news+=this.initcap(s[j]);
						}
						colnames.add(news);
					}else {
						colnames.add(rsmd.getColumnName(i + 1));
					}
				}else//不采用驼峰命名法
					colnames.add(rsmd.getColumnName(i + 1));
				//添加实体类映射文件xml列名类型集合（字段类型）
				colSqlNAME.add(rsmd.getColumnName(i+1));
				//添加实体类列名类型集合（字段类型）
				colTypes.add(rsmd.getColumnTypeName(i + 1));
				//如果是时间类型
				if (colTypes.get(i).equalsIgnoreCase("datetime")||colTypes.get(i).equalsIgnoreCase("timestamp")) {
					//设置需要导入包java.util.*
					//f_util = true;
					f_sql = true;
				}
				//如果是图片类型  或  文本类型
				if (colTypes.get(i).equalsIgnoreCase("image") || colTypes.get(i).equalsIgnoreCase("text")) {
					//设置需要导入包java.sql.*
					f_sql = true;
				}
			}
			//给实体类列名的备注添加值
			rs = pstmt.executeQuery("show full columns from " + tablename);
            while (rs.next()) {
            	//判断备注是否为空，为空则用""
            	if("".equals(rs.getString("Comment")))
            		columnComments.add("");
            	else
            		columnComments.add("//"+rs.getString("Comment"));
            	//判断某一列是否为主键列 有则用驼峰
            	if(CamelCase) {
            		if("PRI".equals(rs.getString("Key"))){
            			String[] s = rs.getString("Field").split("_");
            			String news=s[0];
            			for (int j=1;j<=s.length-1;j++) {
            				news+=this.initcap(s[j]);
            			}
            			colPrimary=news;//xml主键列名
            			//xml主键类型
            			colPrimaryType=rs.getString("Type").substring(0, rs.getString("Type").indexOf("("));
            		}
            	}else {
            		if("PRI".equals(rs.getString("Key"))){
            			colPrimary=rs.getString("Field");//xml主键列名
            			//xml主键类型
            			colPrimaryType=rs.getString("Type").substring(0, rs.getString("Type").indexOf("("));
            		}
            	}
            }
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			//关闭连接
			DBHelper.dbClose(con, pstmt, rs);
		}
		// 在内存中生成代码
		String content = parse(tablename);//生成java实体类
		String xmlContent=myXml(tablename);//生成java实体类的映射配置文件xml
		// 写入到文件中
		try {
			File directory = new File(outPath);
			String outputPath = directory.getAbsolutePath() + "/src/main/java/" + this.packageOutPath.replace(".", "/") + "/";
			String outputXml=outputPath;
			System.out.println("写出的路径:" + outputPath);
			// 检测路径是否存在，不存在就创建路径
			File path = new File(outputPath);
			if (!path.exists() && !path.isDirectory()) {
				path.mkdir();
			}
			outputPath += this.getTuoFeng(tablename) + ".java";
			outputXml += this.getTuoFeng(tablename) + ".hbm.xml";
			System.out.println("New:"+this.getTuoFeng(tablename));
			File file = new File(outputPath);
			if (!file.exists()) {
				file.createNewFile();
			}
			// 写出到硬盘
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(content);
			pw.flush();
			pw.close();
			
			File file2 = new File(outputXml);
			if (!file2.exists()) {
				file2.createNewFile();
			}
			// 写出到硬盘
			FileWriter fw2 = new FileWriter(file2);
			PrintWriter pw2 = new PrintWriter(fw2);
			pw2.println(xmlContent);
			pw2.flush();
			pw2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件名格式
	 * @return
	 */
	private String getTuoFeng(String tablename) {
		if(CamelCase) {
			if(tablename.contains("_")&&null!=tablename) {
				CamelCaseTableName="";
				String[] s = tablename.split("_");
				for (int j=0;j<s.length;j++) {
					CamelCaseTableName+=this.initcap(s[j]);
				}
			}else{
				CamelCaseTableName=this.initcap(tablename);
			}
		}else
			CamelCaseTableName=this.initcap(tablename);
		return CamelCaseTableName;
	}
	
	/**
	 *  打印 数据库下的所有表
	 * @param conn
	 * @param tablenames
	 */
	private void getAllEntityTable(Connection conn, String databasename ,List<String> tablenames) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			/*
			 *	DatabaseMetaData dmd = (DatabaseMetaData) conn.getMetaData();
			 *  TABLE_CAT String => 表类别（可为 null） TABLE_SCHEM String => 表模式（可为null）
			 *  TABLE_NAME  String => 表名称 TABLE_TYPE String => 表类型
			 *	rs = dmd.getTables(null, null,"%", new String[]{"TABLE"});
			 */
			con=DBHelper.getCon(databasename);
			ps=con.prepareStatement("SELECT * FROM information_schema.tables WHERE table_schema='"+databasename+"'");
			rs=ps.executeQuery();
			while (rs.next()) {
				tablenames.add(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 *在内存中生成代码
	 * @param tablename  表名
	 * @return 返回代码
	 */
	private String parse(String tablename) {
		StringBuffer sb = new StringBuffer();
		//导入对应的包（实体类所在的包   src后的包）
		sb.append("package " + this.packageOutPath + ";\r\n\n"
				+ "import java.io.Serializable;\r\n");
		// 判断是否导入工具包
		if (f_util) {
			sb.append("import java.util.Date;\r\n");
		}
		if (f_sql) {
			sb.append("import java.sql.Timestamp;\r\n");
		}
		sb.append("\r\n");
		// 注释部分
		sb.append(" /**\r\n");
		sb.append(" * " + initcap(tablename) + " 实体类\r\n");
		//获取系统时间
		String da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//时间加作者名
		sb.append(" * " + da + "\r\n");
		sb.append(" */ \r\n");
		// 实体部分
		sb.append("\r\n\r\npublic class " + this.getTuoFeng(tablename) + " implements Serializable {\r\n");
		processAllAttrs(sb);// 属性
		processAllFunction(sb,this.getTuoFeng(tablename));
		processAllMethod(sb);// get set方法
		processTostring(sb, this.getTuoFeng(tablename));//tostring方法
		sb.append("}\r\n");
		return sb.toString();
	}
	
	/**
	 * 拼接xml实体映射文件
	 * @param tablename
	 * @return
	 */
	private String myXml(String tablename) {
		StringBuffer sb2 = new StringBuffer();
		sb2.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"  <!DOCTYPE hibernate-mapping PUBLIC \r\n" + 
				"    \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"\r\n" + 
				"    \"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">\r\n" + 
				"<hibernate-mapping>\r\n");
			sb2.append("\t<class name=\""+this.packageOutPath+"."+this.getTuoFeng(tablename)+"\" table=\""+tablename+"\">\r\n");
				this.processAllAttrs2(sb2);
			sb2.append("\t</class>\r\n");
		sb2.append("</hibernate-mapping>");
		return sb2.toString();
	}
	
	

	/**
	 * 功能：生成所有属性
	 *
	 * @param sb
	 */
	private void processAllAttrs(StringBuffer sb) {
		//遍历字段集合
		for (int i = 0; i < colnames.size(); i++) {
			//拼写属性     sqlType2JavaType把数据库字段类型转为java对应的数据类型
			sb.append("\tprivate " + sqlType2JavaType(colTypes.get(i)) + " " + colnames.get(i) + ";"+columnComments.get(i)+"\r\n");
		}
	}
	
	/**
	 * 拼接实体映射文件的class
	 * @param sb2
	 */
	private void processAllAttrs2(StringBuffer sb2) {
		//遍历字段集合
		if(null==colPrimary)//不存在主键的话就直接在xml文件中定义一个<id></id>
			sb2.append("\t\t<id></id>\r\n");
		for (int i = 0; i < colnames.size(); i++) {
			//拼写属性     sqlType2XmlType把数据库字段类型转为java对应的数据类型
			if(colnames.get(i).equals(colPrimary)) {//设置主键列
				String primaryType = sqlType2XmlType(colPrimaryType);
				String idMent="native";
				if("java.lang.String".equals(primaryType))
					idMent="uuid";
				sb2.append("\t\t<id name=\""+colPrimary+"\" type=\""+primaryType+"\" column=\""+colSqlNAME.get(i)+"\">\r\n" + 
						"	\t\t<generator class=\""+idMent+"\"></generator>\r\n" + 
						"	\t</id>\r\n");
			}else
				sb2.append("\t\t<property name=\""+colnames.get(i)+"\" type=\""+sqlType2XmlType(colTypes.get(i))+"\"  column=\""+colSqlNAME.get(i)+"\" />\r\n");
		}
		colPrimary=null;
	}
	
	/**
	 * 功能：无参构造，有参构造
	 * @param sb
	 * @param tablename
	 */
	private void processAllFunction(StringBuffer sb,String tablename) {
		//无参构造
		sb.append("\n\tpublic\t"+tablename+"(){}\t\n");
		//有参构造，全部字段
		sb.append("\n\tpublic\t"+tablename+"(");
		//遍历字段集合 形成参数
		for (int i = 0; i < colnames.size(); i++) {
			//拼写属性     sqlType2JavaType把数据库字段类型转为java对应的数据类型
			if(colnames.size()-1!=i) 
				sb.append(sqlType2JavaType(colTypes.get(i)) + " " + colnames.get(i) + ",");
			else//去掉最后一个属性的,
				sb.append(sqlType2JavaType(colTypes.get(i)) + " " + colnames.get(i));
		}
		sb.append("){\n");
		for (int i = 0; i < colnames.size(); i++) {
			//拼写属性     sqlType2JavaType把数据库字段类型转为java对应的数据类型
			sb.append("\t\t this."+colnames.get(i)+"="+ colnames.get(i)+";\n");
		}
		sb.append("\t}\n");
	}

	/**
	 * 功能：生成所有get,set方法
	 *
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		//遍历字段集合
		for (int i = 0; i < colnames.size(); i++) {
			// 拼写 set方法
			sb.append("\n\tpublic void set" + initcap(colnames.get(i)) + "(" + sqlType2JavaType(colTypes.get(i)) + " "
					+ colnames.get(i) + "){\r\n");
			sb.append("\t\tthis." + colnames.get(i) + "=" + colnames.get(i) + ";\r\n");
			sb.append("\t}\r\n");
			
			//拼写 get方法
			sb.append("\n\tpublic " + sqlType2JavaType(colTypes.get(i)) + " get" + initcap(colnames.get(i)) + "(){\r\n");
			sb.append("\t\treturn " + colnames.get(i) + ";\r\n");
			sb.append("\t}\r\n");
		}
	}
	
	/**
	 * 功能：生成tostring方法
	 * @param sb
	 * @Override
	 */
	
	private void processTostring(StringBuffer sb,String tablename) {
		sb.append("\n\t public String toString(){\n\t\t return \""+tablename+"[");
		for (int i = 0; i < colnames.size(); i++) {
			//拼写属性     sqlType2JavaType把数据库字段类型转为java对应的数据类型
			if(colnames.size()-1!=i) 
				sb.append(colnames.get(i)+"=\"\t+"+ colnames.get(i)+"+\",");
			else//去掉最后一个属性的,变为;
				sb.append(colnames.get(i)+"=\"\t+"+ colnames.get(i)+"+\"]\";\n");
			
		}
		sb.append("\t}\n");
	}

	/**
	 * 功能：将输入字符串的首字母改成大写
	 *
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		//转换为char数组
		char[] ch = str.toCharArray();
		//如果是小字母
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			//转换为大写
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	/**
	 * 功能：获得列的数据类型
	 *
	 * @param sqlType 数据库类型名
	 * @return 返回java对应的数据类型
	 */
	private String sqlType2JavaType(String sqlType) {
		if (sqlType.equalsIgnoreCase("bit")) {//如果是boolean
			return "boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")) {//如果是整数
			return "byte";
		} else if (sqlType.equalsIgnoreCase("smallint")) {//如果是整数
			return "short";
		} else if (sqlType.equalsIgnoreCase("int")) {//如果是整数
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("bigint")) {//如果是整数
			return "Long";
		} else if (sqlType.equalsIgnoreCase("float")) {//如果是小数
			return "Float";
		} else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
				|| sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
				|| sqlType.equalsIgnoreCase("smallmoney")) {//如果是小数
			return "double";
		} else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
				|| sqlType.equalsIgnoreCase("text")) {//如果是字符串
			return "String";
		} else if (sqlType.equalsIgnoreCase("datetime")||sqlType.equalsIgnoreCase("timestamp")) {//如果是时间
			return "Timestamp";
		} else if (sqlType.equalsIgnoreCase("image")) {//如果是图片
			return "Blod";
		}
		return null;
	}
	
	/**
	 * 将常用的数据库的类型转为实体类映射文件的类型
	 * @param sqlType
	 * @return
	 */
	private String sqlType2XmlType(String sqlType) {
		if (sqlType.equalsIgnoreCase("bit")) {//如果是boolean
			return "java.lang.Boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")) {//如果是整数
			return "byte";
		} else if (sqlType.equalsIgnoreCase("smallint")) {//如果是整数
			return "short";
		} else if (sqlType.equalsIgnoreCase("int")) {//如果是整数
			return "java.lang.Integer";
		} else if (sqlType.equalsIgnoreCase("bigint")) {//如果是整数
			return "java.lang.Long";
		} else if (sqlType.equalsIgnoreCase("float")) {//如果是小数
			return "java.lang.Float";
		} else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
				|| sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
				|| sqlType.equalsIgnoreCase("smallmoney")) {//如果是小数
			return "java.lang.Double";
		} else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
				|| sqlType.equalsIgnoreCase("text")) {//如果是字符串
			return "java.lang.String";
		} else if (sqlType.equalsIgnoreCase("datetime")||sqlType.equalsIgnoreCase("timestamp")) {//如果是时间
			return "java.sql.Timestamp";
		} else if (sqlType.equalsIgnoreCase("image")) {//如果是图片
			return "Blod";
		}
		return null;
	}

	private void start() {
		// 创建连接
		Connection conn = null;
		//打印单个实体类
		if (databasename != null && !databasename.equals("") && tablename != null && !tablename.equals("")) {
			// 为指定库下的指定表名 生成指定的实体类
			conn=DBHelper.getCon(databasename);
			genEntity(tablename,databasename,conn);
		//打印对应库下的所有表，生成实体类
		} else {
			// 如果配置文件中有数据库名字，则可以拿到其中所有的实体类
			if (databasename != null && !databasename.equals("")) {
				conn=DBHelper.getCon(databasename);//自主选择的库名
				// 获取所有实体表名字
				tablenames = new ArrayList<String>();
				getAllEntityTable(conn,databasename,tablenames);
				// 为每个实体表生成实体类
				genEntity(tablenames,databasename, conn);
			} 
		}
		// 关闭数据库连接
		if (conn != null) {
			DBHelper.dbClose(conn, null, null);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//项目文件路径名
		String outPath = "D:\\workspaceY2\\crm";
		//包名
		String packageOutPath = "com.zking.crm.base.entity";
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你要从mysql打印的数据库的名字：");
		String databasename = sc.next();//数据库名
		System.out.println("是否需要打印"+databasename+"数据库下的某一个表 ，是？就回复请输入1,否则按除1以外的其他阿拉伯数字");
		int b=sc.nextInt();
		String tablename =null;//表名
		if(1==b) {
			System.out.println("请输入表名：");
			tablename=sc.next();
		}
		System.out.println("是否采用驼峰命名法，true为使用，false不使用");
		boolean tfName=sc.nextBoolean();
		
		new AutoEntity(packageOutPath,outPath,tablename,databasename,tfName).start();
	}
}

/**
 * jdbc 连接mysql数据库
 * @author Administrator
 *
 */
class DBHelper {
	private static final String str="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306";
	
	static {
		try {
			Class.forName(str);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon(String km) {
		Connection con=null;
		try {
			con=DriverManager.getConnection(url+"/"+km+"?useUnicode=true&serverTimezone=GMT&characterEncoding=utf8&useSSL=true", "root", "123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void dbClose(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
			if(con!=null) {
				con.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
 

