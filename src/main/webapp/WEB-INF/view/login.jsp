<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<head>
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
							<button type="Submit" class="btn btn-outline-success col-12"
								name="Submit" value="Login" type="Submit">Log in</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(window).on("load", function() {
		$("#preloader").hide();
	});
</script>
</html>