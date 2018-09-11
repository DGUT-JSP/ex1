<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
    
    <script type="text/javascript">
	function valName(){
	
		var pattern = new RegExp("^[a-z]([a-z0-9])*[-_]?([a-z0-9]+)$","i");//创建模式对象
		
		var str1=document.getElementById("name").value;//获取文本框的内容
		if(document.getElementById("name").value==null || document.getElementById("name").value==""){
			//document.getElementById("namespan").innerHTML="*不能为空";
			return false;
		}else
			return true;
	}
	
	function valPassword(){
		var str = document.getElementById("password").value;
		if(document.getElementById("password").value==null || document.getElementById("password").value==""){
			//document.getElementById("passwordspan").innerHTML="*不能为空";
			return false;
		}else
			return true;
	}
		
	function submit1(){
	
		result1=valName();
		result1=valPassword() && result1;		
		if( result1)
			return true;//提交
		else {
		alert("用户名或密码非法");
		return false;//阻止提交
		}
			
	}
	
</script>


         <style>
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}

.button1 {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
</style>
</head>
<body>
${msg }
	<form action="${pageContext.request.contextPath }/login" method="post" onsubmit="return submit1()">
		<table>
			<tr>
				<td>用户名：</td><td><input type="text" name="name" id="name"/></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;码：</td><td><input type="password" name="password" id="password"/></td>
			</tr>
		</table>
		<span id="namespan"></span>
		<span id="passwordspan"></span>
		<input type="submit" value="登录" class="button button2"/><br/>
	</form>
	没有用户名?点此<a href="${pageContext.request.contextPath }/regist.jsp">注册</a>
</body>
</html>