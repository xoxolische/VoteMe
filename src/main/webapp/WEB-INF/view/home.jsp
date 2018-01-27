<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>VoteMe</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>">

</head>


<body class="main">

	<div class="container-fluid">

		<div class="container">
			<div class="row">
				<div class="col-2">
					<h4 class="page-title">Votings</h4>
				</div>
				<div class="col-10"></div>
			</div>
		</div>


		<div class="container" id="versus-list">
			
			<div class="row bg-dark text-light list-item">

				<div
					class="col-1 d-flex justify-content-end align-items-center rating-counter-wrap">
					<label class="rating-counter">9999</label>
				</div>

				<div class="col-1 d-flex align-items-center">
					<div>
						<img class="arrow-up"
							src="<c:url value="/resources/images/arrow_up.png"/>"> <img
							class="arrow-down"
							src="<c:url value="/resources/images/arrow_down.png"/>">
					</div>
				</div>

				<div class="col-8">
					<div>
						<h5 class="versus-title">title</h5>
					</div>
					<div class="versus-description">Lorem ipsum dolor sit amet,
						consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
						labore et dolore magna aliqua. Ut enim ad minim veniam</div>
				</div>

				<div class="col-2 versus-author-wrap">
					<div class="versus-author">
						<h5>author</h5>
						<p class="author-nickname">nickname</p>
					</div>
				</div>
			</div>

		</div>


	</div>


	<script type="text/javascript"
		src="<c:url value="/resources/scripts/home.js"/>"></script>
</body>
</html>

