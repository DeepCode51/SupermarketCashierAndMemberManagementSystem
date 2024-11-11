<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="goumaijiezhanghsgb" scope="page" class="com.bean.GoumaijiezhangBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=goumaijiezhang.xls");
%>
<html>
  <head>
    <title>购买结账</title>
  </head>

  <body >
 <%
			String sql="select * from goumaijiezhang  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>商品编号</td>    <td align='center' bgcolor='#ebf0f7'>商品名称</td>    <td align='center' bgcolor='#ebf0f7'>类别</td>    <td align='center' bgcolor='#ebf0f7'>价格</td>    <td align='center' bgcolor='#ebf0f7'>库存</td>    <td align='center' bgcolor='#ebf0f7'>购买数量</td>    <td align='center' bgcolor='#ebf0f7'>购买金额</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td align='center' bgcolor='#ebf0f7'>手机号</td>    <td align='center' bgcolor='#ebf0f7'>余额</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=goumaijiezhanghsgb.getAllGoumaijiezhang(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shangpinbianhao}</td>    <td>${u.shangpinmingcheng}</td>    <td>${u.leibie}</td>    <td>${u.jiage}</td>    <td>${u.kucun}</td>    <td>${u.goumaishuliang}</td>    <td>${u.goumaijine}</td>    <td>${u.xingming}</td>    <td>${u.shoujihao}</td>    <td>${u.yue}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

