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
    

  </head>
  
  
  
  <body>
  ${msg }
  <table border="1">
  <tr>
  	<td>
	re:${post.context }
  	</td>
  </tr>
  </table>
  <table border="1">
    <tr>
    	
        <td>发言</td>
        <td>发布时间</td>
        <td>操作</td>
    </tr>
   
	<%-- 同时遍历用户list和头像list --%>
	<c:forEach items="${replyList }" var="s" varStatus="loop">
   	  <tr>
   	  
       		
            <td>${s.context }</td>
            <td>${s.dateIssued }</td>
            <td><a href="${pageContext.request.contextPath}/DeleteReply?id=${s.id}">删除</a></td>
      </tr >
    
    </c:forEach>
    
  
	</table>
    <%-- 构建分页导航 --%>
            共有${requestScope.pageBean.totalRecord}个回复，共${requestScope.pageBean.totalPage }页，当前为${requestScope.pageBean.pageNum}页
            <br/>
            <a href="${pageContext.request.contextPath}/ShowReply?pageNum=1&postId=${post.id }">首页</a>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            
            <c:if test="${requestScope.pageBean.pageNum ==1}">
            
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>                
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/ShowReply?pageNum=${i}&postId=${post.id }">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/ShowReply?pageNum=${requestScope.pageBean.pageNum+1}&postId=${post.id }">下一页</a>                    
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNum > 1 && requestScope.pageBean.pageNum < requestScope.pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/ShowReply?pageNum=${requestScope.pageBean.pageNum-1}&postId=${post.id }">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">    
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>            
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/ShowReply?pageNum=${i}&postId=${post.id }">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/ShowReply?pageNum=${requestScope.pageBean.pageNum+1}&postId=${post.id }">下一页</a>    
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${requestScope.pageBean.pageNum == requestScope.pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/ShowReply?pageNum=${requestScope.pageBean.pageNum-1}&postId=${post.id }">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/ShowReply?pageNum=${i}&postId=${post.id }">${i}</a>                                        
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
            <a href="${pageContext.request.contextPath}/ShowReply?pageNum=${requestScope.pageBean.totalPage}&postId=${post.id }">尾页</a>
            <br/>
            <%--提交回复 --%>
            <form method='get' action='${pageContext.request.contextPath }/AddReply'>
            	发表回复<input type='text' name='context'>
            		<input type='hidden' name='postId' value='${post.id }'>
            			<input type='submit' value=提交>
            </form>
            <%-- 返回贴区 --%>
            <a href='${pageContext.request.contextPath}/ShowPost?pageNum=1'> 帖子列表</a>
            <a href="${pageContext.request.contextPath }/">主页</a>
              </body>

</html>
