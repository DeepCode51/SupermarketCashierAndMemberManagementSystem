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
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	if(parseInt(document.form1.jifen.value)<parseInt(document.form1.suoxujifen.value)){alert("对不起，积分必需大于所需积分");return false;}	
}
function gow()
{
	document.location.href="duihuanlipinadd.jsp?id=<%=id%>";
}
</script>


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
<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addDuihuanlipin.do" name="form1" method="post">
						<tr ><td width="200">礼品编号：</td><td><input name='lipinbianhao' type='text' id='lipinbianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.lipinbianhao.value='<%=connDbBean.readzd("lipinxinxi","lipinbianhao","id",request.getParameter("id"))%>';document.form1.lipinbianhao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">礼品名称：</td><td><input name='lipinmingcheng' type='text' id='lipinmingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.lipinmingcheng.value='<%=connDbBean.readzd("lipinxinxi","lipinmingcheng","id",request.getParameter("id"))%>';document.form1.lipinmingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">所需积分：</td><td><input name='suoxujifen' type='text' id='suoxujifen' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.suoxujifen.value='<%=connDbBean.readzd("lipinxinxi","suoxujifen","id",request.getParameter("id"))%>';document.form1.suoxujifen.setAttribute("readOnly",'true');</script>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("huiyuanxinxi","xingming","shoujihao",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">手机号：</td><td><input name='shoujihao' type='text' id='shoujihao' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr><script language="javascript">document.form1.shoujihao.value='<%=connDbBean.readzd("huiyuanxinxi","shoujihao","shoujihao",(String)request.getSession().getAttribute("username"))%>';document.form1.shoujihao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">积分：</td><td><input name='jifen' type='text' id='jifen' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.jifen.value='<%=connDbBean.readzd("huiyuanxinxi","jifen","shoujihao",(String)request.getSession().getAttribute("username"))%>';document.form1.jifen.setAttribute("readOnly",'true');</script>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						</form>
					 </table>
			
			<script language="javascript">popheight = 450;</script>
					  
						  
						  
						  
						  
			   </div>
		    </div>
        </div>
<jsp:include page="qtdown.jsp"></jsp:include>		
  
</body> 
</html>
