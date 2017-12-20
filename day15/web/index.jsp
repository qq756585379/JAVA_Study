<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/11/17
  Time: 下午10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%--导入css --%>
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
</head>
<body class="main">

<%@include file="head.jsp" %>
<%@include file="menu_search.jsp" %>

<div id="divad">
    <img src="images/ad/index_ad.jpg"/>
</div>

<div id="divcontent" style="margin-top: 20px">
    <table width="900px" border="0" cellspacing="0">
        <tr>
            <td width="497">
                <img src="images/main/billboard.gif" width="497" height="38"/>
                <table cellspacing="0" class="ctl">
                    <tr>
                        <td>
                            &middot;<a href="news.html" style="color:#000000">图书3折起，支持在线浏览
                            先看再买不后悔,任何商品免费送货</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            &middot;<a href="news.html" style="color:#000000">Lonely
                            Planet 已出版600多种旅行指南，几乎覆盖了全世界的每个角落。</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            &middot;<a href="news.html" style="color:#000000">2007年中旅游图书畅销榜速递
                            中国游,世界游,旅游图书全部7折封顶</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            &middot;<a href="news.html" style="color:#000000">50万种图书3折,百货团购价热卖
                            畅销榜新书速递,促销天天有</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            &middot;<a href="news.html" style="color:#000000">50万种图书3折,百货团购价热卖
                            畅销榜新书速递,促销天天有</a>
                        </td>
                    </tr>
                </table>
            </td>
            <td style="padding:5px 15px 10px 40px">
                <table width="100%" border="0" cellspacing="0">
                    <tr>
                        <td><img src="images/main/hottitle.gif" width="126" height="29"/></td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0">
                    <tr>
                        <td style="width:50px; text-align:center">
                            <a href="info.html">
                                <img src="images/bookcover/travelbook.jpg" width="102" height="130" border="0"/>
                            </a>
                            <br/>
                            <a href="info.html">
                                TravelBook<br/>
                                作者:Lonley Plant
                            </a>
                        </td>
                        <td style="width: 50px; text-align:center">
                            <a href="info.html">
                                <img src="images/bookcover/java2.jpg" width="102" height="130" border="0"/>
                            </a>
                            <br/>
                            <a href="info.html">Java2入门经典(JDK5) <br/> 作者:(美)霍顿</a>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>


<jsp:include page="foot.jsp"/>
</body>
</html>
