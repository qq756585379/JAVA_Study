<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2018/1/7
  Time: 下午10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下订单成功</title>
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <script type="text/javascript" src="js/my.js"></script>
</head>

<body class="main" onload="startSecond();">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>

<div id="divcontent">
    <table width="850px" border="0" cellspacing="0">
        <tr>
            <td style="padding:30px; text-align:center">
                <table width="60%"
                       border="0" cellspacing="0" style="margin-top:70px">
                    <tr>
                        <td style="width:98px">
                            <img src="images/main/IconTexto_WebDev_009.jpg" width="128" height="128"/>
                        </td>
                        <td style="padding-top:30px">
                            <font style="font-weight:bold; color:#FF0000">订单生成成功</font><br/> <br/>
                            <a href="index.jsp"><span id="second">5</span>秒后自动为您转跳回首页</a>
                        </td>
                    </tr>
                </table>
                <h1>&nbsp;</h1>
            </td>
        </tr>
    </table>
</div>

<jsp:include page="foot.jsp"/>

</body>
</html>
