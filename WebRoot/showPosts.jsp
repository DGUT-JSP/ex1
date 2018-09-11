<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>UserList</title>
    <style>
	 


	</style>
 
 
 </head>
  
  
  
  <body>
  ${msg }
 
  	 	<table border="1">
    <tr>
    	<td>头像</td>
        <td>发言</td>
        <td>发布时间</td>
        <td>操作</td>
    </tr>
   
	<%-- 同时遍历用户list和头像list --%>
	<c:forEach items="${postList }" var="s" varStatus="loop">
   	  <tr>
   	  
       		<td><img src="${pageContext.request.contextPath }/${iconList[loop.count-1] }" width=32 height=32></td>
            <td>${s.context }</td>
            <td>${s.dateIssued }</td>
            <td><a href="${pageContext.request.contextPath}/ShowReply?postId=${s.id}&pageNum=1">回复</a><a href="${pageContext.request.contextPath}/DeletePost?id=${s.id}">删除</a></td>
      </tr >
    
    </c:forEach>
    
  
	</table>
    <%-- 构建分页导航 --%>
            共有${requestScope.pageBean.totalRecord}个帖子，共${requestScope.pageBean.totalPage }页，当前为${requestScope.pageBean.pageNum}页
            <br/>
            <a href="${pageContext.request.contextPath}/ShowPost?pageNum=1">首页</a>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            
            <c:if test="${requestScope.pageBean.pageNum ==1}">
            
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>                
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/ShowPost?pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/ShowPost?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>                    
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNum > 1 && requestScope.pageBean.pageNum < requestScope.pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/ShowPost?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">    
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>            
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/ShowPost?pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/ShowPost?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>    
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${requestScope.pageBean.pageNum == requestScope.pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/ShowPost?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/ShowPost?pageNum=${i}">${i}</a>                                        
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
            <a href="${pageContext.request.contextPath}/ShowPost?pageNum=${requestScope.pageBean.totalPage}">尾页</a>
            
            <%-- 发帖 --%>
            <a href="${pageContext.request.contextPath }/user/addPost.jsp">我发帖</a>
            <a href="${pageContext.request.contextPath }/">主页</a>
  </body>
</html>
