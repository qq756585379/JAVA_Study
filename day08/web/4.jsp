<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/12
  Time: 下午7:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String str1 = null;
    request.setAttribute("str1", str1);

    String str2 = "";
    request.setAttribute("str2", str2);

    String str3 = "abc";
    request.setAttribute("str3", str3);

    List list1 = new ArrayList();
    request.setAttribute("list1", list1);

    List list2 = new ArrayList();
    list2.add("asdf");
    request.setAttribute("list2", list2);

    int sex = 0;
    request.setAttribute("s", sex);
%>

${ empty str1 } ---- true<br/>
${ empty str2 } ---- true<br/>
${ empty str3 } ---- false <br/>
${ empty list1 } ---- true <br/>
${ empty list2 } ---- false<br/>

${ empty list2 ? "你还没有买商品":"你卖的商品如下" }

<input type="radio" name="sex" value="m" ${s==0 ? "checked='checked'":"" }/>男
<input type="radio" name="sex" value="f" ${s==1 ? "checked='checked'":"" }/>女<br/>

</body>
</html>
