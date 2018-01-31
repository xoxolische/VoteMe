<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/header.css"/>">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css"
	integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"
	integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark page-nav">

	<a class="navbar-brand" href="/VoteMe/home" style="font-size: 20pt;">VoteMe</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<security:authorize access="hasAuthority('ADMIN') or hasAuthority('USER')">
				<li class="nav-item"><a href="/VoteMe/versus/create"
					class="nav-link">Create versus</a></li>
			</security:authorize>
			<li class="nav-item"><a href="#" class="nav-link">About</a></li>
			<security:authorize access="hasAuthority('ADMIN')">
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="#"/>">Test</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
			</security:authorize>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<security:authorize access="isAnonymous()">
				<li class="nav-item"><a href="${contextPath}/login"
					class="nav-link"><i class="fa fa-sign-in" aria-hidden="true"></i>
						Login</a></li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<li><a href="#" class="nav-link"><i
						class="fa fa-user-circle" aria-hidden="true"></i> Profile</a></li>
				<li><a class="nav-link" href="javascript:formSubmit()"><i
						class="fa fa-sign-out" aria-hidden="true"></i> Logout</a></li>
			</security:authorize>
		</ul>
	</div>

	<form action="${contextPath}/logout" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
</nav>