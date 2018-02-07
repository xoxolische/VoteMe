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

		<div class="container" id="versus-container">

			<div class="row">
				<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
					<h4 class="page-titles">title</h4>
					<h5 id="versus-title"></h5>
				</div>
				<div class="col-0 col-sm-0 col-md-6 col-lg-6 col-xl-6"></div>
			</div>

			<div class="row">

				<div
					class="col-12 col-sm-12 col-md-5 col-lg-5 col-xl-5
								d-flex justify-content-center 
								text-justify bg-dark text-light rounded"
					id="opinion-1">
					
					<div class="d-flex align-self-start">
						<p id="opinion1"></p>
					</div>

					<div class="d-flex justify-content-around align-self-end">
						<label
							class="mark-counter" id="op1-mark"></label>

						<span id="rating-up-1">
							<i class="fa fa-thumbs-up fa-2x"></i>
						</span> 
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

					<p id="opinion2">fdsds sdffff fsddd fsdddddddddddddddddddddd
					fsdddddd ddddddd ddddddd ddddddddd dddddddd ddddddddddddddddd
				fsdddd dddddddd dddddddddddd dddddddddddddd dddddddd dddddddddd
			fsdddd ddddddddddd ddddddddddd dddddddddd ddddddd ddddddddd
		fsddd dddddddd dddddddddd ddddddd dddddd</p>

					<div class="d-flex justify-content-around">
							
						<label
							class="mark-counter" id="op2-mark">
						</label>

						<span id="rating-up-2">
							<i class="fa fa-thumbs-up fa-2x"></i>
						</span> 
					</div>
				</div>
			</div>

			<div class="row description-author-block">
				<div
					class="col-12 d-flex flex-column justify-content-center
								text-justify bg-dark text-light rounded">
					<h5>description</h5>
					<p id="description"></p>
					<h5>author</h5>
					<p id="nick-name"></p>
				</div>
			</div>
		</div>



		<div class="container">
			<div class="alert alert-warning" id="error-warning">
				<h4>Something went wrong</h4>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<c:url value="/resources/scripts/show_versus.js"/>"></script>

</body>
</html>
