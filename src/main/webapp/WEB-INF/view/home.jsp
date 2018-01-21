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
			<div class="col-2">
				<h4 class="hs" style="margin-top: 10px;">Votes</h4>
			</div>
			<div class="col-10"></div>
		</div>


		<div class="container">

			<div class="row list-item">
				<div class="col-2">
					<label class="count">999</label>
					<img class="arrow-up" src="<c:url value="/resources/images/arrow_up.png"/>">
					<img class="arrow-down" src="<c:url value="/resources/images/arrow_down.png"/>">
				</div>
				<div class="col-8">
					<div class="desc-and-button">
						<div class="description"> 
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
							tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
							quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
							consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
							cillum dolore eu fugiat nulla pariatur.Lorem ipsum dolor sit amet, consectetur
							adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna 
							aliqua. Ut enim ad minim veniam.
						</div>	
						<button class="overflow-button">
							<img class="chevron" src="<c:url value="/resources/images/chevron.png"/>">
						</button> 
					</div>
				</div>
				<div class="col-2 author">
					Author:
					<br>
					<label>Kolya loh</label>
				</div>
			</div>

			<div class="row list-item">
				<div class="col-2">
					<label class="count">9999</label>
					<img class="arrow-up" src="<c:url value="/resources/images/arrow_up.png"/>">
					<img class="arrow-down" src="<c:url value="/resources/images/arrow_down.png"/>">
				</div>
				<div class="col-8">
					<div class="ofl">
						<div class="description">
							<p> 
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
								tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
								quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
								consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
								cillum dolore eu fugiat nulla pariatur.
							</p>
						</div>
						<button class="overflow-button">Read more</button>
					</div>
				</div>
				<div class="col-2 author">
					Author:
					<br>
					<label>Kolya pidor</label>
				</div>
			</div>

		</div>
	</div>
	

	<script type="text/javascript" src="<c:url value="/resources/scripts/home.js"/>"></script>
</body>
</html>