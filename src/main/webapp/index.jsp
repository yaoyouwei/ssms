<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath %>resources/libraries/ext_v2.2.1/resources/css/ext-all.css" /> 
<script type="text/javascript" src="<%=basePath%>resources/libraries/ext_v2.2.1/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=basePath%>resources/libraries/ext_v2.2.1/ext-all-debug.js"></script>
<script>var CTX = "<%=basePath%>";</script>
<script type="text/javascript" src="<%=basePath%>resources/eastfax/index.js"></script>

<title>index</title>
</head>
<body>
  <div id="grid-example"></div>
</body>
</html>


