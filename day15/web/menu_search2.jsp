<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
<script type="text/javascript">

    //鼠标悬浮时，改变背景色
    function changeBackground_over(div){
        div.style.backgroundColor = "gray";
    }

    //鼠标离开时，恢复背景色
    function changeBackground_out(div){
        div.style.backgroundColor = "white";
    }

    //填充文本到搜索框
    function writeText(div){
        //得到搜索框
        var searchElement = document.getElementById("name");
        searchElement.value = div.innerHTML;//把div中的文本添加到搜索框中
        div.parentNode.style.display="none";//把context1的div隐藏
    }

    function fillNameValue(subDiv) {
        document.getElementById("name").value = subDiv.innerHTML;
        document.getElementById("content").style.display = "none";
    }

    function searchName() {
        //2.绑定回调函数
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

                var jsonObj = eval("(" + xmlhttp.responseText + ")");
                if (jsonObj.length > 0) {
                    document.getElementById("content").style.display = "block";
                    for (var i = 0; i < jsonObj.length; i++) {
                        div.innerHTML += "<div onclick='fillNameValue(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>"
                            + jsonObj[i] + "</div>"
                    }
                }
            }
        };
        //3.open
        xmlhttp.open("GET", "${pageContext.request.contextPath}/findProductName?name="
            + window.encodeURIComponent(nameValue, "utf-8")
            + "&time=" + new Date().getTime());
        //4.send
        xmlhttp.send(null);
    }

</script>

<div id="divmenu">
    <a href="${pageContext.request.contextPath}/showProductByPage?category=文学">文学</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=生活">生活</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=计算机">计算机</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=外语">外语</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=经营">经管</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=励志">励志</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=社科">社科</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=学术">学术</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=少儿">少儿</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=艺术">艺术</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=原版">原版</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=科技">科技</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=考试">考试</a>
    <a href="${pageContext.request.contextPath}/showProductByPage?category=生活百科">生活百科</a>
    <a href="${pageContext.request.contextPath}/showProductByPage" style="color:#FFFF00">全部商品目录</a>
</div>

<div id="divsearch">
    <form action="${pageContext.request.contextPath}/findProductBySearch" method="post">
        <table width="100%" border="0" cellspacing="0">
            <tr>
                <td style="text-align:right; padding-right:220px">
                    Search
                    <input type="text" name="name" class="inputtable" id="name" autocomplete="on"/>
                    <input type="image" src="images/main/serchbutton.gif" border="0" style="margin-bottom:-4px">
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="content" style="background-color:white;width:128px; text-align:left;
     margin-left:945px;color:black;float:left;margin-top: -20px;display: block">
    213
</div>

<div id="context1" style="display:block;border:1px solid red;background-color:white;
	width:128px;position:absolute;left:860px;top:135px;">
    2131
</div>