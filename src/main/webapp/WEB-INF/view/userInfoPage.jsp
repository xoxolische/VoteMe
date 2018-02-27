<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp"%>
<%@include file="header.jsp"%>

<title>VoteMe</title>

</head>
<body>
	<div class="container-fluid">
		<div class="container">
			<div class="row">
				<div class="col-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 
					mt-3 d-flex justify-content-center">
					<div class="d-flex flex-column">
						<div class="border rounded" style="height: 100px; width: 100px;"></div>
						<div>
							<a 
								data-toggle="modal"
								data-target="#changeAvatarModal"
								class="">
							Change avatar</a>
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
		</div>
	</div>

	<div class="modal fade" id="changeAvatarModal" tabindex="-1" role="dialog"
	aria-labelledby="changeAvatarModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header bg-dark">
					<h5 class="modal-title text-light" id="exampleModal3Label">Change avatar</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" class="text-light">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="modal-form" action="j_spring_security_check" method='POST'>

						

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-outline-secondary"
						data-dismiss="modal">Close</button>
					<button class="btn btn-outline-primary" value="Login"
						onclick="submitModalFrom()">Submit</button>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	<script type="text/javascript"
		src="<c:url value="/resources/scripts/userInfoPage.js"/>"></script>
</body>
</html>