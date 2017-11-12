<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 上午12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%
    Date date = new Date();
    out.write(date.toLocaleString());
%>

<!-- 这是HTML注释，不安全，费流量 -->
<%-- 这是JSP注释,安全省流量 --%>
<%!
    int num1 = 10;

    public void show() {

    }
%>

<%
    int num2 = 10;
    num1++;
    num2++;
    out.print(num1 + 3);
    session.setAttribute("aa", "asfd");
%>

<%=num1 %>
<%=num2 %>

</body>
</html>
