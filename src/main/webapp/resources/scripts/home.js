jQuery('#more-button').hide();
jQuery('.page-title').hide();
jQuery(window).on('load', getAllVersus);

function getAllVersus() {
	jQuery.ajax({
		url : $('#path').val() + '/api/versus/getAll',
		type : 'GET',
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
		//console.log(data);
		outputData(data);
//		if (data.length == 0) {
//			jQuery('.empty-list-alert').css('display', 'block');
//		}
	}).fail(function(data) {
		console.log(data.statusText + " -> " + data.status);
	});
}

function outputData(data) {
	var p = $("#path").val();
	var marks = null;
	var cMarks = null;
	var curId = $("#currentId").val();
	// console.log("curId = "+curId);
	if (curId) {
		marks = getUserMarks(curId);
		cMarks = getUserMarksForComment(curId);
		$.when(marks, cMarks).done(
				function() {
					dataFinallyDone(data, curId, marks.responseJSON,
							cMarks.responseJSON);
				})
	} else {
		dataFinallyDone(data, null, null);
	}
}

function dataFinallyDone(data, curId, marks, cMarks) {
	var p = $("#path").val();
	// console.log("datafinally done loop beginning.");
	for (var i = 0; i < data.length; i++) {
		appendData(data[i], curId, marks, cMarks);
	}
	$("#preloader").hide();
	jQuery('.page-title').show();
	jQuery('#more-button').show();
}

