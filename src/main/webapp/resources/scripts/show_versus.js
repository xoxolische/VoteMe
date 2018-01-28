jQuery(window).on('load', getOneVersus);
	function getOneVersus() {
		var location = document.location.href;
		var len = location.length;
		var route = '/VoteMe/api/versus/get/' + location[len - 1];

		jQuery.ajax({
			url : route,
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

