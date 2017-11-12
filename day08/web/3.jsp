<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午6:16
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
    out.print(list.size());
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");

    request.setAttribute("list", list);

    Map map = new HashMap();
    map.put("a", "aaaaa");
    map.put("b", "bbbbbb");
    map.put("c", "ccccc");

    request.setAttribute("m", map);
%>

<br/>

${list[1] }<br/>

${m["b"] }<br/>
${m.c }

</body>
</html>
