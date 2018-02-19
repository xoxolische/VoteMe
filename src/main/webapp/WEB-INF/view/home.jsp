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

	<div class="container-fluid">

		<div class="container">
			<div class="row">
				<div class="col-12 page-title">
					<h4 class="text-dark">Active votings</h4>
				</div>
			</div>
		</div>

		<div class="container" id="versus-list">

			<!--  	<div class="row bg-dark text-light flex-wrap flex-column list-item">

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
							<img class="arrow-up"
								src="<c:url value='/resources/images/arrow_up.png'/>"> <img
								class="arrow-down"
								src="<c:url value="/resources/images/arrow_down.png"/>">
						</div>
					</div>

					<div class="col-12 col-sm-12 col-md-10 col-lg-10 col-xl-10">
						<div>
							<h5 class="versus-title">Title</h5>
						</div>
						<div class="versus-description">Description</div>
					</div>
				</div>

				<div class="dropdown-divider"></div>

				<div class="row" style="padding: 10px;">
					<div class="col-6 d-flex justify-content-center">

						<button
							class="btn btn-outline-light
							d-flex flex-column flex-sm-column flex-md-row
							justify-content-center align-items-center"
							type="button" data-toggle="collapse" data-target="#comment-block"
							aria-expanded="false" aria-controls="comment-block">
							<i class="far fa-comments fa-2x"></i> <span class="ml-md-3">999</span>
						</button>
					</div>

					<div class="col-6 d-flex justify-content-center versus-author-wrap">
						<div
							class="d-flex flex-column flex-sm-column 
							flex-md-row versus-author">
							<p>Author:&nbsp</p>
							<p class="author-nickname">nickname</p>
						</div>
					</div>
				</div>

				<div class="row collapse" id="comment-block" style="padding: 15px;">



					<div class="row">

						<div class="col-12">
							<div class="input-group">
								<div class="input-group-prepend">
									<span
										class="input-group-text d-flex 
										justify-content-center">
										<i class="far fa-comment"></i>
									</span>
								</div>
								<textarea id="user-comment"
									class="form-control enter-comment-fheight"
									aria-label="With textarea" placeholder="enter your comment"></textarea>
							</div>

							<button class="btn btn-outline-primary btn-block mt-2">Send</button>
						</div>
					</div>

					<div class="dropdown-divider"></div>

					<div class="row">
						<div class="col-12">
							<h6>
								Comments(<span>999</span>)
							</h6>
						</div>
					</div>

					<div class="row mt-3 d-flex flex-column">
						<div class="d-flex">
							<div
								class="col-3 col-sm-3 col-md-2 col-lg-1 col-xl-1 
								d-flex justify-content-end pr-0">
								<div
									class="d-flex justify-content-center align-items-center border rounded"
									style="height: 60px; width: 60px;">image</div>
							</div>
							<div
								class="col-9 col-sm-9 col-md-10 col-lg-11 col-xl-11 d-flex flex-column">
								<div
									class="d-flex justify-content-between flex-column flex-sm-row">

									<h6>Nickname</h6>

									<span>17.02.18 14:08</span>
								</div>
								<div class="d-flex">
									<p class="text-justify">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit, sed do eiusmod tempor incididunt
										ut labore et dolore magna aliqua. Ut enim ad minim veniam,
										quis nostrud exercitation ullamco laboris nisi ut aliquip ex
										ea commodo consequat. Duis aute irure dolor in reprehenderit
										in voluptate velit esse cillum dolore eu fugiat nulla
										pariatur. Excepteur sint occaecat cupidatat non proident, sunt
										in culpa qui officia deserunt mollit anim id est laborum.</p>
								</div>
							</div>
						</div>
						<div class="d-flex dropdown-divider mt-0"
							style="margin-left: 15px; margin-right: 15px;"></div>
					</div>


				</div>

			</div> -->
		</div>

	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
			<input type="hidden" id="lastDate" value="null">
				<button class="btn btn-success col-md-4 offset-md-4" onclick="loadMore()">More...</button>
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
		src="<c:url value="/resources/scripts/createComment.js"/>"></script>
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

