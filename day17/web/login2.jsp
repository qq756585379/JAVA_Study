<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/24
  Time: 下午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/servlet/loginServlet2" method="get">
    username：<input type="text" name="username"/><br/>
    username：<input type="text" name="username1"/><br/>
    <input type="submit" value="登录"/><br/>
</form>

</body>
</html>
