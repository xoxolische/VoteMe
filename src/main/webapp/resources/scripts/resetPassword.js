function reset() {
	$.ajax({
		url : $('#path').val() +'/users/resetPassword?email='+$("#resetEmail").val(),
		type : 'GET'
	}).done(function(data) {
		//console.log(data);
		$("#resetSuccess").hide();
		$("#resetError").hide();
		$("#resetForm").hide(500);
		$("#resetSuccess").removeClass("d-none");
		$("#resetSuccess").html(data);
		$("#resetSuccess").show(1000);
		//console.log(data.responseText);
	}).fail(function(data) {
		//console.log(data.responseText);
		$("#resetError").removeClass("d-none");
		$("#resetError").html(data.responseText);
	});
}

function errorPresent(error){
	$("#resetForm").hide();
	$("#resetError").removeClass("d-none");
	$("#resetError").html(error);
}
function successPresent(success){
	$("#resetForm").hide();
	$("#resetSuccess").removeClass("d-none");
	$("#resetSuccess").html(success);
}
