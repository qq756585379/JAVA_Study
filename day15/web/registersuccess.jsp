<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/12/10
  Time: 下午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <meta http-equiv="refresh" content="3;url=index.jsp">
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <script type="text/javascript" src="js/my.js"></script>
</head>

<body class="main" onload="startSecond()">

<%@include file="head.jsp" %>
<%@include file="menu_search.jsp" %>

<div id="divcontent">
    <table width="850px" border="0" cellspacing="0">
        <tr>
            <td style="padding:30px; text-align:center">
                <table width="60%" border="0" cellspacing="0" style="margin-top:70px">
                    <tr>
                        <td style="width:98px">
                            <img src="images/main/IconTexto_WebDev_009.jpg" width="128" height="128"/>
                        </td>
                        <td style="padding-top:30px">
                            <font style="font-weight:bold; color:#FF0000">注册成功,别忘记激活帐户啊</font><br/><br/>
                            <a href="index.jsp"><span id="second">3</span>秒后自动为您转跳回首页</a>
                        </td>
                    </tr>
                </table>
                <h1>&nbsp;</h1>
            </td>
        </tr>
    </table>
</div>

<div id="divfoot">
    <table width="100%" border="0" cellspacing="0">
        <tr>
            <td rowspan="2" style="width:10%">
                <img src="images/main/bottomlogo.gif" width="195" height="50" style="margin-left:175px"/>
            </td>
            <td style="padding-top:5px; padding-left:50px">
                <a href="#"><font color="#747556"><b>CONTACT US</b> </font> </a>
            </td>
        </tr>
        <tr>
            <td style="padding-left:50px">
                <font color="#CCCCCC"><b>COPYRIGHT 2008 &copy; eShop All Rights RESERVED.</b> </font>
            </td>
        </tr>
    </table>
</div>

</body>
</html>
