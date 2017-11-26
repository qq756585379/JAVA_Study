<%@ page import="com.itheima.domain.User" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/25
  Time: 下午6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<%
    //session.invalidate();//使session销毁
    request.setAttribute("aaa", "tom");
    request.setAttribute("aaa", "jerry");
    request.removeAttribute("name");
    session.setAttribute("u", new User());
%>
</body>

</html>
