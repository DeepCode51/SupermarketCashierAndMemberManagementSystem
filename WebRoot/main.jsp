<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="images/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="images/styles/Common.css" rel="stylesheet" />
    <link href="images/styles/Index.css" rel="stylesheet" />
</head>
<body>
    <div class="header">

        <img class="logo" src="images/logo.png" />
        <label class="logo-title">超市收银与会员管理</label>
        <ul class="inline">
            <li>
                <img src="images/32/client.png" />&nbsp;&nbsp;欢迎您,${sessionScope.username}[${sessionScope.cx}]
            </li>
            <li>
                <img src=" images/32/200.png" />&nbsp;&nbsp;<a href="logout.jsp" target="_parent" class="loginout">退出</a>
            </li>
        </ul>
    </div>
    <div class="nav">
        <ul class="breadcrumb">
            <li>
                <img src="images/32/5025_networking.png" />
            </li>
            <li><a href="#">首页</a> <span class="divider">>></span></li>
            <li class="active"></li>
        </ul>
    </div>
    <div class="container-fluid content">
        <div class="row-fluid">
            <div class="span2 content-left">
                <div class="accordion">
                    <div class="accordion-group">
					                        <%
if (request.getSession().getAttribute("cx").equals("超级管理员") || request.getSession().getAttribute("cx").equals("普通管理员")){%><jsp:include page="left_guanliyuan.jsp"></jsp:include><%}if (request.getSession().getAttribute("cx").equals("会员")){%><jsp:include page="left_huiyuan.jsp"></jsp:include><%}
%>
 						
                    </div>
                </div>
            </div>
            <div class="span10 content-right">
                <iframe src="sy.jsp" class="iframe" id="hsgmain" name="hsgmain"></iframe>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="foot"></div>
    <script src="images/scripts/jquery-1.9.1.min.js"></script>
    <script src="images/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="images/scripts/Index.js"></script>
	<div style="text-align:center;">
</div>
</body>
</html>