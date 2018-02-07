<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/create_user.css"/>">
<title>404</title>
</head>
<body>
	<div class="container-fluid main-wrap">
		<div class="row">
		<div class="col col-md-6 offset-md-3">
			<div class="card">
				<h1 class="card-header">Code: 404</h1>
				<div class="card-body">
					<h5 class="card-title">Page not found.</h5>
					<p class="card-text">Page you are looking for does not exists.</p>
					<a href="${contextPath}/home" class="btn btn-outline-primary">Homepage</a>
				</div>
			</div>
		</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
