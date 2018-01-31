<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<html>
<head>
<title>Create User</title>
</head>
<body>
	
	<h3>This is User Creation page for admin (can choose role)</h3>
	<input type="text" id="email" placeholder="email">
	<input type="text" id="nickName" placeholder="nickName">
	<input type="text" id="password" placeholder="password">
	<select id="roleSelect">
		<c:forEach items="${roles}" var="role">
			<option value="${role.id}">${role.name}</option>
		</c:forEach>
	</select>
	<button onclick="createAction()">create</button>

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
