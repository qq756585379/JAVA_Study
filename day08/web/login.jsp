<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午7:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/success.jsp" method="post">
    用户名：<input type="text" name="userName"/><br/>
    密码：<input type="password" name="pwd"/><br/>
    <input type="submit" value="登录"/><br/>
</form>

</body>
</html>
