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
    <title>Home</title>
</head>
<body>
<h1>欢迎来到本网站！</h1>
欢迎你：
<%
    /* String userName = request.getParameter("userName");
    out.print(userName); */
    String userName = (String) session.getAttribute("name");
    out.print(userName);
%>
</body>
</html>
