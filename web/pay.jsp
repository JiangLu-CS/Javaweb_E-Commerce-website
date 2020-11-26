<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
    html body{background-image: url("img/bg.jpg");}
</style>
<head>
    <base href="<%=basePath%>">

    <title>结账页面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" href="css/2.css" type="text/css"></link>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/2.js"></script>
</head>

<body>
<div id="container">
    <div id="top"></div>

    <div id="centry">
        <form action="UserServlets?opr=pay" method="post">
            <div id="log">
                <h3>结算</h3>
                <div id="div1">
                    <input type="text" name="card" class="input" placeholder="银行卡号" />
                </div>
                <div id="userMes"></div>
                <div class="div" id="div2">
                    <input type="password" name="psw" class="input" placeholder="卡密" />
                </div>
                <div class="div" id="div3">
                    <input type="text" name="mail" class="input" placeholder="邮箱" />
                </div>
                <div id="pswMes"></div>

                <div class="div"><input type="submit" value="支&nbsp;付"  id="input3" /></div>
            </div>
        </form>
    </div>

    <%@ include file="footer.jsp" %>



</body>
</html>
