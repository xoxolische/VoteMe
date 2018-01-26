jQuery('#submit-button').click(createVersus);

function createVersus() {
	var op1 = {
		"text" : jQuery('#opinion-1').val()
	};

	var op2 = {
		"text" : jQuery('#opinion-2').val()
	};
	var opinions = new Array();
	opinions.push(op1);
	opinions.push(op2);

	var item = {
		"title" : jQuery('#versus-tittle').val(),
		"description" : jQuery('#description').val(),
		// "author" : {
		// //"id" : 1
		// },
		"opinions" : opinions
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
		console.log(data.responseText);
	});
}
