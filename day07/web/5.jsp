<%@ page import="com.itheima.entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>

<%
    Student stu = new Student();
    stu.setName("tom");
    out.print(stu.getName());
    //request.getRequestDispatcher("/7.jsp").forward(request, response);
%>

<jsp:useBean id="stu1" class="com.itheima.entity.Student"></jsp:useBean>
<jsp:setProperty property="name" name="stu1" value="jerry"/>
<jsp:getProperty property="name" name="stu1"/>

<!-- http://localhost:8080/day07/5.jsp?name=123 -->
<jsp:forward page="/6.jsp">
    <jsp:param value="杨俊" name="name"/>
    <jsp:param value="333" name="pwd"/>
</jsp:forward>

</body>
</html>
