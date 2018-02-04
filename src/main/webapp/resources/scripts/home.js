jQuery(window).on('load', getAllVersus);

function getAllVersus() {			
	jQuery.ajax({
		url : $('#path').val() + '/api/versus/getAll',
		type : 'GET',
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
		console.log("good");
		console.log(data);
		if (data.length == 0) {
			jQuery('.empty-list-alert').css('display', 'block');
		}
	}).fail(function(data) {
		console.log(data.statusText + " -> "+data.status);
	});
}

jQuery('.versus-title').on('click', function() {
	var route = $('#path').val() + "/showVersus/" + this.id;
	location.href = route;
});


