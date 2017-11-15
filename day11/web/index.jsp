<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/15
  Time: 下午10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>$Title$</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>

<%
    Context initContext = new InitialContext();
    //java:/comp/env 是固定语法， jdbc/day01 是META-INF下的context.xml里定义的name
    //如果是在tomcat的context.xml里配置则是全局配置
    DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/day01");
    Connection conn = ds.getConnection();
    out.print(conn);

    DataSource ds2 = (DataSource) initContext.lookup("java:/comp/env/jdbc/day02");
    Connection conn2 = ds2.getConnection();
    out.print(conn2);
%>

<%--
 用JavaWeb服务器管理数据源：Tomcat (了解)
 开发JavaWeb应用，必须使用一个JavaWeb服务器，JavaWeb服务器都内置数据源。 Tomcat：（DBCP）
 数据源只需要配置服务器即可。
 配置数据源的步骤：
 1、拷贝数据库连接的mysql-connector-java-5.0.8-bin.jar到tomcatlib目录下
 2、配置数据源XML文件
 a)如果把配置信息写在tomcat下的conf目录的context.xml中，那么所有应用都能使用此数据源。
 b)如果是在当前应用的META-INF中创建context.xml, 编写数据源，那么只有当前应用可以使用。
--%>

</body>
</html>
