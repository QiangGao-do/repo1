 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>会议室管理系统登录页面</title>
</head>
<body>
<form action="login" method="post">
<center>
<table border="1">
   <tr>
   <td colspan="2" align="center">会议室管理系统登录</td>   
   </tr>
   <tr>
   <td>用户号:</td>
   <td><input type="text" name="username" value=""></td>
   </tr>
   <tr>  
   <td>密码:</td>
   <td><input type="password" name="password" value=""></td>
   </tr>
   <tr> 
    <td>类型:</td>
    <td><select name=type>
   <option value="1">管理员</option>
   <option value="0">用户</option>
   </select></td>
   </tr>  
   <tr>
   <td colspan="2">
   &nbsp;&nbsp;&nbsp;<input type="submit" value="登录">&nbsp;&nbsp;
      <input type="reset" value="重置"> 
   </td>   
   </tr>
  </table>
   <h5><a href="register.jsp">&nbsp;管理员注册&nbsp;</a></h5>
  </center>
</form>
</body>
</html>