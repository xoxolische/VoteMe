<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>
<title>500</title>
</head>
<body>
	<div class="container-fluid main-wrap">
		<div class="row">
			<div class="col col-md-6 offset-md-3">
				<div class="card">
					<h5 class="card-header">Code: 500</h5>
					<div class="card-body">
						<h5 class="card-title">Something went wrong.</h5>
						<p class="card-text">Server got some error while trying to
							load your page. Please, try again. If you continue to receive an
							error message, report a bug.</p>
						<a href="${contextPath}/home" class="btn btn-outline-primary">Homepage</a>
						<a href="#" class="btn btn-outline-danger">Report a bug</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
