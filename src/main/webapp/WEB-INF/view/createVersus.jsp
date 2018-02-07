<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Versus</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/create_versus.css"/>">
</head>

<body>
	<div class="container-fluid">
		<div class="container">

			<div class="row">
				<div class="col-12">
					<div class="input-group mt-3 mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text d-flex justify-content-center"
								id="basic-addon1"> <i class="fas fa-edit"></i>
							</span>
						</div>
						<input type="text" class="form-control"
							placeholder="enter versus title" aria-label="Username"
							aria-describedby="basic-addon1">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-12 col-sm-12 col-md-5 col-lg-5 col-xl-5">
					<div class="input-group mt-3 mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text d-flex justify-content-center">
								<i class="fas fa-edit"></i>
							</span>
						</div>
						<textarea class="form-control fixed-height"
							aria-label="With textarea" placeholder="enter 1st opinion"></textarea>
					</div>
				</div>

				<div class="col-12 col-sm-12 col-md-2 col-lg-2 col-xl-2 d-flex justify-content-center">
					<div class="d-flex align-self-center">
						<h1 class="hs" style="margin: 0;">VS</h1>
					</div>
				</div>

				<div class="col-12 col-sm-12 col-md-5 col-lg-5 col-xl-5">
					<div class="input-group mt-3 mb-3">
						<textarea class="form-control fixed-height border-right-0"
							aria-label="With textarea" placeholder="enter 2nd opinion"></textarea>
						<div class="input-group-prepend">
							<span class="input-group-text d-flex justify-content-center rounded-right">
								<i class="fas fa-edit"></i>
							</span>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<div class="input-group mt-3 mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text d-flex justify-content-center">
								<i class="fas fa-edit"></i>
							</span>
						</div>
						<textarea class="form-control fixed-height"
							aria-label="With textarea" placeholder="enter some description"></textarea>
					</div>
				</div>
			</div>

			<div class="row">
				
				<div class="col-12">
					<button type="button" class="btn btn-outline-success btn-block" id="submit-button">submit</button>
				</div>
			
			</div>
		</div>
	</div>


	<script type="text/javascript">
		var curId = "${sessionScope.currentUserId}";
	</script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/create_versus.js"/>">
		
	</script>
</body>
</html>