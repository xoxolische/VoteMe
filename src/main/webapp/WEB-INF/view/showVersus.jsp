<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Versus page</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/show_versus.css"/>">
</head>
<body>

	<div class="container-fluid">

		<div class="container">

			<div class="row">
				<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
					<h4 class="page-titles">title</h4>
					<h5 id="versus-title">test versus</h5>
				</div>
				<div class="col-0 col-sm-0 col-md-6 col-lg-6 col-xl-6"></div>
			</div>

			<div class="row">

				<div
					class="col-12 col-sm-12 col-md-5 col-lg-5 col-xl-5
								d-flex flex-column justify-content-center 
								text-justify bg-dark text-light rounded"
					id="opinion-1">
					<h5>opinion 1</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse</p>

					<div class="d-flex justify-content-around">
						<img class="mark-up"
							src="<c:url value="/resources/images/arrow_up.png"/>"> <label
							class="mark-counter align-self-center">9999</label> <img
							class="mark-down"
							src="<c:url value="/resources/images/arrow_down.png"/>">
					</div>
				</div>

				<div
					class="col-12 col-sm-12 col-md-2 col-lg-2 col-xl-2
					d-flex justify-content-center align-items-center">
					<h4>VS</h4>
				</div>

				<div
					class="col-12 col-sm-12 col-md-5 col-lg-5 col-xl-5
								d-flex flex-column justify-content-center
								text-justify bg-dark text-light rounded"
					id="opinion-2">
					<h5>opinion 2</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse</p>

					<div class="d-flex justify-content-around">
						<img class="mark-up"
							src="<c:url value="/resources/images/arrow_up.png"/>"> <label
							class="mark-counter align-self-center">9999</label> <img
							class="mark-down"
							src="<c:url value="/resources/images/arrow_down.png"/>">
					</div>
				</div>
			</div>

			<div class="row description-author-block">
				<div
					class="col-12 d-flex flex-column justify-content-center
								text-justify bg-dark text-light rounded">
					<h5>description</h5>
					<p id="description">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit, sed do eiusmod tempor incididunt ut labore et
						dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
						exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate
						velit esse</p>
					<h5>author</h5>
					<p id="nick-name">nickname</p>
				</div>
			</div>
		</div>
	</div>

</body>
</html>