<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>

<title>VoteMe</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/userInfoPage.css"/>">

</head>
<body>
	<div class="container-fluid">
		<div class="container d-flex justify-content-center">

			<!--
			<div class="row">
				<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 
					mt-3 d-flex justify-content-center">
					<div class="d-flex flex-column">
						<div class="border rounded" style="height: 100px; width: 100px;"></div>
						<div>
							<button 
								class="btn btn-link" 
								data-toggle="modal"
								data-target="#changeAvatarModal"
								class="">
							Change avatar</button>
						</div>
					</div>
				</div>

				<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 d-flex justify-content-center
							justify-content-sm-center justify-content-md-start mt-0 mt-sm-0 mt-md-3">
					<div class="d-flex flex-column">
						<div>
							<label class="font-weight-bold">Nickname: </label>
							<label id="user-nickname">allah</label>
						</div>
						<div>
							<label class="font-weight-bold">E-mail: </label>
							<label id="user-email">soooka@voteme.com</label>
						</div>
						<div>
							<label class="font-weight-bold">Registered at: </label>
							<label id="registration-date">010101</label>
						</div>
						<div>
							<label class="font-weight-bold">Password: </label>
							<input id="user-password" type="password" readonly value="allah" size="auto">
							<span id="show-password-button"><i class="fas fa-eye"></i></span>
						</div>
						<div class="d-flex justify-content-center">
							<a href="#">Change password</a>
						</div>
						<div>
							<label class="font-weight-bold">Status: </label>
							<label id="user-status">unverified</label>
						</div>
						<div class="d-flex justify-content-center">
							<button class="btn btn-primary" id="verify-button" style="display: none;">Verify</button>
						</div>
					</div>
				</div>
			</div>
			-->

			<div class="col-1"></div>
			<div class="card-group mt-5 col-10">
				<div class="card col-md-3">
					<div class="card-img-top mt-1 d-flex justify-content-center">
						<span class="border border-dark"> <img
							class="user-avatar card-img-top"
							src="<c:url value="/resources/avatars/PIKA.jpg"/>">
						</span>
					</div>
					<div class="card-body d-flex justify-content-center">
					<button class="btn btn-block btn-outline-primary">Change
							Avatar</button>
						
					</div>
				</div>

				<div class="card">
					<div class="card-body">
						<h5 class="card-title d-flex justify-content-center">Nickname</h5>
						<div class="d-flex ">
							<label class="font-weight-bold">E-mail: </label> <label
								id="user-email">soooka@voteme.com</label>
						</div>
						<div>
							<label class="font-weight-bold">Registered at: </label> <label
								id="registration-date">010101</label>
						</div>
						<div>
							<label class="font-weight-bold">Password: </label> <input
								id="user-password" type="password" readonly value="allah"
								size="auto"> <span id="show-password-button"><i
								class="fas fa-eye"></i></span>
						</div>
						<div class="d-flex justify-content-center">
							<button class="btn btn-outline-primary col-md-12">Change
								Password</button>
						</div>
						<div>
							<label class="font-weight-bold">Status: </label> <label
								id="user-status">unverified</label>
						</div>
						<div class="d-flex justify-content-center">
							<button class="btn btn-outline-primary col-md-12"
								id="verify-button" style="display: none;">Verify</button>
						</div>

					</div>
				</div>
			</div>
			<div class="col-1"></div>
		</div>
	</div>

	<div class="modal fade" id="changeAvatarModal" tabindex="-1"
		role="dialog" aria-labelledby="changeAvatarModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header bg-dark">
					<h5 class="modal-title text-light" id="exampleModal3Label">Change
						avatar</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" class="text-light">&times;</span>
					</button>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-outline-secondary"
						data-dismiss="modal">Close</button>
					<button class="btn btn-outline-primary">Submit</button>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/userInfoPage.js"/>"></script>
</body>
</html>