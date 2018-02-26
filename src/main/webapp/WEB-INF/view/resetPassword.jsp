<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>
<%@ include file="footer.jsp"%>
<script type="text/javascript"
	src="<c:url value="/resources/scripts/resetPassword.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/create_user.css"/>">
<title>Reset Password</title>
</head>
<body>
	<div class="container-fluid main-wrap" id="main-container">
		<div class="row">
			<div class="col col-md-6 offset-md-3">
				<div class="alert alert-danger d-none" role="alert" id="resetError"></div>
				<div class="alert alert-success d-none" role="alert"
					id="resetSuccess"></div>
				<div class="card" id="resetForm">
					<div class="card-body">
						<h5 class="card-title">Fill this field with your email
							address to get a new password.</h5>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text d-flex justify-content-center">
									<i class="fas fa-envelope"></i>
								</span>
							</div>
							<input type="text" class="form-control" id="resetEmail"
								placeholder="Email">
						</div>

						<button class="btn btn-outline-primary col-12" onclick="reset()">Get
							new password!</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${not empty error}">
		<script type="text/javascript">
			errorPresent('${error}');
		</script>
	</c:if>
	<c:if test="${not empty success}">
		<script type="text/javascript">
			successPresent('${success}')
		</script>
	</c:if>
</body>
</html>
