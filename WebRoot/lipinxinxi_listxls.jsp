<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="lipinxinxihsgb" scope="page" class="com.bean.LipinxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=lipinxinxi.xls");
%>
<html>
  <head>
    <title>礼品信息</title>
  </head>

  <body >
 <%
			String sql="select * from lipinxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td  width='90' align='center' bgcolor='#ebf0f7'>礼品图片</td>    <td align='center' bgcolor='#ebf0f7'>礼品编号</td>    <td align='center' bgcolor='#ebf0f7'>礼品名称</td>    <td align='center' bgcolor='#ebf0f7'>所需积分</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=lipinxinxihsgb.getAllLipinxinxi(6);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.lipintupian}' target='_blank'><img src='${u.lipintupian}' width=88 height=99 border=0 /></a></td>    <td>${u.lipinbianhao}</td>    <td>${u.lipinmingcheng}</td>    <td>${u.suoxujifen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

