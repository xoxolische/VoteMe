jQuery(window).on('load', getAllVersus);

function getAllVersus() {			
	jQuery.ajax({
		url : '/VoteMe/api/versus/getAll',
		type : 'GET',
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
		console.log("good");
		console.log(data);
	}).fail(function(data) {
		console.log(data);
	});
}

jQuery('.versus-title').on('click', function() {
	var route = "/VoteMe/showVersus/" + this.id;
	location.href = route;
});


