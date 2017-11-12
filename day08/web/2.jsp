<%@ page import="com.itheima.entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午6:16
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
    Student stu = (Student) request.getAttribute("s");
    out.print(stu);
    out.print(stu.getName());
%>

<%--
EL表达式，简化jsp
${s}==pageContext.findAttribute("s")
--%>
${s}
${s.city.address }

</body>
</html>
