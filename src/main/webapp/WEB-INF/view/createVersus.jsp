<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Create Versus</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/create_versus.css"/>">
</head>

<body>
	<div class="container-fluid">
		<div class="container-fluid">

			<div class="row">
				<div class="col-5"></div>
				<div class="col-2 d-flex justify-content-center">
					<input type="text" id="versus-tittle" class="text-input"
						placeholder="enter versus tittle">
				</div>
				<div class="col-5"></div>
			</div>

			<div class="row">
				<div class="col-5 d-flex flex-column">
					<div class="d-flex justify-content-center">
						<h5 class="picture-input-label hs">select first picture</h5>
					</div>

					<div class="d-flex justify-content-center">
						<input type="file" id="picture-1" class="picture-input">
					</div>

					<div class="d-flex justify-content-center">
						<textarea id="opinion-1" class="opinion-input"
							placeholder="your opinion"></textarea>
					</div>
				</div>

				<div class="col-2 d-flex justify-content-center align-items-center">
					<div>
						<h1 class="hs">VS</h1>
					</div>
				</div>

				<div class="col-5 d-flex flex-column">
					<div class="d-flex justify-content-center">
						<h5 class="picture-input-label hs">select second picture</h5>
					</div>

					<div class="d-flex justify-content-center">
						<input type="file" id="picture-2" class="picture-input">
					</div>

					<div class="d-flex justify-content-center">
						<textarea id="opinion-2" class="opinion-input"
							placeholder="your opinion"></textarea>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-3"></div>
				<div class="col-6">
					<textarea id="description" class="description-input"
						placeholder="enter some description"></textarea>
				</div>
				<div class="col-3"></div>
			</div>

			<div class="row">
				<div class="col-4"></div>
				<div class="col-4">
					<div class="d-flex justify-content-center">
						<button type="button" class="btn btn-success" id="submit-button">submit</button>
					</div>
				</div>
				<div class="col-4"></div>
			</div>

		</div>
		
		<button type="button" class="btn btn-success" onclick="deleteVersus()">delete</button>
	</div>
	<script type="text/javascript">
		var curId = <c:out value="${sessionScope.currentUserId}"/>;
	</script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/create_versus.js"/>">
		
	</script>
</body>
</html>