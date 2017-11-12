<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 上午12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<body>

<%
    String msg = (String) request.getAttribute("msg");
    if (msg != null)
        out.print(msg);
%>
<form action="/day07/servlet/doLogin" method="post">
    用户名：<input type="text" name="userName"/><br/>
    密 码：<input type="password" name="pwd"/><br/>
    <input type="submit" value="登录"/><br/>
</form>

</body>
</html>
