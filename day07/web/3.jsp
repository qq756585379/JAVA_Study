<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午5:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

动态包含,能用静态包含就不要用动态包含
<%--
<jsp:include page="4.jsp"></jsp:include>
--%>

静态包含
<%@ include file="4.jsp" %>

    <%
		if(5>3){
			out.print(5);
		}
	%>

<c:if test="${5>3 }">
aaaaaaaaaaaaa
</c:if>

