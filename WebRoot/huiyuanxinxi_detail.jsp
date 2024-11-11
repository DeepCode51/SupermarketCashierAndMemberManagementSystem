<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>会员信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  会员信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>手机号：</td><td width='39%'>${huiyuanxinxi.shoujihao}</td><td  rowspan=7 align=center><a href=${huiyuanxinxi.zhaopian} target=_blank><img src=${huiyuanxinxi.zhaopian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>密码：</td><td width='39%'>${huiyuanxinxi.mima}</td></tr><tr><td width='11%' height=44>姓名：</td><td width='39%'>${huiyuanxinxi.xingming}</td></tr><tr><td width='11%' height=44>性别：</td><td width='39%'>${huiyuanxinxi.xingbie}</td></tr><tr><td width='11%' height=44>身份证：</td><td width='39%'>${huiyuanxinxi.shenfenzheng}</td></tr><tr><td width='11%' height=44>积分：</td><td width='39%'>${huiyuanxinxi.jifen}</td></tr><tr><td width='11%' height=44>余额：</td><td width='39%'>${huiyuanxinxi.yue}</td></tr><tr><td width='11%' height=100  >备注：</td><td width='39%' colspan=2 height=100 >${huiyuanxinxi.beizhu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

