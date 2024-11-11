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
    <title>商品信息</title>

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
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
 <div  class="in_about">
		    <div class="container">
			   <div class="in_toptt">
				   <h1>商品信息</h1>
				   <h4>开创独特的人类美好健康生活，从此开始</h4>
			   </div>
			   <div class="in_aboutcon clearfix">
			      
				  
				  
				
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>商品编号：</td><td width='39%'>${shangpinxinxi.shangpinbianhao}</td><td  rowspan=5 align=center><a href=${shangpinxinxi.tupian} target=_blank><img src=${shangpinxinxi.tupian}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>商品名称：</td><td width='39%'>${shangpinxinxi.shangpinmingcheng}</td></tr><tr>         <td width='11%' height=44>类别：</td><td width='39%'>${shangpinxinxi.leibie}</td></tr><tr>         <td width='11%' height=44>价格：</td><td width='39%'>${shangpinxinxi.jiage}</td></tr><tr>         <td width='11%' height=44>库存：</td><td width='39%'>${shangpinxinxi.kucun}</td></tr><tr>                           <td width='11%' height=100  >备注：</td><td width='39%' colspan=2 height=100 >${shangpinxinxi.beizhu}</td></tr><tr>							 
                                <td colspan="3"><table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse" class="newsline">
                                  <tr>
                                    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
                                    <td width="471" bgcolor='#CCFFFF'>评价内容</td>
                                    <td width="88" bgcolor='#CCFFFF'>评分</td>
                                    <td width="88" bgcolor='#CCFFFF'>评论人</td>
                                    <td width="138" align="center" bgcolor="CCFFFF">评论时间</td>
                                  </tr>
								  <%@page import="com.util.db"%>
                                   <%
								   int pli=0;
    for(HashMap map:new db().getpinglun("shangpinxinxi",id)){
	pli=pli+1;
     %>
                                   <tr>
                                    <td width="30" align="center" bgcolor='#CCFF99'><%=pli%></td>
                                    <td width="471" bgcolor='#CCFF99'><%=map.get("pinglunneirong") %></td>
                                    <td width="88" bgcolor='#CCFF99'><%=map.get("pingfen") %></td>
                                    <td width="88" bgcolor='#CCFF99'><%=map.get("pinglunren") %></td>
                                    <td width="138" align="center" bgcolor="CCFF99"><%=map.get("addtime") %></td>
                                  </tr>
                                  <%
								 
								  }
								   %>
                                </table></td>
                                </tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回  class='hsgqiehuanshitu' onClick="javascript:history.back()" /><input type=button name=Submit52 value=打印 class='hsgqiehuanshitu' onClick="javascript:window.print()" /> <!--jixaaxnnxiu--><input type=button name=Submit53 value=评论 class='hsgqiehuanshitu' onClick="javascript:hsgpinglun('shangpinxinxi','<%=id%>')"/><input type=button name=Submit52 value=收藏 class='hsgqiehuanshitu' onClick="javascript:location.href='jrsc.jsp?id=<%=id%>&biaoj=spxx&biao=shangpinxinxi&ziduan=shangpinmingcheng';" /></td></tr>
    
  </table>
					  
						  
						  
						  
						  
			   </div>
		    </div>
        </div>
<jsp:include page="qtdown.jsp"></jsp:include>		
  
</body> 
</html>

