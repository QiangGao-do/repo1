<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<script type="text/javascript">
	function check_register(myform){
		if(myform.userID.value=="" || myform.uname.value==""
				   || myform.upassword.value==""|| myform.upassword2.value=="" ){
			 alert("登录ID、姓名、密码必须全部填写！");
			return false;
		}
		if(myform.upassword.value.length < 6 
				|| myform.upassword2.value.length < 6){
		   alert("您的密码长度小于6！");
		   return false;
		}
		if(myform.upassword.value.length > 10 
				|| myform.upassword2.value.length > 10){
		   alert("您的密码长度大于10！");
		   return false;
		}
	    if(myform.upassword.value != myform.upassword2.value){
		   alert("您两次输入的密码不一致！");
		   return false;
		}
		return true;
	}
</script>
</head>
<body>
<center>
  <h1>注册操作</h1>
  <hr>
  <form action="AM_add" method="post" onSubmit="return check_register(this)" >
  <table border="1">
      <tr>
        <td colspan="2" align="center">管理员注册</td>   
      </tr>
      <tr>
        <td align="right">用户id：</td>
        <td><input type="text" name="userID"></td>
      </tr>
      <tr>
        <td align="right">姓名：</td>
        <td><input type="text" name="uname"></td>
      </tr>      
              
       <tr>
        <td align="right">登录密码：</td>
        <td><input type="password" name="upassword"></td>
      </tr>
      
      <tr>
        <td align="right">确认密码：</td>
        <td><input type="password" name="upassword2"></td>
      </tr>
      <tr>
        <td colspan="2">
          &nbsp;&nbsp;<input type="submit" value="注册">&nbsp;&nbsp;
          <input type="reset" value="重置"> 
        </td>   
      </tr>
    </table>
  </form>
  <h5><a href="login.jsp">&nbsp;返回登录页面&nbsp;</a></h5>
</center>
</body>
</html>