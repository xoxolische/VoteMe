jQuery(window).on('load', getOneVersus);

function getOneVersus() {
	var curId = $("#currentId").val();
	var location = document.location.href;
	var versus_id = '';

	var i = location.length - 1;

	while (location[i] != '/') {
		i--;
	}

	while (i < location.length) {
		versus_id += location[i];
		i++;
	}

	var route = $('#path').val() + '/api/versus/get/' + versus_id;

	jQuery.ajax({
		url : route,
		type : 'GET',
		contentType : "application/json",
		dataType : 'json'
	}).done(
			function(data) {
				console.log("good");
				console.log(data);
				if (hasVoted(curId, data.opinions[0].marks)
						|| hasVoted(curId, data.opinions[1].marks)) {
					$("#upVoteOp-1").hide();
					$("#upVoteOp-2").hide();
				}
				jQuery('#versus-container').css('display', 'block');
				$("#versus-title").append(data.title);
				$("#opinion1").append(data.opinions[0].text);
				$("#op1-mark").append(getMark(data.opinions[0].marks));
				$("#op2-mark").append(getMark(data.opinions[1].marks));
				$("#opinion2").attr("name", data.opinions[1].id).append(
						data.opinions[1].text);
				$("#description").append(data.description);
				$("#nick-name").append(data.author.nickName);
				$("#upVoteOp-1").attr("name", data.opinions[0].id);
				$("#upVoteOp-2").attr("name", data.opinions[1].id);
			}).fail(function(data) {
		console.log(data);
		jQuery('#error-warning').css('display', 'block');
	});
}

function hasVoted(userId, marks) {
	console.log("check mark called");
	console.log("Current id=" + userId)
	for (var i = 0; i < marks.length; i++) {
		if (marks[i].user.id == userId) {
			console.log("found vote!");
			return true;
		}
	}
	console.log("not found!");
	return false;
}

function getMark(marks) {
	// Here must be foreach loop to iterate over marks array
	// Then return ((sum of positive) - (sum of negative)) marks or return
	// positive and negative marks
	// as Likes and Dislikes??
	// return Math.floor(Math.random() * 1001);
	var counter = 0;
	for (var i = 0; i < marks.length; i++) {
		if (marks[i].mark == true) {
			counter++;
		}
	}

	return counter;
}

function createMark(n) {
	if (!$("#currentId").val()) {
		alert("You need to be logged in to vote!");
	} else {
		var opId = $("#upVoteOp-" + n).attr("name");

		var item = {
			"mark" : "true",
			"user" : {
				"id" : $("#currentId").val(),

			},
			"opinion" : {
				"id" : opId
			}
		}
		$.ajax({
			url : $('#path').val() + '/api/opinionMark/create',
			type : 'POST',
			data : JSON.stringify(item),
			contentType : "application/json",
			dataType : 'json'
		}).done(function(data) {
			console.log("good");
			console.log(data);
			$("#upVoteOp-1").hide();
			$("#upVoteOp-2").hide();
			if (n == 1) {
				console.log("op1 mark");
				$("#op1-mark").text($("#op1-mark").val()+1);
			} else {
				console.log("op2 mark");
				$("#op2-mark").text($("#op2-mark").val()+1);
			}

		}).fail(function(data) {
			console.log(data.responseText);
		});
	}

}
