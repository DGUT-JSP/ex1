<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link href="style.css" rel="stylesheet" type="text/css"/>


<script type="text/javascript">
	function valName(){
	alart("ok");
		var pattern = new RegExp("^[a-z]([a-z0-9])*[-_]?([a-z0-9]+)$","i");//创建模式对象
		var str1=document.getElementById("name").value;//获取文本框的内容
		
		if(str1==null || str1==""){
			document.getElementById("namespan").innerHTML="*不能为空";
			return false;
		}else if(str1.length>=8 && pattern.test(str1)){//pattern.test() 模式如果匹配，会返回true，不匹配返回false
			document.getElementById("namespan").innerHTML="ok";
			return true;
		}else{
			document.getElementById("namespan").innerHTML="*用户名至少需要8个字符，以字母开头，以字母或数字结尾，可以有-和_";
			return false;
		}
	}
	
	function valPassword(){
	alart("ok");
		var str = document.getElementById("password").value;
		var pattern=/^(\w){6,20}$/;
		
		if(document.getElementById("password").value==null || document.getElementById("password").value==""){
			return false;
		}else if(str.match(pattern)==null){
			return false;
		}else{
			document.getElementById("passwordspan").innerHTML="ok";
			return true;
		}
	}
	
	function submit1(){
	alart("ok");
		result1=valName();
		result1=valPassword() && result1;
		if( result1){
		alart("ok");
		return false;}
			//return true;//提交
		else 
		alart("数据非法");
			return false;//阻止提交
	}
	
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/regist" method="post" onsubmit="return submit1()">
	${msg }
	<table>
		<tr>
			<td>用&nbsp;户&nbsp;名&nbsp;：</td><td><input type="text" name="name" id="name" value=""/><span id="namespan"></span></td>
		</tr>
		<tr>
			<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;：</td><td><input type="password" name="password" id="password"/><span id="passwordspan"></span></td>
		</tr>
		<tr>
			<td>类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型&nbsp;：</td><td>
			<select name="type">
			<option value="user">user</option>
			<option value="manager">manager</option>
			</select>
		</tr>

	</table>
		<input type="submit" value="注册"/><br/>
	</form>
</body>
</html>