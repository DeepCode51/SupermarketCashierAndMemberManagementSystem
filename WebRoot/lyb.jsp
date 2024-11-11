<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<!doctype html>
<html>
<head>
    <title>在线留言</title>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
 <div  class="in_about">
		    <div class="container">
			   <div class="in_toptt">
				   <h1>在线留言</h1>
				   <h4>开创独特的人类美好健康生活，从此开始</h4>
			   </div>
			   <div class="in_aboutcon clearfix">
			      
				  
				  
				  <form action="addLiuyanban.do" name="form1" method="post">
						<table width="97%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#78BAEF" style="border-collapse:collapse">
						 
                            <tr>
                              <td width="12%">昵称：</td>
                              <td width="88%"><input name='cheng' type='text' id='cheng' value='' onblur='checkform()' /> <label id='clabelcheng' />
                                *</td>
                            </tr>
                            <tr>
                              <td>头像：</td>
                              <td><input name="xingbie" type="radio" value="1" checked>
                                  <img src="img/1.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="2">
                                  <img src="img/2.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="3">
                                  <img src="img/3.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="4">
                                  <img src="img/4.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="5">
                                  <img src="img/5.gif" width="64" height="71"></td>
                            </tr>
                            <tr>
                              <td>QQ：</td>
                              <td><input name='QQ' type='text' id='QQ' value='' /></td>
                            </tr>
                            <tr>
                              <td>邮箱：</td>
                              <td><input name='youxiang' type='text' id='youxiang' value='' onblur='checkform()' /> <label id='clabelyouxiang' />必需邮箱格式</td>
                            </tr>
                            <tr>
                              <td>手机：</td>
                              <td><input name='shouji' type='text' id='shouji' value='' onblur='checkform()' /> <label id='clabelshouji' /> 必需手机格式</td>
                            </tr>
                            <tr>
                              <td>内容：</td>
                              <td><textarea name="neirong" cols="50" rows="10" id="neirong" onblur='checkform()'></textarea>
                                * <label id='clabelneirong' /> </td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td> <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
                                  <input type="reset" name="Submit22" value="重置"  /></td>
                            </tr>
                         
                   </table>
		        </form>
					  
						  
						  
						  
						  
			   </div>
		    </div>
        </div>
<jsp:include page="qtdown.jsp"></jsp:include>		
</body>
</html>
<script language=javascript >  
 
 function checkform(){  
 
	var chengobj = document.getElementById("cheng"); if(chengobj.value==""){document.getElementById("clabelcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入昵称</font>";return false;}else{document.getElementById("clabelcheng").innerHTML="  "; } 
	var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value!=""){ if(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(youxiangobj.value)){document.getElementById("clabelyouxiang").innerHTML=""; }else{document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>必需邮箱格式</font>"; return false;}}  
    var shoujiobj = document.getElementById("shouji"); if(shoujiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(shoujiobj.value)){document.getElementById("clabelshouji").innerHTML=""; }else{document.getElementById("clabelshouji").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}  
    var neirongobj = document.getElementById("neirong"); if(neirongobj.value==""){document.getElementById("clabelneirong").innerHTML="&nbsp;&nbsp;<font color=red>请输入内容</font>";return false;}else{document.getElementById("clabelneirong").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  