<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html;"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JNDI数据源测试</title>
</head>
<body>
	<%
	Connection con=null;
	try{
		//1 初始化名称查找上下文
		Context ctx=new InitialContext();
		//2 通过JNDI名称找到DataSource，对名称进行定位java:comp/env是必须加的，后面跟的是DataSource名
		//DataSource名在web.xml文件中的<resource-ref>进行了配置
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/jndiMysqlConnection");
		out.println("通过DataSource取得一个连结");
		//3 通过DataSource取得一个连结
		con= ds.getConnection();
		out.println("success:mysql connection pool connected");
		//4 操作数据库
	}catch(Exception ex){
		out.println("err:"+ex.getMessage());
	}
	finally{
		//5 关闭数据库，关闭的时候是将连结放回到连接池中
		out.println("closed^^^");
	}
	%>
</body>
</html>