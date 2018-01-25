
jQuery('#submit-button').click(createVersus);

function createVersus() {
	var item = {
			"title" : jQuery('#versus-tittle').val(),
			"description" : jQuery('#description').val(),
			"author" : {
				"id" : 1
			},
			"opinion1" : {
				"text" : jQuery('#opinion-1').val()
			},
			"opinion2" : {
				"text" : jQuery('#opinion-2').val()
			}
		};
				
		$.ajax({
			url : '/VoteMe/api/versus/create',
			type : 'POST',
			data : JSON.stringify(item),
			contentType : "application/json",
			dataType : 'json'
		}).done(function(data) {
			console.log("good");
			console.log(data);
		}).fail(function(data) {
			console.log(data);
		});
}

