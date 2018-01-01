<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2017/12/17
  Time: 上午12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css"/>
</head>

<body class="main">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>

<div id="divpagecontent">
    <table width="100%" border="0" cellspacing="0">
        <tr>
            <td>
                <div style="text-align:right; margin:5px 10px 5px 0">
                    <a href="#">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;
                    <a href="#">&nbsp;计算机</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;java编程思想
                </div>

                <table cellspacing="0" class="infocontent">
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath }/images/ad/page_ad.jpg" width="666"
                                 height="89"/>
                            <table width="100%%" border="0" cellspacing="0">
                                <tr>
                                    <td width="30%">
                                        <div class="divbookcover">
                                            <p>
                                                <img src="${pageContext.request.contextPath }/upload/${b.img_url}"
                                                     width="213"
                                                     height="269" border="0"/>
                                            </p>
                                        </div>
                                        <div style="text-align:center; margin-top:25px">
                                            <a href="${pageContext.request.contextPath }/servlet/addCartServlet?id=${b.id}">
                                                <img src="${pageContext.request.contextPath }/images/main/buybutton.gif"
                                                     border="0"/>
                                            </a>
                                        </div>
                                    </td>
                                    <td style="padding:20px 5px 5px 5px">
                                        <img src="${pageContext.request.contextPath }/images/main/miniicon3.gif"
                                             width="16" height="13"/>
                                        <font class="bookname">&nbsp;&nbsp;${b.name }</font>
                                        <hr/>
                                        售价：<font color="#FF0000">￥:${b.price }元</font>
                                        <hr/>
                                        类别：${b.category }
                                        <hr/>
                                        <p><b>内容简介：</b></p>
                                        ${b.description }
                                    </td>
                                </tr>
                            </table>
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
