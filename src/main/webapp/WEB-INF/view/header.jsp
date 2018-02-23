<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/header.css"/>">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


<link rel="stylesheet"
	href="<c:url value="/resources/css/preloader.css"/>">


<nav class="navbar navbar-expand-lg navbar-dark bg-dark page-nav">

<a class="navbar-brand" href="${contextPath}/home"
	style="font-size: 20pt;">VoteMe</a>
<button class="navbar-toggler" type="button" data-toggle="collapse"
	data-target="#navbarSupportedContent"
	aria-controls="navbarSupportedContent" aria-expanded="false"
	aria-label="Toggle navigation" id="toggler">
	<span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
	<ul class="navbar-nav mr-auto">
		<security:authorize access="isAuthenticated()">
			<li class="nav-item"><a href="${contextPath}/versus/create"
				class="nav-link">Create versus</a></li>
		</security:authorize>

		<li class="nav-item"><a href="${contextPath}/about"
			class="nav-link">About</a></li>

		<security:authorize access="hasAuthority('ADMIN')">
			<li class="nav-item"><a class="nav-link"
				href="${contextPath}/users/create">Register User</a></li>
		</security:authorize>
	</ul>

	<ul class="navbar-nav">
		<security:authorize access="isAnonymous()">
			<li><a href="${contextPath}/register" class="nav-link"><i
					class="fa fa-user-plus" aria-hidden="false"></i> Register</a></li>
			<li class="nav-item"><a data-toggle="modal"
						data-target="#exampleModal3" class="nav-link"
						style="cursor: pointer;"><i class="fas fa-sign-in-alt"
							aria-hidden="false"></i> Login</a></li>
		</security:authorize>

		<security:authorize access="isAuthenticated()">
			<li><a href="#" class="nav-link"><i
					class="fa fa-user-circle" aria-hidden="false"></i> Profile</a></li>
			<li><a class="nav-link" href="javascript:formSubmit()"
				aria-hidden="false"> <i class="fas fa-sign-out-alt"></i> Logout
			</a></li>
		</security:authorize>

	</ul>
</div>

<input type="hidden" value="${contextPath}" id="path">
<form action="${contextPath}/logout" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script> </nav>


<div class="modal fade" id="exampleModal3" tabindex="-1" role="dialog"
	aria-labelledby="exampleModal3Label" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header bg-dark">
				<h5 class="modal-title text-light" id="exampleModal3Label">Log
					in</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true" class="text-light">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="modal-form" action="j_spring_security_check" method='POST'>

					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text d-flex justify-content-center"
								id="login-icon"> <i class="fas fa-at fa-1x"></i>
							</span>
						</div>
						<input type="text" class="form-control" name="email"
							placeholder="Email">
					</div>


					<div class="input-group mt-3">
						<div class="input-group-prepend">
							<span class="input-group-text d-flex justify-content-center"
								id="password-icon"> <i class="fas fa-unlock-alt fa-1x"></i>
							</span>
						</div>

						<input type="password" class="form-control" name="password"
							placeholder="Password">



					</div>

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty logout}">
						<div class="msg">${logout}</div>
					</c:if>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-outline-secondary"
					data-dismiss="modal">Close</button>
				<button class="btn btn-outline-primary" value="Login"
					onclick="submitModalFrom()">Log in</button>
			</div>
		</div>
	</div>
</div>