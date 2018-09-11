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
	<form action="${pageContext.request.contextPath }/AddPost" method="post">
		<table>
			<tr>
				<td>要说的话：</td><td><input type="text" name="context"/></td>
			</tr>
		</table>
		<input type="submit" value="提交"/><br/>
	</form>
	点此<a href="${pageContext.request.contextPath }/">返回</a>
</body>
</html>