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
		outputData(data);
		if (data.length == 0) {
			jQuery('.empty-list-alert').css('display', 'block');
		}
	}).fail(function(data) {
		console.log(data.statusText + " -> " + data.status);
	});
}

jQuery('.versus-title').on('click', function() {
	var route = $('#path').val() + "/showVersus/" + this.id;
	location.href = route;
});
function outputData(data) {
	var p = $("#path").val();
	var marks = null;
	var curId = $("#currentId").val();
	if (curId) {
		console.log("ok" + curId);
		marks = getUserMarks(curId);
		$.when(marks).done(function() {
			console.log("done");
			console.log(marks.responseJSON);
			dataFinallyDone(data, curId, marks.responseJSON);
		})
	} else {
		console.log("not ok ");
		dataFinallyDone(data, null, null);
	}
}

function dataFinallyDone(data, curId, marks) {
	var p = $("#path").val();
	for (var i = 0; i < data.length; i++) {
		var $row = $("<div>").attr("class", "row bg-dark text-light list-item");
		var $ratingWrapper = $("<div>")
				.attr("class",
						"col-1 d-flex justify-content-end align-items-center rating-counter-wrap");
		var $ratingLabel = $("<label>").attr("class", "rating-counter").append(
				getMark(data[i].marks));
		var $voteContainer = $("<div>").attr("class",
				"col-1 d-flex align-items-center");
		var $arrows = $("<div>").attr("class", "arrow");

		var $aUp = $("<a>").attr("id", "upVote-" + data[i].id).attr("name",
				data[i].id).click(function() {
			if (curId) {
				createMarkForVersus(true, curId, $(this).attr("name"));
			} else {
				alert("U MUST BE LOGGED IN TO VOTE!");
			}
			;
		});
		var $aDown = $("<a>").attr("id", "downVote-" + data[i].id).attr("name",
				data[i].id).click(function() {
			if (curId) {
				createMarkForVersus(false, curId, $(this).attr("name"));
			} else {
				alert("U MUST BE LOGGED IN TO VOTE!");
			}
			;
		});
		if (curId) {
			if (notVoted(data[i].id, marks)) {

			} else {
				$($aUp).hide();
				$($aDown).hide();
			}
		}
		var $up = $("<img>").attr("class", "arrow-up").attr("src",
				p + "/resources/images/arrow_up.png");
		var $down = $("<img>").attr("class", "arrow-down").attr("src",
				p + "/resources/images/arrow_down.png");

		var $infoContainer = $("<div>").attr("class", "col-8");
		var $infoTitleRedirect = $("<a>").attr("href",
				p + "/versus/show/" + data[i].id);
		var $infoTitle = $("<div>").append(
				$("<h5>").attr("class", "versus-title").attr("id", data[i].id)
						.append(data[i].title));
		var $infoDescription = $("<div>").attr("class", "versus-description")
				.append(data[i].description);

		var $authorContainer = $("<div>").attr("class",
				"col-2 versus-author-wrap");
		var $author = $("<div>").attr("class", "versus-author").append(
				$("<h5>").append("Author"));
		var $authorText = $("<p>").attr("class", "author-nickname").append(
				data[i].author.nickName);

		$($ratingWrapper).append($ratingLabel);

		$($aUp).append($up);
		$($aDown).append($down);
		$($arrows).append($aUp).append($aDown);
		$($voteContainer).append($arrows);

		$($infoTitleRedirect).append($infoTitle);

		$($infoContainer).append($infoTitleRedirect);
		$($infoContainer).append($infoDescription);

		$($author).append($authorText);
		$($authorContainer).append($author);

		$($row).append($ratingWrapper);
		$($row).append($voteContainer);
		$($row).append($infoContainer);
		$($row).append($authorContainer);

		$("#versus-list").append($row);
	}
}
function getMark(marks) {
	var counter = 0;
	for (var i = 0; i < marks.length; i++) {
		if (marks[i].mark == true) {
			counter++;
		} else {
			counter--;
		}
	}

	return counter;
}

function getUserMarks(id) {
	return $.ajax({
		url : $('#path').val() + '/api/versusMark/getByUser/' + id,
		type : 'GET',
		dataType : 'json'
	});
}

function createMarkForVersus(mark, userId, versusId) {
	var item = {
		"mark" : mark,
		"user" : {
			"id" : userId
		},
		"versus" : {
			"id" : versusId
		}
	};

	$.ajax({
		url : $('#path').val() + '/api/versusMark/create',
		type : 'POST',
		data : JSON.stringify(item),
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
		console.log("good -> change counter on interface for current versus");
		console.log(data);
	}).fail(function(data) {
		console.log(data.responseText);
	});
}

function notVoted(versusId, marks) {
	console.log("check mark called");
	for (var i = 0; i < marks.length; i++) {
		if (marks[i].versus.id == versusId) {
			return false;
		}
	}
	return true;
}

/*
 * jQuery('.list-item').mouseenter(function (){
 * jQuery('.list-item').addClass('inverted'); });
 */

