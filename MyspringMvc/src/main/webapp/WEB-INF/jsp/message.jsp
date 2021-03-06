<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="header.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>留言板</title>
</head>

<body>
	<div class="layout-body">
		<div class="w960  clf">
			<div class="m1_main">
				<div class="inner">
					<div class="hd">
						<h3>${userInfo.username }的留言本</h3>
					</div>
					 <c:set var="messages" value="${message}" />
					 <c:set var="pager" value="${allmessages }" /> 
					<c:if test="${!empty messages }">
						<c:forEach items="${message}" var="message" varStatus="status">
							<div class="comm_content">
								<div class="c_list clf">
									<div class="c_hpic">
										<img src="headpic/${message.user.headpic }" alt="#"
											height="50" width="50">
									</div>
									<div class="c_fr">
										<p class="c_meta">
											<a href="#" target="_blank">${message.user.username }</a>
											<span class="c_time">${message.messagetime }</span>
											<!-- <span class="c_time"> #${totalmessages-(pager.pageSize)*(pager.pageNum-1)-status.index}</span> -->
											<span class="c_time">
												<c:if test="${user.userid==receiver.userid }">
											  	   <a href="<%=path %>/deleteMessage?messageid=${message.messageid}&receiveid=${receiver.userid }&currentPage=${pager.pageNum }" onclick="return operaconfirm('删除');">删除</a>
												</c:if>
											</span>
										</p>
										<div class="c_nr">${message.content }</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
				<div class="comm_content">
				   <c:if test="${!empty showMessageback }">
				   		<div class="c_list clf">
						   <div id="pl_page">
								<div class="pagelistbox">
									<span> 
									  ${showMessageback }
									</span>
								</div>
						   </div> 
					    </div>
				   </c:if>
				   <c:if test="${!empty messages }">
						<div class="c_list clf">
						   <div id="pl_page">
								<div class="pagelistbox">
									<span> 
										<c:if test="${pager.isFirstPage==false}">
										<a href="<%=request.getContextPath()%>/showMessages?receiveid=${receiver.userid }&currentPage=1">首页</a>
										</c:if> 
										<c:if test="${pager.hasPreviousPage==true}">
											<a href="<%=request.getContextPath()%>/showMessages?receiveid=${receiver.userid }&currentPage=${pager.pageNum-1}">上一页</a>
										</c:if> 
										<c:if test="${pager.hasNextPage==true}">
												<a href="<%=request.getContextPath()%>/showMessages?receiveid=${receiver.userid }&currentPage=${pager.pageNum+1}">下一页</a>
										</c:if> 
										<c:if test="${pager.isLastPage ==false}">
											<a href="<%=request.getContextPath()%>/showMessages?receiveid=${receiver.userid }&currentPage=${pager.pages}">尾页</a>
										</c:if> 
										当前第 ${pager.pageNum}页, 总共${pager.pages} 页
									</span>
								</div>
							</div> 
						</div>
					</c:if>
				</div>
				<br>
				<div class="inner">
					<div class="hd">
						<h3>留言</h3>
					</div>
					<div class="quote_f">
						<form action="<%=path %>/leaveMessage" method="post">
							<input name="senderid" value="${host.userid }" type="hidden">
							<input name="receiveid" value="${receiver.userid }" type="hidden">
							<textarea style="color: rgb(0, 0, 0);" cols="60" name="content"
								rows="5" id="msg"></textarea>
							<br> <input id="pltj" value="提&nbsp;交" class="anbu"
								type="submit">
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">Copyright By 小霍    版权所有</div>
	</div>
	<script type="text/javascript">
		function operaconfirm(opera) {
			question = confirm("你确认要"+opera+"么");
			if (question != "0") {
				return true;
			}
			return false;
		}
	</script>
</body>
</html>
