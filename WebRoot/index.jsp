<%@ page language="java" import="java.util.*, com.dgut.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	String msg;
	String href;
	User user = (User)request.getSession().getAttribute("user");
	if(user != null){
		msg = user.getName();
		href = "/ShowPrivate?userId="+user.getId();
		
	}else {
		msg = "请登录";
		href = "/login.jsp";
	}
	
	request.setAttribute("msg", msg);
	request.setAttribute("href", href);
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <link href="style.css" rel="stylesheet" type="text/css"/>
     <link href="style1.css" rel="stylesheet" type="text/css"/>
    <title>home</title>
  </head>
  
  <body>
  你好，<a href="${pageContext.request.contextPath }/${href }">${msg }</a>
  ,<a href="${pageContext.request.contextPath }/logout">注销</a>
  <br>
  
  <ul class="f-main-list">
	
	<li class="f-main-item f-main-itemHover"> 
		<div class="fk-infoBlockWrap fk-infoBlockWrap-model">
			<div class="f-wrapBg"></div>
			<div class="fk-infoBlock f-infoBlock-fasico">
				<div class="f-bg"></div>
				<div class="f-infoIcon f-infoIcon-model"></div>
				<div class="f-infoWrap">
					<div class="f-info-title">匿名帖子</div>
					<div class="f-info-desc">畅所欲言</div>                                
					
					<a class="set_4_button2 raised hoverable f-button" href="${pageContext.request.contextPath }/ShowPost?pageNum=1">
					  <i class="anim"></i>
					  <span>立刻进入</span> 
					</a>        
				</div>
			</div>
			<div class="fk-infoBlock f-infoBlock-normal">
				<div class="f-bg"></div>
				<div class="f-infoWrap">
					<div class="f-info-title"></div>
					<div class="f-info-desc"></div>                                
				</div>
			</div>                    
		</div>
		<div class="f-infoBlock-name">
			查看帖子
		</div>
	</li>
	<li class="f-main-item f-main-itemHover"> 
		<div class="fk-infoBlockWrap fk-infoBlockWrap-site3to1">
			<div class="f-wrapBg"></div>
			<div class="fk-infoBlock f-infoBlock-fasico">
				<div class="f-bg"></div>
				<div class="f-infoIcon f-infoIcon-site3to1"></div>
				<div class="f-infoWrap">
					<div class="f-info-title">马上发帖</div>
					<div class="f-info-desc">PC、手机、微信网站三合一</div>                                
					
					<a class="set_4_button2 raised hoverable f-button" href="${pageContext.request.contextPath }/user/addPost.jsp">
					  <i class="anim"></i>
					  <span>立刻进入</span> 
					</a>        
				</div>
			</div>
			<div class="fk-infoBlock f-infoBlock-normal">
				<div class="f-bg"></div>
				<div class="f-infoWrap">
					<div class="f-info-title"></div>
					<div class="f-info-desc"></div>                                
				</div>
			</div>                    
		</div>
		<div class="f-infoBlock-name">
			发帖
		</div>
	</li>
	<li class="f-main-item f-main-itemHover"> 
		<div class="fk-infoBlockWrap fk-infoBlockWrap-easeMaintain">
			<div class="f-wrapBg"></div>
			<div class="fk-infoBlock f-infoBlock-fasico f-infoBlock-fasico-mulLine">
				<div class="f-bg"></div>
				<div class="f-infoIcon f-infoIcon-easeMaintain"></div>
				<div class="f-infoWrap">
					<div class="f-info-title">信息管理</div>
					<div class="f-info-desc">个人信息查看修改</div>                                
					
					<a class="set_4_button2 raised hoverable f-button" href="${pageContext.request.contextPath }/ShowPrivate?userId=${sessionScope.user.id }">
					  <i class="anim"></i>
					  <span>立刻进入</span> 
					</a>        
				</div>
			</div>
			<div class="fk-infoBlock f-infoBlock-normal">
				<div class="f-bg"></div>
				<div class="f-infoWrap">
					<div class="f-info-title"></div>
					<div class="f-info-desc"></div>                                
				</div>
			</div>                    
		</div>
		<div class="f-infoBlock-name">
			个人信息
		</div>
	</li>
	<li class="f-main-item  f-main-itemHover"> 
		<div class="fk-infoBlockWrap fk-infoBlockWrap-superSevice">
			<div class="f-wrapBg"></div>
			<div class="fk-infoBlock f-infoBlock-fasico f-infoBlock-fasico-mulLine">
				<div class="f-bg"></div>
				<div class="f-infoIcon f-infoIcon-superSevice"></div>
				<div class="f-infoWrap">
					<div class="f-info-title">用户列表</div>
					<div class="f-info-desc">用户增删改查</div>                                
					
					<a class="set_4_button2 raised hoverable f-button" href="${pageContext.request.contextPath }/FindAllWithPage?pageNum=1">
					  <i class="anim"></i>
					  <span>立刻进入</span> 
					</a>        
				</div>
			</div>
			<div class="fk-infoBlock f-infoBlock-normal">
				<div class="f-bg"></div>
				<div class="f-infoWrap">
					<div class="f-info-title"></div>
					<div class="f-info-desc"></div>                                
				</div>
			</div>                    
		</div>
		<div class="f-infoBlock-name">
			用户管理
		</div>
	</li>
</ul>
  <br>
  <%--
  <button class="button button1" onclick="javascript:window.location.href='${pageContext.request.contextPath }/ShowPrivate?userId=${sessionScope.user.id }';">个人信息</button>
  <button class="button button2" onclick="javascript:window.location.href='${pageContext.request.contextPath }/user/addPost.jsp';">发帖</button>
  <button class="button button3" onclick="javascript:window.location.href='${pageContext.request.contextPath }/ShowPost?pageNum=1';">看帖子</button>
  <button class="button button4" onclick="javascript:window.location.href='${pageContext.request.contextPath }/FindAllWithPage?pageNum=1';">用户管理</button>
   --%>
  
  </body>
</html>
