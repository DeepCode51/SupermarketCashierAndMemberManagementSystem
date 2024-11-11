<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="code" scope="page" class="com.util.CheckCode" />
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>超市收银与会员管理</title>
<style type="text/css">
<!--
*{overflow:hidden; font-size:9pt;}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-repeat: repeat-x;
	background-color: #0CD762;
}
.STYLE5 {color: #FFFFFF;
	font-size: 26pt;
}
.STYLE8 {color: #FFFFFF}
.STYLE9 {color: #3366FF}
.STYLE10 {color: #3FD665}
-->
</style>
</head>
<script type="text/javascript">
	function hsgchecklogin() {
	if(document.f11.username.value=="" || document.f11.pwd.value=="" || document.f11.pagerandom.value=="")
	{
		alert("请输入完整");
		return false;
	}
	if (document.f11.pagerandom.value != document.f11.yzm.value) {
			alert("验证码错误！");
			document.f11.pagerandom.focus();
			return false;
	}
	
	}
	</script> 
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<p>&nbsp;</p>
<table width="64%" height="56" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="56" align="center"><div style="font-family:宋体; color:#FFFFFF; filter:Glow(Color=#000000,Strength=2); WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt">
      <div align="center" class="STYLE5 STYLE8">超市收银与会员管理</div>
    </div></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="1446" height="506" border="0" align="center" cellpadding="0" cellspacing="0" background="images/login.jpg" id="__01">
  <tr>
    <td height="46" colspan="3" valign="top" style="padding-bottom:20px;">
      <p>&nbsp;</p>    </td>
  </tr>
  <tr>
    <td width="1024" rowspan="3">&nbsp;</td>
    <td width="298" height="76"><table width="64%" height="56" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="56" align="center"><div style="font-family:宋体; color:#FFFFFF; filter:Glow(Color=#000000,Strength=2); WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt">
            <div align="left" class="STYLE5 STYLE10">用户登陆</div>
        </div></td>
      </tr>
    </table></td>
    <td width="124" rowspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="76"><table width="195" border="0" cellpadding="0" cellspacing="0">
       <form name="f11" method="post" action="hsgloginyanzheng.jsp">
        <tr>
          <td width="44" height="30"><span class="STYLE9">用 户:</span></td>
          <td height="30" colspan="2"><input name="username" type="text" id="username" style="width:100px; height:16px; border:solid 1px #000000; color:#666666"></td>
        </tr>
        <tr>
          <td height="30"><span class="STYLE9">密 码:</span></td>
          <td height="30" colspan="2"><input name="pwd" type="password" id="pwd" style="width:100px; height:16px; border:solid 1px #000000; color:#666666"></td>
        </tr>
        <tr>
          <td height="30"><span class="STYLE9">权 限:</span></td>
          <td height="30" colspan="2"><select name="cx" id="cx">
              <option value="管理员">管理员</option><option value="会员">会员</option>
            </select>
            </td>
        </tr>
        <tr>
          <td height="30"><span class="STYLE9">验证码:</span></td>
          <td width="61" height="30"><input name="pagerandom" type="text" id="pagerandom" style=" height:16px; border:solid 1px #000000; color:#666666; width:50px"></td>
          <td width="90"><%
								String yzm=code.getCheckCode();
								%>  <input type="hidden" name="yzm" value="<%=yzm %>" >
								   <%=yzm %></td>
        </tr>
        <tr>
          <td height="30" colspan="3"><input type="submit" name="Submit" value="登陆" onClick="return hsgchecklogin();">
              <input type="reset" name="Submit2" value="重置"></td>
        </tr>
      </form>
    </table></td>
  </tr>
  <tr>
    <td height="108">&nbsp;</td>
  </tr>
</table>
</body>
</html>