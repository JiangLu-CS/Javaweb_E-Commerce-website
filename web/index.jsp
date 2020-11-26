<%--
  Created by IntelliJ IDEA.
  User: Lu
  Date: 2020/10/27
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
  <base href="<%=basePath%>">

  <title>商城首页</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  <script type="text/javascript" src="js/1.js"></script>
  <link rel="stylesheet" href="css/1.css" type="text/css"></link>
</head>

<body>
<%@ include file="header.jsp" %>
<div id="containter">
  <div id="left">
    <div id="left1">
      <h3><a href="#">手机</a></h3>
      <span><a href="GoodServlets?opr=det&id=10103">iphone11</a> <a href="GoodServlets?opr=det&id=10101">iphone12</a> <a href="GoodServlets?opr=det&id=10102">iphonex<sup><img src="img/peiqi.jpg" /></sup></a></span>
    </div>
    <div>
      <h3><a href="#">手机</a></h3>
      <span><a href="GoodServlets?opr=det&id=10103">iphone</a> <a href="GoodServlets?opr=det&id=10103">华为</a></span>
    </div>
    <div>
      <h3><a href="#">电脑</a></h3>
      <span><a href="GoodServlets?opr=det&id=10109">macbook</a> <a href="GoodServlets?opr=det&id=10109">matebook</a> <a href="GoodServlets?opr=det&id=10109">lenovo</a></span>
    </div>
    <div>
      <h3><a href="#">化妆品<sup><img src="img/hot.gif" /></sup></a></h3>
      <span><a href="GoodServlets?opr=det&id=10105">迪奥口红</a> <a href="GoodServlets?opr=det&id=10106">mac粉底液</a> <a href="href="GoodServlets?opr=det&id=10105"">植村秀眉笔</a></span>
    </div>
    <div>
      <h3><a href="GoodServlets?opr=det&id=10101">宠物</a></h3>
      <span><a href="GoodServlets?opr=det&id=101010">猫</a> <a href="GoodServlets?opr=det&id=10103">狗</a> <a href="GoodServlets?opr=det&id=10103">香猪</a> <a href="GoodServlets?opr=det&id=10111">爬宠</a></span>
    </div>
    <div>
      <h3><a href="GoodServlets?opr=det&id=101010">音乐设备</a></h3>
      <span><a href="GoodServlets?opr=det&id=101010">吉他</a> <a href="GoodServlets?opr=det&id=101010">钢琴</a></span>
    </div>
  </div>
  <div class="right">
    <ul class="img">
      <li><a href="GoodServlets?opr=det&id=10101"><img src="img/gou2.jpg" alt=""/></a></li>
      <li><a href="GoodServlets?opr=det&id=10102"><img src="img/gou1.jpg" alt="" /></a></li>
      <li><a hhref="GoodServlets?opr=det&id=10101"><img src="img/gou1.jpg" alt="" /></a></li>
      <li><a href="GoodServlets?opr=det&id=10102"><img src="img/gou2.jpg" alt="" /></a></li>
    </ul>
    <ul class="num">
    </ul>
    <div class="btn btn_l">&lt;</div>
    <div class="btn btn_r">&gt;</div>
  </div>
  <div id="block1">
    <h3><a href="#">热门化妆品</a></h3>
    <ul>
        <li><a href="GoodServlets?opr=det&id=10107"><img src="img/眼影.jpg" alt=""/></a></li>
        <li><a href="GoodServlets?opr=det&id=10108"><img src="img/眼影1.jpg" alt="" /></a></li>
        <li><a href="GoodServlets?opr=det&id=10105"><img src="img/口红1.jpg" alt="" /></a></li>
        <li><a href="GoodServlets?opr=det&id=10106"><img src="img/口红2.jpg" alt="" /></a></li>
    </ul>
  </div>
  <div id="block2">
    <h3><a href="GoodServlets?opr=det&id=10103">热门宠物</a></h3>
    <ul>
        <li><a href="GoodServlets?opr=det&id=10111"><img src="img/she.jpg" alt=""/></a></li>
        <li><a href="GoodServlets?opr=det&id=10110"><img src="img/mao1.jpg" alt="" /></a></li>
        <li><a href="GoodServlets?opr=det&id=10103"><img src="img/手机1.jpg" alt="" /></a></li>
        <li><a href="GoodServlets?opr=det&id=10103"><img src="img/电脑1.jpg" alt="" /></a></li>
    </ul>

  </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
