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

<form action="${pageContext.request.contextPath }/servlet/regServlet" method="post">
    用户名：<input type="text" name="username" value="${uf.username }"/>${uf.msg.username }${error }<br/>
    密码：<input type="password" name="password"/>${uf.msg.password }<br/>
    确认密码：<input type="password" name="repassword"/>${uf.msg.repassword }<br/>
    油箱：<input type="text" name="email" value="${uf.email }"/>${uf.msg.email }<br/>
    生日：<input type="text" name="birthday" value="${uf.birthday }"/>${uf.msg.birthday }<br/>
    <input type="submit" value="注册"/><br/>
</form>

</body>
</html>
