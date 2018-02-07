<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<html>
<head>
<title>Registration</title>
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


					<button onclick="createAction()"
						class="btn btn-outline-success col-12">Register</button>
				</div>


			</div>
		</div>
	</div>

	<script>
		function createAction() {
			var item = {
				"email" : $("#userEmail").val(),
				"nickName" : $("#nickName").val(),
				"password" : $("#userPassword").val()
			}
			$.ajax({
				url : $('#path').val() + '/api/user/register',
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
