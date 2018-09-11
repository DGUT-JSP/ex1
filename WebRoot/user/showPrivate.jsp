<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>My JSP 'showPrivate.jsp' starting page</title>
     <style>
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '»';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
  </head>
  
  <body>
    <table border="1">
    <tr>
        <td>我的id</td>
        <td>用户名</td>
        <td>头像</td>
        <td>昵称</td>
        <td>用户类型</td>
        <td>个性签名</td>
        <td>性别</td>
        <td>注册时间</td>
        <td>操作</td>
    </tr>
    <tr>
    	<from action="${pageContext.request.contextPath }/UpdatePrivate" method="post">
    		<td>${userInformation.userId }<input type=hidden name=userId value="${userInformation.userId }"> </td>
    		<td>${userObj.name }</td>
    		<td><img src=${pageContext.request.contextPath }/${userInformation.headIconUrl } width=128 height=128></td>
    		<td><input type=text name=nickName value=${userInformation.nickName }></td>
    		<td>${userObj.type }</td>
    		<td><input type=text name=briefIntroduction value=${userInformation.briefIntroduction }></td>
    		<td><input type=text name=gender value=${userInformation.gender }></td>
    		<td><input type=text name=registerDate value=${userObj.registerDate }></td>
    		<td><input type=submit value = 更新 ><a href="${pageContext.request.contextPath }/upload.jsp">换头像</a></td>
    	</from>
    </tr>
    </table>
    
   <button class="button" style="vertical-align:middle" onclick="javascript:window.location.href='${pageContext.request.contextPath }/';"><span> 主页</span></button>
  </body>
</html>
