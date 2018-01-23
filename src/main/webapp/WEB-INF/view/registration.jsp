<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<html>
<head>
<title>Registration</title>
</head>
<body>
	<h3>This is Registration page</h3>
	<input type="text" id="email">
	<input type="text" id="nickName">
	<input type="text" id="password">
	<select id="roleSelect">
		<c:forEach items="${roles}" var="role">
			<option value="${role.id}">${role.name}</option>
		</c:forEach>
	</select>
	<button onclick="createAction()">create</button>
	<button onclick="createVersus()">create v</button>

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

			}).fail(function(data) {

			});
		}
	</script>
	<script>
		function createVersus() {
			var item = {
				"title" : "title1",
				"description" : "desc1",
				"opinion1" : {
					"text" : "op text1",
					"author" : {
						"id" : 1
					}
				},
				"opinion2" : {
					"text" : "op text2",
					"author" : {
						"id" : 1
					}
				}
			}
			$.ajax({
				url : '/VoteMe/api/versus/create',
				type : 'POST',
				data : JSON.stringify(item),
				contentType : "application/json",
				dataType : 'json'
			}).done(function(data) {
				console.log("good");
			}).fail(function(data) {
				console.log("bad");
			});
		}
	</script>
</body>
</html>
