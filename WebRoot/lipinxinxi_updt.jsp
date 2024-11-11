<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改礼品信息</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="lipinxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateLipinxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改礼品信息<input type="hidden" name="id" value="${lipinxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">礼品图片：</td><td><input name='lipintupian' type='text' id='lipintupian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('lipintupian')"/></div></td></tr>		<tr ><td width="200">礼品编号：</td><td><input name='lipinbianhao' type='text' id='lipinbianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">礼品名称：</td><td><input name='lipinmingcheng' type='text' id='lipinmingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabellipinmingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">所需积分：</td><td><input name='suoxujifen' type='text' id='suoxujifen' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabelsuoxujifen' style='margin-top:16px;' />必需数字型</td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.lipintupian.value='${lipinxinxi.lipintupian}';</script>	<script language="javascript">document.form1.lipinbianhao.value='${lipinxinxi.lipinbianhao}';</script>	<script language="javascript">document.form1.lipinmingcheng.value='${lipinxinxi.lipinmingcheng}';</script>	<script language="javascript">document.form1.suoxujifen.value='${lipinxinxi.suoxujifen}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var lipinmingchengobj = document.getElementById("lipinmingcheng"); if(lipinmingchengobj.value==""){document.getElementById("clabellipinmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入礼品名称</font>";return false;}else{document.getElementById("clabellipinmingcheng").innerHTML="  "; } 	    


return true;   
}   
popheight=450;
</script>  
