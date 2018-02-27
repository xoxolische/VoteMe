<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>
<title>403</title>
</head>
<body>
	<div class="container-fluid main-wrap">
		<div class="row">
			<div class="col col-md-6 offset-md-3">
				<div class="card">
					<h5 class="card-header">Code: 403</h5>
					<div class="card-body">
						<h5 class="card-title">Access denied.</h5>
						<p class="card-text">Page you are looking for is forbidden for
							your account type.</p>
						<a href="${contextPath}/home" class="btn btn-outline-primary">Homepage</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
