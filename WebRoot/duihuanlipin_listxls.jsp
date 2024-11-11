<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="duihuanlipinhsgb" scope="page" class="com.bean.DuihuanlipinBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=duihuanlipin.xls");
%>
<html>
  <head>
    <title>兑换礼品</title>
  </head>

  <body >
 <%
			String sql="select * from duihuanlipin  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>礼品编号</td>    <td align='center' bgcolor='#ebf0f7'>礼品名称</td>    <td align='center' bgcolor='#ebf0f7'>所需积分</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>手机号</td>    <td align='center' bgcolor='#ebf0f7'>积分</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=duihuanlipinhsgb.getAllDuihuanlipin(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.lipinbianhao}</td>    <td>${u.lipinmingcheng}</td>    <td>${u.suoxujifen}</td>    <td>${u.xingming}</td>    <td>${u.shoujihao}</td>    <td>${u.jifen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

