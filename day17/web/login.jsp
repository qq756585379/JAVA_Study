<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/24
  Time: 下午10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login</title>
</head>
<body>

${msg }
<form action="${pageContext.request.contextPath }/servlet/loginServlet" method="post">
    username：<input type="text" name="username"/><br/>
    password：<input type="password" name="password"/><br/>
    <input type="checkbox" name="autologin"/>自动登录<br/>
    <input type="submit" value="登录"/><br/>
</form>

</body>
</html>
