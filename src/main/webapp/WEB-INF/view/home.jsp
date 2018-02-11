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
				<div class="col-12 page-title">
					<h4 class="text-dark">Active votings</h4>
				</div>
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
	
		<div class="container" id="versus-list">

			<div class="row bg-dark text-light flex-wrap flex-column list-item">

				<div class="row" style="height: 100px;">
					<div
						class="col-6 col-sm-6 col-md-1 col-lg-1 col-xl-1
						d-flex justify-content-center align-items-center rating-counter-wrap">
						<label class="rating-counter">mark</label>
					</div>

					<div 
						class="col-6 col-sm-6 col-md-1 col-lg-1 col-xl-1 
						d-flex align-items-center justify-content-center">
						<div class="arrow">
							<img 
								class="arrow-up"
								src="<c:url value='/resources/images/arrow_up.png'/>"> 
							<img
								class="arrow-down"
								src="<c:url value="/resources/images/arrow_down.png"/>">
						</div>
					</div>

					<div class="col-12 col-sm-12 col-md-10 col-lg-10 col-xl-10">
						<div>
							<h5 class="versus-title" id="${versus.id}">Title</h5>
						</div>
						<div class="versus-description">Description</div>
					</div>

					<!--
					<div class="col-2 versus-author-wrap">
						<div class="versus-author">
							<h5>Author</h5>
							<p class="author-nickname">nickname</p>
						</div>
					</div>
					-->
				</div>

				<div class="dropdown-divider"></div>

				<div class="row" style="padding: 10px;">
					<div class="col-6 d-flex justify-content-center">
						
						<a href="#">
							<div class="d-flex flex-column flex-sm-column flex-md-row">
								<i class="far fa-comments fa-2x"></i>
								<p>&nbspComments(<span>999</span>)</p>
							</div>
						</a>
					</div>

					<div class="col-6 d-flex justify-content-center versus-author-wrap">
						<div 
							class="d-flex flex-column flex-sm-column 
							flex-md-row versus-author">
							<h5>Author:&nbsp</h5>
							<p class="author-nickname">nickname</p>
						</div>
					</div>

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

