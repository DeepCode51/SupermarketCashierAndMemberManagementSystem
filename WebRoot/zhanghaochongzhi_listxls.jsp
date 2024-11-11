<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zhanghaochongzhihsgb" scope="page" class="com.bean.ZhanghaochongzhiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zhanghaochongzhi.xls");
%>
<html>
  <head>
    <title>账号充值</title>
  </head>

  <body >
 <%
			String sql="select * from zhanghaochongzhi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>手机号</td>    <td align='center' bgcolor='#ebf0f7'>余额</td>    <td align='center' bgcolor='#ebf0f7'>充值金额</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=zhanghaochongzhihsgb.getAllZhanghaochongzhi(6);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xingming}</td>    <td>${u.shoujihao}</td>    <td>${u.yue}</td>    <td>${u.chongzhijine}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

