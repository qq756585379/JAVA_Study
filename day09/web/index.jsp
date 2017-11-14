<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/13
  Time: 下午9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
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

<c:if test="${ empty u }">
    <a href="login.jsp">登录</a>
    <a href="regist.jsp">注册</a>
</c:if>

<c:if test="${not empty u }">
    欢迎你：${u.name } <a href="${pageContext.request.contextPath }/servlet/loginOutServlet">注消</a>
</c:if>

</body>
</html>
