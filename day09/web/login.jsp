<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/13
  Time: 下午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${msg }

<form action="${pageContext.request.contextPath }/servlet/loginServlet" method="post">
    用户名：<input type="text" name="name"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/><br/>
</form>

</body>
</html>
