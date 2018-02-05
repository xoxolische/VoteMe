<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<html>
<head>
<title>Create User</title>
</head>
<body>
	<div class="container">
		<div class="card col col-md-6 offset-md-3">
			<div class="card-block">

				<div class="form-group">
					<h3>User Registration page</h3>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="Nick Name"
							id="nickName">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-lock"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="Password"
							id="password">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-envelope"></i></span>
						</div>
						<input type="email" class="form-control" placeholder="Email"
							id="email">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fa fa-cogs"></i></span>
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



	<script>
		function createAction() {
			var item = {
				"email" : $("#email").val(),
				"nickName" : $("#nickName").val(),
				"password" : $("#password").val(),
				"role" : {
					"id" : $("#roleSelect").val()
				}
			}
			$.ajax({
				url : '/VoteMe/api/user/create',
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
