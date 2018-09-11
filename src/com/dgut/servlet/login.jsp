<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
${msg }
	<form action="${pageContext.request.contextPath }/login" method="post">
		<table>
			<tr>
				<td>用户名：</td><td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;码：</td><td><input type="password" name="password"/></td>
			</tr>
		</table>
		<input type="submit" value="登录"/><br/>
	</form>
	没有用户名?点此<a href="${pageContext.request.contextPath }/regist.jsp">注册</a>
</body>
</html>