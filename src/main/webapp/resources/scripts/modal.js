//$(document).ready(function() {
//	$("#modal-message").modal();
//});

function errorHtml(content, title) {
	hideAll();
	$("#messageModalTitle").text(title);
	$("#modalAlertError").removeClass("d-none");
	$("#modalAlertError").html(content);
	$("#modal-message").modal();
}

function alertAreYouSure(content) {
	hideAll();
	$("#messageModalTitle").text("Are you sure?");
	$("#modalAlertMessage").removeClass("d-none");
	$("#modalAlertMessage").html(content);
	$("#modal-message").modal();
}

function error(content, title) {
	hideAll();
	$("#messageModalTitle").text(title);
	$("#modalAlertError").removeClass("d-none");
	$("#modalAlertError").text(content);
	$("#modal-message").modal();
}

function successM(content, title) {
	hideAll();
	$("#messageModalTitle").text(title);
	$("#modalAlertSuccess").removeClass("d-none");
	$("#modalAlertSuccess").text(content);
	$("#modal-message").modal();
}

function errorList(content, title) {
	hideAll();
	$("#messageModalTitle").text(title);
	$("#modalAlertError").removeClass("d-none");
	$("#modalAlertError").text("");
	for (var i = 0; i < content.length; i++) {
		$("#modalAlertError").append("*" + content[i]);
	}
	$("#modal-message").modal();
}

function hideAll() {
	$("#modalAlertError").addClass("d-none");
	$("#modalAlertSuccess").addClass("d-none");
	$("#modalAlertMessage").addClass("d-none");
}

function notLoggedIn() {
	var html = '';
	html += '<div><p> Do you have an account?	<a class="btn btn-outline-success" href="'
			+ $("#path").val()
			+ '/login">Log in</a> to get access to vote functions!';
	html += '</p><p>	Not registered yet? Finish simple <a class="btn btn-outline-success" href="'
			+ $("#path").val()
			+ '/register">Registration</a>	and get access to all service features!	</p></div>';
	errorHtml(html, "You must be logged in!");
}

function deleteVersusContent() {
	var html = '';

	html += '<div class="container row">';
	html += '<h4>You are trying to delete versus...</h4>';
	html += '<button type="button" class="col-6 btn btn-primary" data-dismiss="modal">cancel</button>';
	html += '<button type="button" class="col-6 btn btn-danger confirm" data-dismiss="modal">delete</button></div>';

	alertAreYouSure(html);
}
