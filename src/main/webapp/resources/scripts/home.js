jQuery(window).on('load', getAllVersus);

function getAllVersus() {
	jQuery.ajax({
		url : $('#path').val() + '/api/versus/getAll',
		type : 'GET',
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
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
	var route = $('#path').val() + "/versus/show/" + this.id;
	location.href = route;
});

function outputData(data) {
	var p = $("#path").val();
	var marks = null;
	var curId = $("#currentId").val();
	//console.log("curId = "+curId);
	if (curId) {
		marks = getUserMarks(curId);
		$.when(marks).done(function() {
			dataFinallyDone(data, curId, marks.responseJSON);
		})
	} else {
		dataFinallyDone(data, null, null);
	}
}

function dataFinallyDone(data, curId, marks) {
	var p = $("#path").val();
	//console.log("datafinally done loop beginning.");
	for (var i = 0; i < data.length; i++) {
		// var $row = $("<div>").attr("class", "row bg-dark text-light
		// list-item");
		// var $ratingWrapper = $("<div>")
		// .attr("class",
		// "col-1 d-flex justify-content-end align-items-center
		// rating-counter-wrap");
		// var $ratingLabel = $("<label>").attr("id", "rating" +
		// data[i].id).attr(
		// "class", "rating-counter").append(getMark(data[i].marks));
		// var $voteContainer = $("<div>").attr("class",
		// "col-1 d-flex align-items-center");
		// var $arrows = $("<div>").attr("class", "arrow");
		//
		// var $aUp = $("<a>").attr("id", "upVote-" + data[i].id).attr("name",
		// data[i].id).click(function() {
		// if (curId) {
		// createMarkForVersus(true, curId, $(this).attr("name"));
		// } else {
		// alert("U MUST BE LOGGED IN TO VOTE!");
		// }
		// ;
		// });
		// var $aDown = $("<a>").attr("id", "downVote-" +
		// data[i].id).attr("name",
		// data[i].id).click(function() {
		// if (curId) {
		// createMarkForVersus(false, curId, $(this).attr("name"));
		// } else {
		// alert("U MUST BE LOGGED IN TO VOTE!");
		// }
		// ;
		// });
		// if (curId) {
		// if (notVoted(data[i].id, marks)) {
		//
		// } else {
		// $($aUp).hide();
		// $($aDown).hide();
		// }
		// }
		// var $up = $("<img>").attr("class", "arrow-up").attr("src",
		// p + "/resources/images/arrow_up.png");
		// var $down = $("<img>").attr("class", "arrow-down").attr("src",
		// p + "/resources/images/arrow_down.png");
		//
		// var $infoContainer = $("<div>").attr("class", "col-8");
		// var $infoTitleRedirect = $("<a>").attr("href",
		// p + "/versus/show/" + data[i].id);
		// var $infoTitle = $("<div>").append(
		// $("<h5>").attr("class", "versus-title").attr("id", data[i].id)
		// .append(data[i].title));
		// var $infoDescription = $("<div>").attr("class", "versus-description")
		// .append(data[i].description);
		//
		// var $authorContainer = $("<div>").attr("class",
		// "col-2 versus-author-wrap");
		// var $author = $("<div>").attr("class", "versus-author").append(
		// $("<h5>").append("Author"));
		// var $authorText = $("<p>").attr("class", "author-nickname").append(
		// data[i].author.nickName);
		//
		// $($ratingWrapper).append($ratingLabel);
		//
		// $($aUp).append($up);
		// $($aDown).append($down);
		// $($arrows).append($aUp).append($aDown);
		// $($voteContainer).append($arrows);
		//
		// $($infoTitleRedirect).append($infoTitle);
		//
		// $($infoContainer).append($infoTitleRedirect);
		// $($infoContainer).append($infoDescription);
		//
		// $($author).append($authorText);
		// $($authorContainer).append($author);
		//
		// $($row).append($ratingWrapper);
		// $($row).append($voteContainer);
		// $($row).append($infoContainer);
		// $($row).append($authorContainer);
		//

		appendData(data[i], curId, marks);
		//console.log("datafinally done here!");
		// $("#versus-list").append($row);
		$("#preloader").hide();
		jQuery('.page-title').css('display', 'block');

	}

}

// this is gavno code here!!!
function appendData(v, curId, marks) {
	// console.log(v);
	var vDateTime = v.createdAt;
	var vAuthor = v.author;
	var vMark = getMark(v.marks);
	var vCommentsNumber = getComments(v.comments);
	var commentId;
	var commentText;
	var commentAuthor;
	var commentDateTime;

	var p = $("#path").val();
	var up = p + "/resources/images/arrow_up.png";
	var down = p + "/resources/images/arrow_down.png";

	var html = '<div class="row bg-dark text-light flex-wrap flex-column list-item">';

	html += '<div class="row" style="height: 100px;">';
	html += '	<div ';
	html += '		class="col-6 col-sm-6 col-md-1 col-lg-1 col-xl-1 ';
	html += '		d-flex justify-content-center align-items-center rating-counter-wrap"> ';
	html += '		<label class="rating-counter" id="rating' + v.id + '">' + vMark
			+ '</label> ';
	html += '	</div> ';

	html += '	<div ';
	html += '		class="col-6 col-sm-6 col-md-1 col-lg-1 col-xl-1 ';
	html += '		d-flex align-items-center justify-content-center"> ';
	html += '		<div class="arrow"> ';
	html += '			<a id="upVote-' + v.id + '" name="' + v.id
			+ '"><img class="arrow-up" ';
	html += '				src=' + up + '></a><a id="downVote-' + v.id + '" name="'
			+ v.id + '"> <img ';
	html += '				class="arrow-down" ';
	html += '				src=' + down + '></a>';
	html += '		</div> ';
	html += '	</div> ';

	html += '	<div class="col-12 col-sm-12 col-md-10 col-lg-10 col-xl-10"> ';
	html += '		<div> ';
	html += '			<h5 class="versus-title">' + v.title + '</h5> ';
	html += '		</div> ';
	html += '		<div class="versus-description">' + v.description + '</div> ';
	html += '	</div> ';
	html += '</div>';

	html += '<div class="dropdown-divider"></div>';

	html += '<div class="row" style="padding: 10px;">';
	html += '	<div class="col-6 d-flex justify-content-center">';

	html += '		<button	class="btn btn-outline-light d-flex flex-column flex-sm-column flex-md-row ';
	html += '			justify-content-center align-items-center" ';
	html += '			type="button" data-toggle="collapse" data-target="#comment-block'
			+ v.id + '" ';
	html += '			aria-expanded="false" aria-controls="comment-block' + v.id
			+ '"> ';
	html += '			<i class="far fa-comments fa-2x"></i> <span class="ml-md-3">'
			+ vCommentsNumber + '</span> ';
	html += '		</button> ';
	html += '	</div> ';

	html += '	<div class="col-6 d-flex justify-content-center versus-author-wrap"> ';
	html += '		<div ';
	html += '			class="d-flex flex-column flex-sm-column  ';
	html += '			flex-md-row versus-author"> ';
	html += '			<p>Author:&nbsp</p> ';
	html += '			<p class="author-nickname">' + v.author.nickName + '</p> ';
	html += '		</div> ';
	html += '	</div> ';
	html += '</div>';

	html += '<div class="row collapse" id="comment-block' + v.id
			+ '" style="padding: 15px;">';

	html += '	<div class="row"> ';

	html += '		<div class="col-12"> ';
	html += '			<div class="input-group"> ';
	html += '			<div class="input-group-prepend"> ';
	html += '					<span ';
	html += '					class="input-group-text d-flex ';
	html += '					justify-content-center"> ';
	html += '					<i class="far fa-comment"></i> ';
	html += '				</span> ';
	html += '			</div> ';
	html += '			<textarea id="user-comment-' + v.id + '" ';
	html += '				class="form-control enter-comment-fheight" ';
	html += '				aria-label="With textarea" placeholder="enter your comment"></textarea> ';
	html += '			</div> ';

	html += '			<button id="c-button-' + v.id + '" name="' + v.id
			+ '" class="btn btn-outline-primary btn-block mt-2">Send</button> ';
	html += '		</div> ';
	html += '	</div> ';

	html += '	<div class="dropdown-divider"></div> ';

	html += '	<div class="row"><div class="col-12"><h6>Comments(<span>'
			+ vCommentsNumber + '</span>)</h6></div></div> ';

	html += '	<div id="comment-container-' + v.id + '"></div>';

	$(document)
			.ready(
					function() {
						$("#upVote-" + v.id).click(
								function() {
									if (curId) {
										createMarkForVersus(true, curId,
												$(this).attr("name"));
									} else {
										alert("U MUST BE LOGGED IN TO VOTE!");
									}
									;
								});
						$("#downVote-" + v.id).click(
								function() {
									if (curId) {
										createMarkForVersus(false, curId, $(
												this).attr("name"));
									} else {
										alert("U MUST BE LOGGED IN TO VOTE!");
									}
									;
								});
						$("#c-button-" + v.id)
								.click(
										function() {
											if (curId) {
												var versus = $(this).attr(
														"name");
												createComment(
														$(
																"#user-comment-"
																		+ versus)
																.val(), curId,
														versus);
												// createMarkForVersus(false,
												// curId, $(this).attr("name"));
												// createComment($(this).attr("name"));
											} else {
												alert("U MUST BE LOGGED IN TO LEAVE A COMMENT!");
											}
											;
										});
						if (curId) {
							if (notVoted(v.id, marks)) {

							} else {
								$("#upVote-" + v.id).hide();
								$("#downVote-" + v.id).hide();
							}
						}
						appendComments(v.comments, v.id);
					});

	$("#versus-list").append(html);
	$("#lastDate").val(v.createdAt);

}
function appendComments(c, id) {
	for (var i = 0; i < c.length; i++) {
		var createDate = moment(c[i].createdAt).format("HH:mm:ss DD/MM/YYYY")
		var html = '<div class="row mt-3 d-flex flex-column"><div class="d-flex"><div class="col-3 col-sm-3 col-md-2 col-lg-1 col-xl-1 d-flex justify-content-end pr-0">';
		html += '	<div class="d-flex justify-content-center align-items-center border rounded" style="height: 60px; width: 60px;">image</div>	</div><div	class="col-9 col-sm-9 col-md-10 col-lg-11 col-xl-11 d-flex flex-column">';
		html += '	<div class="d-flex justify-content-between flex-column flex-sm-row"><h6>'
				+ c[i].author.nickName
				+ '</h6><span>'
				+ createDate
				+ '</span></div>';
		html += '	<div class="d-flex"><p class="text-justify">'
				+ c[i].text
				+ '</p></div></div></div><div class="d-flex dropdown-divider "	style="margin-left: 15px; margin-right: 15px;"></div></div> </div></div>';
		$("#comment-container-" + id).append(html);
	}
};
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

function getComments(comments) {
	if (comments != null) {
		return comments.length;
	} else {
		return 0;
	}
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
		var id = "#rating" + versusId;
		if (mark) {
			var m = +($(id).text());
			$(id).text(m + 1);
			$("#downVote-" + versusId).hide();
			$("#upVote-" + versusId).hide();
		} else {
			var m = +($(id).text());
			$(id).text(m - 1);
			$("#downVote-" + versusId).hide();
			$("#upVote-" + versusId).hide();
		}

	}).fail(function(data) {
		console.log(data);
	});
}

function notVoted(versusId, marks) {
	for (var i = 0; i < marks.length; i++) {
		if (marks[i].versus.id == versusId) {
			return false;
		}
	}
	return true;
}

function loadMore() {
	var lastDate = $("#lastDate").val();

	$.ajax({
		url : $('#path').val() + '/api/versus/getMore/' + lastDate,
		type : 'GET',
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
		//console.log($("#lastDate").val());
		console.log(data);
		outputData(data);
	}).fail(function(data) {
		console.log(data.responseText);
	});
}
