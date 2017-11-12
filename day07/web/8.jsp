<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    /* String p = (String)pageContext.getAttribute("p");
    out.print(p); */
    //out.print(request.getAttribute("p"));
%>

<%--  <%=session.getAttribute("p") %>  --%>

<%--  <%=application.getAttribute("p") %> --%>

<%=pageContext.findAttribute("p") %>

</body>
</html>
