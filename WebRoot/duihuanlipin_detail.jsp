<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>兑换礼品详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  兑换礼品详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>礼品编号：</td><td width='39%'>${duihuanlipin.lipinbianhao}</td>     <td width='11%'>礼品名称：</td><td width='39%'>${duihuanlipin.lipinmingcheng}</td></tr><tr>     <td width='11%'>所需积分：</td><td width='39%'>${duihuanlipin.suoxujifen}</td>     <td width='11%'>姓名：</td><td width='39%'>${duihuanlipin.xingming}</td></tr><tr>     <td width='11%'>手机号：</td><td width='39%'>${duihuanlipin.shoujihao}</td>     <td width='11%'>积分：</td><td width='39%'>${duihuanlipin.jifen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

