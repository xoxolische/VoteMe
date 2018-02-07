<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>
<title>VoteMe</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/home.css"/>">
</head>
<body>
	<div class='loader loader2' id="preloader">
		<div>
			<div>
				<div>
					<div>
						<div>
							<div></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--
	<div class="site_wrap">
		<div class="parallax-viewport" id="parallax">

			<div class="parallax-layer mid-layer" >

			</div>
			<div class="parallax-layer fore-layer">
				
			</div>
		</div>
	</div>
-->

	<div class="container-fluid">

		<div class="container">
			<div class="row">
				<div class="col-2 page-title">
					<h4 class="text-light">Votings</h4>
				</div>
				<div class="col-10"></div>
			</div>
		</div>


		<!--
		<c:forEach items="${versuses}" var="versus">
			<div class="card">
				<div class="card-header">${versus.description}</div>
				<div class="card-block">
					<h4 class="card-title">${versus.description}</h4>
					<p class="card-text"></p>
					<c:forEach items="${versus.opinions}" var="opinion">
						<a href="#" class="btn btn-primary">${opinion.text}</a>
					</c:forEach>
				</div>
			</div>
		</c:forEach>



		<div class="container" id="versus-list" style="z-index: 2;">

			<c:forEach items="${versuses}" var="versus">
				<div class="row bg-dark text-light list-item">

					<div
						class="col-1 d-flex justify-content-end align-items-center rating-counter-wrap">
						<label class="rating-counter"></label>
					</div>

					<div class="col-1 d-flex align-items-center">
						<div class="arrow">
							<img class="arrow-up"
								src="<c:url value='/resources/images/arrow_up.png'/>"> <img
								class="arrow-down"
								src="<c:url value="/resources/images/arrow_down.png"/>">
						</div>
					</div>

					<div class="col-8">
						<div>
							<h5 class="versus-title" id="${versus.id}">${versus.title}</h5>
						</div>
						<div class="versus-description">${versus.description}</div>
					</div>

					<div class="col-2 versus-author-wrap">
						<div class="versus-author">
							<h5>author</h5>
							<p class="author-nickname">${versus.author.nickName}</p>
						</div>
					</div>
				</div>
			</c:forEach>

-->
		<div class="container" id="versus-list" style="z-index: 2;"></div>
		<div class="row text-light list-item">

			<div
				class="col-1 d-flex justify-content-end align-items-center rating-counter-wrap">
				<label class="rating-counter"></label>
			</div>

			<div class="col-1 d-flex align-items-center">
				<div class="arrows-wrap">
					<a onclick="check()"><img class="arrow-up"
						src="<c:url value='/resources/images/arrow_up.png'/>"></a> <img
						class="arrow-down"
						src="<c:url value="/resources/images/arrow_down.png"/>">
				</div>
			</div>

			<div class="col-8" style="z-index: 2;">
				<div class="versus-title-wrap">
					<h5 class="versus-title text-light" id="${versus.id}">1
						${versus.title}</h5>
				</div>
				<div class="versus-description">13323123 ${versus.description}</div>
			</div>

			<div class="col-2 versus-author-wrap">
				<div class="versus-author">
					<h5>author</h5>
					<p class="author-nickname">111 ${versus.author.nickName}</p>
				</div>
			</div>

		</div>

	</div>
	<div class="container">
		<div class="alert alert-info empty-list-alert" role="alert">
			<h4>Nothing to show :c</h4>
		</div>
	</div>
	<input type="hidden" id="currentId"
		value="${sessionScope.currentUserId}" />

	<%@ include file="footer.jsp"%>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/home.js"/>"></script>
	<script src="resources/scripts/jquery.parallax.js"></script>
	<script>
		jQuery(document).ready(function() {
			jQuery('#parallax .parallax-layer').parallax({
				mouseport : jQuery('#parallax')
			});
		});
	</script>
</body>
</html>

