<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>
<title>Create User</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/create_user.css"/>">
</head>
<body>
	<div class="container-fluid main-wrap">
		<div class="card col col-md-6 offset-md-3">
			<div class="card-block">

				<div class="form-group">
					<h4 class="page-title">Registration</h4>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text justify-content-center same-width"><i
								class="fa fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="Nick Name"
							id="nickName">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text justify-content-center same-width"><i
								class="fa fa-lock"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="Password"
							id="userPassword">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text justify-content-center same-width"><i
								class="fa fa-envelope"></i></span>

						</div>
						<input type="email" class="form-control" placeholder="Email"
							id="userEmail">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text justify-content-center same-width"><i
								class="fa fa-cogs"></i></span>
						</div>
						<select class="custom-select" id="roleSelect">
							<c:forEach items="${roles}" var="role">
								<option value="${role.id}">${role.name}</option>
							</c:forEach>
						</select>

					</div>

					<button onclick="createAction()"
						class="btn btn-outline-success col-12">create</button>
				</div>


			</div>
		</div>
	</div>


	<%@ include file="footer.jsp"%>
	<script>
		function createAction() {
			var item = {
				"email" : $("#userEmail").val(),
				"nickName" : $("#nickName").val(),
				"password" : $("#userPassword").val(),
				"role" : {
					"id" : $("#roleSelect").val()
				}
			}
			$.ajax({
				url : $('#path').val() + '/api/user/create',
				type : 'POST',
				data : JSON.stringify(item),
				contentType : "application/json",
				dataType : 'json'
			}).done(function(data) {
				console.log("good");
				console.log(data);
			}).fail(function(data) {
				console.log(data.responseText);
			});
		}
	</script>
</body>
</html>
