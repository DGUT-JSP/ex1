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
    
    <title>UserList</title>
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
  ${msg }
 
  	 	<table border="1">
    <tr>
    	<td>头像</td>
        <td>id</td>
        <td>姓名</td>
        <td>类型</td>
        
        <td>注册时间</td>
        <td>操作</td>
    </tr>
   
	<%-- 同时遍历用户list和头像list --%>
	<c:forEach items="${userList }" var="s" varStatus="loop">
   	  <tr>
   	  
       		<td><img src="${pageContext.request.contextPath }/${iconList[loop.count-1] }" width=32 height=32></td>
            <td>${s.id }</td>
            <td>${s.name }</td>
            <td>${s.type }</td>
            
            <td>${s.registerDate }</td>
            <td><a href="${pageContext.request.contextPath}/ShowPrivate?userId=${s.id}">查看详情</a><a href="${pageContext.request.contextPath}/DeleteUser?ids=${s.id}">删除</a></td>
      </tr >
    
    </c:forEach>
    
  
	</table>
    <%-- 构建分页导航 --%>
            共有${requestScope.pageBean.totalRecord}个用户，共${requestScope.pageBean.totalPage }页，当前为${requestScope.pageBean.pageNum}页
            <br/>
            <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=1">首页</a>
            <%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
            
            <c:if test="${requestScope.pageBean.pageNum ==1}">
            
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>                
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>                    
            </c:if>
            
            <%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
            <c:if test="${requestScope.pageBean.pageNum > 1 && requestScope.pageBean.pageNum < requestScope.pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">    
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>            
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${i}">${i}</a>                                        
                    </c:if>                        
                </c:forEach>
                <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.pageNum+1}">下一页</a>    
            </c:if>
            
            <%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
            <c:if test="${requestScope.pageBean.pageNum == requestScope.pageBean.totalPage}">
                <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.pageNum-1}">上一页</a>
                <c:forEach begin="${requestScope.pageBean.start}" end="${requestScope.pageBean.end}" step="1" var="i">
                    <c:if test="${requestScope.pageBean.pageNum == i}">
                        ${i}
                    </c:if>
                    <c:if test="${requestScope.pageBean.pageNum != i}">
                        <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${i}">${i}</a>                                        
                    </c:if>                
                </c:forEach>
            </c:if>
            <%--尾页 --%>
            <a href="${pageContext.request.contextPath}/FindAllWithPage?pageNum=${requestScope.pageBean.totalPage}">尾页</a>
            
            <a href="${pageContext.request.contextPath }/"><button class="button" style="vertical-align:middle"><span>主页 </span></button></a>
  </body>
</html>
