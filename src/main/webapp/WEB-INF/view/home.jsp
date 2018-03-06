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

		<div class="container" id="versus-list"></div>

	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<input type="hidden" id="lastDate" value="null">
				<button class="btn btn-success col-md-4 offset-md-4"
					onclick="loadMore()" id="more-button">More...</button>
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
	<input type="hidden" id="currentRole"
		value="${sessionScope.currentUserRole}" />
	<%@ include file="footer.jsp"%>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/createComment.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/home.js"/>"></script>
</body>
</html>

