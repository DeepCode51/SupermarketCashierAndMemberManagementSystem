<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!doctype html>
<html>
<head>
    <title>兑换礼品</title>

<meta name="viewport" id="viewport" content="initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<link href="qtimages/css/index.css" rel="stylesheet">
<link href="qtimages/css/responsive.css" rel="stylesheet">
<script type="text/javascript" src="qtimages/js/jquery-1.8.3.min.js"></script>
<script src="qtimages/js/common.js"></script>
<script src="qtimages/js/jquery.touchwipe.min.js"></script>
<script type="text/javascript" src="qtimages/js/jquery.banner.revolution.min.js"></script>
<script type="text/javascript" src="qtimages/js/banner.js"></script>
<script type="text/javascript" src="qtimages/js/swiper.scrollbar-1.2.js"></script>
<script type="text/javascript" src="qtimages/js/swiper-1.9.1.min.js"></script>
<script type="text/javascript" src="qtimages/js/jquery.fs.boxer.min.js"></script>
<script type="text/javascript" src="qtimages/js/jquery.slides.min.js"></script>
<script type="text/javascript" src="qtimages/js/customs.js"></script>
<script src="qtimages/js/jquery.isotope.min.js"></script>    
<script src="qtimages/js/custom.js"></script>  
<script src="qtimages/js/modernizr.custom.js"></script>
</head>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
 <div  class="in_about">
		    <div class="container">
			   <div class="in_toptt">
				   <h1>兑换礼品</h1>
				   <h4>开创独特的人类美好健康生活，从此开始</h4>
			   </div>
			   <div class="in_aboutcon clearfix">
			      
				  
				  
				<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">    
<form action="dhlpList.do" name="myform" method="post" style="width:100%">
									查询   礼品编号：<input name="lipinbianhao" type="text" id="lipinbianhao" class="form-control2" />  礼品名称：<input name="lipinmingcheng" type="text" id="lipinmingcheng" class="form-control2" />
									<input type="submit" value="查询" class='hsgqiehuanshitu' /> 
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td bgcolor='#ebf0f7' width='90' align='center'>礼品图片</td>    <td bgcolor='#ebf0f7'>礼品编号</td>    <td bgcolor='#ebf0f7'>礼品名称</td>    <td bgcolor='#ebf0f7'>所需积分</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td width='90'><a href='${u.lipintupian}' target='_blank'><img src='${u.lipintupian}' width=88 height=99 border=0 /></a></td>    <td>${u.lipinbianhao}</td>    <td>${u.lipinmingcheng}</td>    <td>${u.suoxujifen}</td>    
                              <td align="center"> ${u.addtime} </td>
                              <td align="center"><a class="btn btn-info btn-small" href="dhlpDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="dhlpList.do?page=1" >首页</a>
             <a href="dhlpList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="dhlpList.do?page=${page.page+1 }">下一页</a>
			<a href="dhlpList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




					  
						  
						  
						  
						  
			   </div>
		    </div>
        </div>
<jsp:include page="qtdown.jsp"></jsp:include>		
  
</body> 
</html>
