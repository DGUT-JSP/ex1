<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
</head>
<body>
	欢迎你：${user.name } <br>
	<a href="${pageContext.request.contextPath }/ShowPrivate?userId=${user.id}">我的信息</a>
	<a href="${pageContext.request.contextPath }/">主页</a>
	<a href="${pageContext.request.contextPath }/logout">注销</a>
</body>
</html>