function createComment(text, curId, vId) {

	var item = {
		"text" : text,
		"author" : {
			"id" : curId
		},
		"versus" : {
			"id" : vId
		}
	};

	$.ajax({
		url : $('#path').val() +'/api/comment/create',
		type : 'POST',
		data : JSON.stringify(item),
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
		alert("Comment "+text+" have been added!")
	}).fail(function(data) {
		console.log(data.responseText);
	});
}