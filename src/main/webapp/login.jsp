<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SSMS测试登录</title>
</head>
<body>
 <div>
  <div class="login_main">
    <form  action="<%=path%>/loginForSpringSecurity"  method="post">
      <div>用户名:</div>
      <div><input class="user_name" type="text" name="j_username" id="username" value=""  /></div>
      <div>密码:</div>
      <div><input class="user_pwd" type="password" name="j_password" id="password" /></div>
      <div style="margin-top:20px"><input type="submit" id="rptLogin" value="登录" /></div>
    </form>
  </div>
    
</div>
</body>
</html>

