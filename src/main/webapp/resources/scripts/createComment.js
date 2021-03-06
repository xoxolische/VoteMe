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
		url : $('#path').val() + '/api/comment/create',
		type : 'POST',
		data : JSON.stringify(item),
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
		//console.log(data);	
		$("#user-comment-" + vId).val("");
		console.log(data);
		prependComment(data, vId);
		// alert("Your comment has been added!")
	}).fail(function(data) {
		console.log(data.responseText);
	});
}