<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>My JSP 'info.jsp' starting page</title>
<link href="stract/img/css.css" rel="stylesheet"/>
<link href="stract/css/easyui.css" rel="stylesheet"/>
</head>
<body>
				<div class="inner">
					<div class="hd">
						<h3>基本资料
						<a href="<%=path%>/updateheadpic" target="iframepage" class="comfirm">修改</a>
						</h3>
					</div>
					<div class="infos">
					<img src="stract/headpic/${userInfo.headpic}" width="80" height="80"/><br>
					    QQ号码：${userInfo.qq}<br>
						昵称：${userInfo.username}<br> 
					 	性别：
						<c:if test="${userInfo.sex==1}">男</c:if>
						<c:if test="${userInfo.sex==0}">女</c:if>
						<br>  
						出生日期：${userInfo.birthday}<br>
						<c:if test="${!empty userInfo.hometown }">
							家乡住址：${userInfo.hometown}<br>
						</c:if>
						<c:if test="${empty userInfo.hometown }">
							家乡住址：未填写<br>
						</c:if>
						<c:if test="${!empty userInfo.nowaddress }">
							现在住址：${host.nowaddress}<br>
						</c:if>
						<c:if test="${empty userInfo.nowaddress }">
							现在住址：未填写<br>
						</c:if>
					 	婚姻状况：
						<c:if test="${userInfo.ismarry==1}">是</c:if>
						<c:if test="${userInfo.ismarry==0}">否</c:if>
						<c:if test="${userInfo.ismarry==-1}">保密</c:if> 
						<br>  
					</div>
				</div>
				<div class="inner">
					<div class="hd">
						<h3>登陆信息</h3>
					</div>
					<div class="infos">
					 	QQ状态：
						<c:if test="${userInfo.state==1}">正常</c:if>
						<c:if test="${userInfo.state==0}">冻结</c:if> 
						<br>  
						最近登录时间：${userInfo.lastvisit}<br>
					</div>
				</div>
				<c:if test="${not empty modify_suc }">
				<div class="inner">
					<div class="hd">
						<h3>修改状况</h3>
					</div>
					<div class="infos">
					 	${modify_suc }
					</div>
				</div>
				</c:if>
	<script type="text/javascript" src="stract/js/jquery.js"></script>	
		<script type="text/javascript" src="stract/js/jquery.easyui.min.js"></script>
		<script type="text/javascript">
		  $(function() {
			  $(".comfirm").linkbutton();
		  });
		</script>		
</body>
</html>
