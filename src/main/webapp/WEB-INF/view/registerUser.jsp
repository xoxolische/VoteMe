<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<html>
<head>
<title>Registration</title>
</head>
<body>
	
	<h3>This is User Registration page for common user (no role choose)</h3>
	<input type="text" id="email" placeholder="email">
	<input type="text" id="nickName" placeholder="nickName">
	<input type="text" id="password" placeholder="password">
	
	<button onclick="createAction()">create</button>

	<script>
		function createAction() {
			var item = {
				"email" : $("#email").val(),
				"nickName" : $("#nickName").val(),
				"password" : $("#password").val()
			}
			$.ajax({
				url : '/VoteMe/api/user/register',
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