// this is gavno code here!!!
function appendData(v, curId, marks, cMarks) {
	var roleName = $("#currentRole").val();
	// console.log(v);
	var vDateTime = v.createdAt;
	var vCreateDate = moment(vDateTime).format("HH:mm:ss DD/MM/YYYY")
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

	var html = '<div class="row bg-dark text-light flex-wrap flex-column list-item" id="'
			+ v.id + '">';

	html += '<div class="row" style="height: 105px;">';
	html += '	<div ';
	html += '		class="col-5 col-sm-5 col-md-1 col-lg-1 col-xl-1 ';
	html += '		d-flex justify-content-center align-items-center rating-counter-wrap"> ';
	html += '		<label class="rating-counter" id="rating' + v.id + '">' + vMark
			+ '</label> ';
	html += '	</div> ';

	html += '	<div ';
	html += '		class="col-5 col-sm-5 col-md-1 col-lg-1 col-xl-1 ';
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

	html += '	<div class="col-10 col-sm-10 col-md-9 col-lg-9 col-xl-9"> ';
	html += '		<div> ';
	html += '			<a target="_blank" href="' + p + "/versus/show/" + v.id
			+ '"><h5 class="versus-title">' + v.title + '</h5></a>';
	html += '		</div> ';
	html += '		<div class="versus-description">' + v.description + '</div> ';
	html += '	</div> ';
	// here
	if (roleName == "ADMIN") {
		html += '<div class="col-2 col-sm-2 col-md-1 col-lg-1 col-xl-1 d-flex flex-column">'
				+ '<span class="d-flex mb-1 justify-content-end edit-button">'
				+ '<i class="fas fa-pen-square fa-2x"></i>'
				+ '</span>'

				+ '<span class="d-flex justify-content-end">'
				+ '<i class="fas fa-trash-alt fa-2x delete-button"></i>'
				+ '</span>' + '</div>';
	}
	;
	html += '</div>';

	html += '<div class="dropdown-divider"></div>';

	html += '<div class="row d-flex">';

	html += '	<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4'
	html += ' d-flex justify-content-center align-items-center versus-author-wrap"> ';
	html += '		<div ';
	html += '			class="d-flex flex-row versus-author"> ';
	html += '			<p class="mb-0">Author:&nbsp</p> ';
	html += '			<p class="author-nickname mb-0">' + v.author.nickName + '</p> ';
	html += '		</div> ';
	html += '	</div> ';

	html += '	<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4'
	html += ' d-flex justify-content-center align-items-center"> ';

	html += '<p class="d-flex mb-0 versus-date">' + vCreateDate + '</p> ';
	html += '	</div> ';

	html += '	<div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 d-flex '
	html += 'justify-content-center mt-2 mt-sm-2 mt-md-0">';
	html += '		<button	class="btn btn-outline-light d-flex flex-row ';
	html += '			justify-content-center align-items-center" ';
	html += '			type="button" data-toggle="collapse" data-target="#comment-block'
			+ v.id + '" ';
	html += '			aria-expanded="false" aria-controls="comment-block' + v.id
			+ '"> ';
	html += '			<i class="far fa-comments fa-2x"></i> <span class="ml-md-3">&nbsp'
			+ vCommentsNumber + '</span> ';
	html += '		</button> ';
	html += '	</div> ';

	html += '</div>';

	html += '<div class="row collapse mt-2 comments-row" id="comment-block'
			+ v.id + '">';

	html += '<div class="comments-wrap rounded p-1">';

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

	// html += ' <div class="row"><div class="col-12"><h6>Comments(<span>'
	// + vCommentsNumber + '</span>)</h6></div></div> ';

	html += '	<div id="comment-container-' + v.id + '"></div>';

	html += '</div>';

	$(document)
			.ready(
					function() {
						$("#upVote-" + v.id).click(
								function() {
									if (curId) {
										createMarkForVersus(true, curId,
												$(this).attr("name"));
									} else {
										//alert("U MUST BE LOGGED IN TO VOTE!");
										notLoggedIn();
									}
									;
								});
						$("#downVote-" + v.id).click(
								function() {
									if (curId) {
										createMarkForVersus(false, curId, $(
												this).attr("name"));
									} else {
										//alert("U MUST BE LOGGED IN TO VOTE!");
										notLoggedIn();
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
												//alert("U MUST BE LOGGED IN TO LEAVE A COMMENT!");
												notLoggedIn();
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
						appendComments(v.comments, v.id, cMarks);
					});

	$("#versus-list").append(html);
	$("#lastDate").val(v.createdAt);

}

function getCommentMark(c) {
	if (c.marks != null && c.marks.length != 0) {
		var mark = 0;
		for (var i = 0; i < c.marks.length; i++) {
			if (c.marks[i].mark == true) {
				mark += 1;
			} else {
				mark -= 1;
			}
		}
		return mark;
	} else {
		return 0;
	}
}

function appendComments(c, id, cMarks) {
	var p = $("#path").val();
	var p0 = p;
	for (var i = 0; i < c.length; i++) {
		p += "/resources/avatars/" + c[i].author.avatar + ".jpg";
		var createDate = moment(c[i].createdAt).format("HH:mm:ss DD/MM/YYYY")
		var html = '<div class="row mt-3 d-flex flex-column"><div class="d-flex"><div class="col-3 col-sm-3 col-md-2 col-lg-1 col-xl-1 d-flex justify-content-end pr-0">';
		html += '	<div class="d-flex justify-content-center align-items-center border rounded" style="height: 60px; width: 60px;"><img style="height: 60px; width: 60px;" src="'
				+ p
				+ '" alt="no photo"></div>	</div><div	class="col-9 col-sm-9 col-md-10 col-lg-11 col-xl-11 d-flex flex-column">';
		html += '	<div class="d-flex justify-content-between flex-column flex-sm-row"><h6>'
				+ c[i].author.nickName
				+ '</h6><span>'
				+ createDate
				+ '</span></div>';
		html += '	<div class="d-flex"><p class="text-justify">'
				+ c[i].text
				+ '</p></div></div></div>'
				+ '<div class="row d-flex justify-content-center">'
				+ '<div class="d-flex flex-row">'
				+ '<span class="rate-comment-down d-flex align-items-center"><i id="up-vote-comment-'
				+ c[i].id
				+ '" class="fas fa-thumbs-up d-none"></i></span>'
				+ '<label id="comment-rating-'
				+ c[i].id
				+ '" class="comment-rating mb-0 ml-4 mr-4 d-flex align-self-center">'
				+ getCommentMark(c[i])
				+ '</label>'
				+ '<span class="rate-comment-up d-flex align-items-center"><i id="down-vote-comment-'
				+ c[i].id
				+ '" class="fas fa-thumbs-down d-none"></i></span>'
				+ '</div>'
				+ '</div>'
				+ '<div class="d-flex dropdown-divider" style="margin-left: 15px; margin-right: 15px;"></div></div> </div></div>';
		$("#comment-container-" + id).append(html);
		p = p0;
		if (notVotedForComment(c[i].id, cMarks)) {
			//console.log("not voted " + c[i].id);
			s(c[i].id);
			$("#down-vote-comment-" + c[i].id).removeClass("d-none");
			$("#up-vote-comment-" + c[i].id).removeClass("d-none");
//
//			var curId = $("#currentId").val();
//			$("#down-vote-comment-" + c[i].id).click(function() {
//				voteComment(curId, c[i].id, false);
//			});
//
//			$("#up-vote-comment-" + c[i].id).on("click", function() {
//				voteComment(curId, c[i].id, true);
//			});
		}
	}
};
function notVotedForComment(commentId, marks) {
	// console.log(marks);
	// console.log(commentId);
	for (var i = 0; i < marks.length; i++) {
		if (marks[i].comment.id == commentId) {
			// console.log("voted for "+commentId);
			return false;
		}
	}
	return true;
}
// watafaq
function s(id) {

	var curId = $("#currentId").val();
	$(document).ready(function() {		
		$("#down-vote-comment-" + id).on("click", function() {
			voteComment(curId, id, false);
		});
	});
	
	$(document).ready(function() {	
				$("#up-vote-comment-" + id).on("click", function() {
			voteComment(curId, id, true);
		});
	});
	

}
function prependComment(c, id) {
	var p = $("#path").val();
	p += "/resources/avatars/" + c.author.avatar + ".jpg";
	var createDate = moment(c.createdAt).format("HH:mm:ss DD/MM/YYYY")
	var html = '<div class="row mt-3 d-flex flex-column"><div class="d-flex"><div class="col-3 col-sm-3 col-md-2 col-lg-1 col-xl-1 d-flex justify-content-end pr-0">';
	html += '	<div class="d-flex justify-content-center align-items-center border rounded" style="height: 60px; width: 60px;"><img style="height: 60px; width: 60px;" src="'
			+ p
			+ '" alt="no photo"></div>	</div><div	class="col-9 col-sm-9 col-md-10 col-lg-11 col-xl-11 d-flex flex-column">';
	html += '	<div class="d-flex justify-content-between flex-column flex-sm-row"><h6>'
			+ c.author.nickName + '</h6><span>' + createDate + '</span></div>';
	html += '	<div class="d-flex"><p class="text-justify">'
			+ c.text
			+ '</p></div></div></div>'
			+ '<div class="row d-flex justify-content-center">'
			+ '<div class="d-flex flex-row">'
			+ '<span class="rate-comment-down"><i class="fas fa-thumbs-down"></i></span>'
			+ '<label class="comment-rating">999</label>'
			+ '<span class="rate-comment-up"><i class="fas fa-thumbs-up"></i></span>'
			+ '</div>'
			+ '</div>'
			+ '<div class="d-flex dropdown-divider "	style="margin-left: 15px; margin-right: 15px;"></div></div> </div></div>';
	$("#comment-container-" + id).prepend(html);

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

function getUserMarksForComment(id) {
	return $.ajax({
		url : $('#path').val() + '/api/comment/marks/getByUser/' + id,
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
		console.log(data.responseText);
	});
}

function notVoted(versusId, marks) {
	// console.log(marks);
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
		// console.log($("#lastDate").val());
		console.log(data);
		outputData(data);
	}).fail(function(data) {
		console.log(data.responseText);
	});
}

jQuery('body').on('click', '.delete-button', function() {
	var versus = jQuery(this).parent().parent().parent().parent();
	var vId = $(versus).attr("id");
	$.when(deleteVersus(vId)).done(function(data) {
		versus.hide();
		alert("Versus deleted!");
	});
});

function deleteVersus(versusId) {
	return $.ajax({
		url : $('#path').val() + '/api/versus/delete/' + versusId,
		type : 'DELETE'
	});
}

function voteComment(userId, commentId, mark) {
	var item = {
		"mark" : mark,
		"user" : {
			"id" : userId
		},
		"comment" : {
			"id" : commentId
		}
	};
	console.log(item);
	$.ajax({
		url : $('#path').val() + '/api/comment/vote',
		type : 'POST',
		data : JSON.stringify(item),
		contentType : "application/json",
		dataType : 'json'
	}).done(function(data) {
		var id = "#comment-rating-" + commentId;
		$("#up-vote-comment-" + commentId).hide();
		$("#down-vote-comment-" + commentId).hide();
		if (mark) {
			var m = +($(id).text());
			$(id).text(m + 1);
		} else {
			var m = +($(id).text());
			$(id).text(m - 1);
		}

		// console.log(data);
	}).fail(function(data) {
		console.log(data.responseText);
	});
}

function editVersus(versus_id) {

}
