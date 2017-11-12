<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午7:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //pageContext.setAttribute("p", "pp");
    pageContext.setAttribute("p", "pp", PageContext.PAGE_SCOPE);

    //pageContext.setAttribute("p", "pp", PageContext.REQUEST_SCOPE);
    request.setAttribute("p", "request");

    //pageContext.setAttribute("p", "pp", PageContext.SESSION_SCOPE);
    session.setAttribute("p", "session");

    //pageContext.setAttribute("p", "pp", PageContext.APPLICATION_SCOPE);
    application.setAttribute("p", "application");
%>

${p }

</body>
</html>
