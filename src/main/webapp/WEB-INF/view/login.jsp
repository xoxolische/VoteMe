<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="wrapper col-md-4 col-md-offset-4 well">
			<form name='login' action="j_spring_security_check" method='POST'>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input id="email"
							type="text" class="form-control" name="email" placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input id="password"
							type="password" class="form-control" name="password"
							placeholder="Password">
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
					<button type="Submit" class="btn btn-primary btn-block"
						name="Submit" value="Login" type="Submit">Log in</button>
				</div>
			</form>
		</div>
	</div>
</div>