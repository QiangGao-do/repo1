<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>修改密码页面</title>
<script type="text/javascript">
	function check_register(myform){
		if( myform.upassword.value=="" || myform.upassword2.value==""){
			 alert("密码必须填写！");
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
  <h1>修改密码</h1>
  <hr>
  <form action="gaipw" method="post" onSubmit="return check_register(this)">
    <table border="1">
      <tr>
        <td colspan="2" align="center">修改密码</td>   
      </tr>     
	     
      <tr>
        <td align="right">新密码：</td>
        <td><input type="password" name="upassword"></td>
      </tr>
      <tr>
        <td align="right">确认密码：</td>
        <td><input type="password" name="upassword2"></td>
      </tr>
      <tr>
        <td colspan="2">
          &nbsp;&nbsp;<input type="submit" value="确认">&nbsp;&nbsp;
          <input type="reset" value="重置"> 
        </td>   
      </tr>
    </table>
  </form>
  <h5><a href="yonghu.jsp">&nbsp;返回用户页面&nbsp;</a></h5>
  
</center>

</body>