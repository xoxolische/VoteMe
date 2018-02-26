<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/create_user.css"/>">
<title>Login</title>
</head>
<body>
	<div class="container-fluid main-wrap">
		<div class="row">
			<div class="card col col-8 offset-md-2">
				<div class="card-body">
					<form name='login' action="j_spring_security_check" method='POST'>
						<div class="form-group">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span
										class="input-group-text justify-content-center same-width"><i
										class="fa fa-envelope"></i></span>
								</div>
								<input id="email" type="text" class="form-control" name="email"
									placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span
										class="input-group-text justify-content-center same-width"><i
										class="fa fa-lock"></i></span>
								</div>
								<input id="password" type="password" class="form-control"
									name="password" placeholder="Password">
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty logout}">
							<div class="msg">${logout}</div>
						</c:if>
						<div class="form-group">
							<a href="${contextPath}/passwordReset">Forgot password?</a>
						</div>
						<div class="form-group">
							<button type="Submit" class="btn btn-outline-success col-12"
								name="Submit" value="Login" type="Submit">Log in</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>