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

function error(content, title) {
	hideAll();
	$("#messageModalTitle").text(title);
	$("#modalAlertError").removeClass("d-none");
	$("#modalAlertError").text(content);
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
