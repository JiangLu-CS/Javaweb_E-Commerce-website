<%--
  Created by IntelliJ IDEA.
  User: Lu
  Date: 2020/10/28
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="css/1.css" type="text/css"></link>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<script type="text/javascript" src="js/header.js"></script>
</head>

<body>
<c:if test="${empty username}">
    <script type="text/javascript">
        $(document).ready(function () {
            $("#span4").hide();

        });
    </script>
</c:if>
<c:if test="${!empty username}">
    <script type="text/javascript">
        $(document).ready(function () {
            $("#span3").hide();
        });

    </script>
</c:if>
<div style="width: 1349px">
    <div id="top">
        <span id="span1"><a href="#">商城</a>|<a href="#">蒋璐</a>|<a href="#">18网工</a>|<a href="#">欢迎来买</a></span><span id="span2"><span id="span3"><a href="login.jsp">登录</a> <a href="register.jsp">注册</a></span><span id="span4" >欢迎登录！${username}|<a href="UserServlets?opr=exit">退出</a></span>|<a href="CartServlet?opr=list">我的购物车</a></span>
    </div>
    <div id="banner"><img src="img/peiqi.jpg" />
        <form action="GoodsServlet?opr=fuzzy&from=user" method="post">
  <span>
  <input type="text" name="goods" id="input1" value="iPhone12手机"/>
  <input type="submit" value="搜索" id="input2" />
  </span>
        </form>
    </div>
    <div id="menu">
        <ul>
            <li><a href="#">首页</a></li>
            <li><a href="#">电子产品</a>
                <div class="div" id="div1">
                    <div><a href="GoodsServlet?opr=det&id=10101"><img src="img/手机1.jpg" /></a></div>
                    <div><a href="GoodsServlet?opr=det&id=10105"><img src="img/手机2.jpg" /></a></div>

                </div>
            </li>
            <li><a href="#">美妆产品</a>
                <div class="div" id="div2">
                    <div><a href="GoodsServlet?opr=det&id=10104"><img src="img/口红1.jpg" /></a></div>
                    <div><a href="#"><img src="img/口红2.jpg" /></a></div>
                </div>
            </li>
            <li><a href="#">生活用品</a>
                <div class="div" id="div3">
                    <div><a href="#"><img src="img/眼影.jpg" /></a></div>
                    <div><a href="#"><img src="img/眼影1.jpg" /></a></div>
                    <div><a href="#"><img src="img/眼影.jpg" /></a></div>
                    <div><a href="#"><img src="img/眼影1.jpg" /></a></div>
                    <div><a href="#"><img src="img/眼影.jpg" /></a></div>
                    <div><a href="#"><img src="img/眼影.jpg" /></a></div>
                </div>
            </li>
            <li><a href="#">欢迎</a></li>
            <li><a href="#">光临</a></li>
            <li><a href="#">服务</a></li>
        </ul>
    </div>
</div>
</body>
</html>

