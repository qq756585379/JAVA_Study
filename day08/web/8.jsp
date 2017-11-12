<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("eee");
    list.add("ffff");

    request.setAttribute("list", list);
%>

<table border="1">
    <tr>
        <th>数据</th>
        <th>索引</th>
        <th>计数</th>
        <th>第一个</th>
        <th>最后一个</th>
    </tr>

    <%--
    
    --%>
    <c:forEach items="${list }" var="l" varStatus="vs">
        <tr ${vs.count%2==1 ? "style='background-color:lime'" : "style='background-color:green'" }>
            <td>${l }</td>
            <td>${vs.index }</td>
            <td>${vs.count }</td>
            <td>${vs.first }</td>
            <td>${vs.last }</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
