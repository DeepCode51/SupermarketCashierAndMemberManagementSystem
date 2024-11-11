<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>礼品信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  礼品信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td  rowspan=3 align=center><a href=${lipinxinxi.lipintupian} target=_blank><img src=${lipinxinxi.lipintupian} width=228 height=215 border=0></a></td><td width='11%' height=44>礼品编号：</td><td width='39%'>${lipinxinxi.lipinbianhao}</td></tr><tr><td width='11%' height=44>礼品名称：</td><td width='39%'>${lipinxinxi.lipinmingcheng}</td></tr><tr><td width='11%' height=44>所需积分：</td><td width='39%'>${lipinxinxi.suoxujifen}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

