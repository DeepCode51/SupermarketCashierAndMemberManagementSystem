 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
 <table width="80%"  border="0" align="center">
  <tr>
    <td width="11%">&nbsp;</td>
    <td width="89%"><div style=" float: left; margin-left: 10px; " class="dd">
					 <%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
							<a href="userlog.jsp" style="cursor:pointer;">登录</a>
							<a href="huiyuanxinxiadd.jsp" style="cursor:pointer;">注册</a>
							 <%}else{ %>
	    <%=request.getSession().getAttribute("username")%>,[ <%=request.getSession().getAttribute("cx")%>]&nbsp; <a href="logout.jsp" onclick="return confirm('确定要退出？')" >退出</a> | <a href="main.jsp" >后台</a>
	   <%} %>
						</div> </td>
  </tr>
</table>
<header class="header">
  <div class="container "> 
    <div class="logo-main fl">
      <table width="100%"  border="0">
  <tr>
    <td> <a class="logo left" href="index.do" title=""><img src="qtimages/images/logo.png" /></a></td>
    <td><div style="margin-top: 5pt; font-weight: bold; font-size: 19pt; filter: Glow(Color=#000000,Strength=2);
                  width: 100%; color:#545454; font-family: 宋体">
                  <div align="center" class="STYLE5">
                      超市收银与会员管理</div>
              </div>   </td>
  </tr>
</table>

    </div>
    <nav class="header-menu fr">
        <div>
						<ul id="" class="menu">
			  <li class="menu-item hover"><a href="index.do">网站首页<span>&nbsp;</span></a></li>
			  <li  class="menu-item "><a href="">新闻信息<span>&nbsp;</span></a>
				      <ul class="sub-menu"><li class="menu-item"><a href="xwtzList.do?lb=站内新闻">站内新闻</a></li> <li class="menu-item"><a href="xwtzList.do?lb=购物需知">购物需知</a></li> <li class="menu-item"><a href="xwtzList.do?lb=促销公告">促销公告</a></li> </ul>
				 </li>	<li  class="menu-item "><a href="">商品信息<span>&nbsp;</span></a>
				      <ul class="sub-menu"><li class="menu-item"><a href="spxxListtp.do">商品信息</a></li> </ul>
				 </li>			<li  class="menu-item "><a href="">礼品信息<span>&nbsp;</span></a>
				      <ul class="sub-menu"><li class="menu-item"><a href="lpxxList.do">礼品信息</a></li> </ul>
				 </li>		
			  		
			  								<li  class="menu-item "><a href="">系统概要<span>&nbsp;</span></a>
				      <ul class="sub-menu"><li class="menu-item"><a href="dx_detail.jsp?lb=联系方式">联系方式</a></li> <li class="menu-item"><a href="dx_detail.jsp?lb=系统简介">系统简介</a></li> <li class="menu-item"><a href="dx_detail.jsp?lb=关于我们">关于我们</a></li> </ul>
				 </li><!--yoxulixuyaxn--><li  class="menu-item "><a href="">在线留言<span>&nbsp;</span></a>
				      <ul class="sub-menu"><li class="menu-item"><a href="lyb.jsp">在线留言</a></li> <li class="menu-item"><a href="lybList.do">查看留言</a></li> </ul>
				 </li>			
				 <li class="menu-item "><a href="login.jsp">后台管理<span>&nbsp;</span></a></li>
			 </ul>
		</div>    
	</nav>
  </div>
</header>
<div class="clearfix"></div>
<script>
$(function(){
	var swiper = new Swiper('.swiper1', {
		pagination : '.pagination1',
		loop:true,
		grabCursor: true
	});	
	$('.arrow-left').click(function(e) {
        e.preventDefault()
		swiper.swipePrev()
    });
	$('.arrow-right').click(function(e) {
        e.preventDefault()
		swiper.swipeNext()
    });
    $('.pagination1 .swiper-pagination-switch').click(function(){
    	swiper.swipeTo($(this).index())
    })
});
</script>
<div class="fullwidthbanner-container">
	    <div class="b_shadow"></div>
		<div class="fullwidthbanner">
			<ul>
			<%
			int xxbhti=0;
			String sqlbht="select id, shouyetupian from xinwentongzhi where leibie='变幻图'  order by id desc limit 0,5";
			ResultSet RS_resultbht=connDbBean.executeQuery(sqlbht);
while(RS_resultbht.next())
{
	xxbhti++;
		%>
				<li>
					<img src="<%=RS_resultbht.getString("shouyetupian")%>" alt=""  height="450" width="1920"/>									
				</li>
				<%
		}
		%>
			</ul>
		</div>
</div>            
		