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
		var index = 0;
		jQuery(data).each(function (){
			showVersusList(index, data);
		});
	}).fail(function(data) {
		console.log(data);
	});
}

jQuery(window).on('load', function() {
	jQuery('#versus-list').append(showVersusList);
	jQuery('.arrows').append(appendArrows);
});


function showVersusList(i, array){
	var list_item = '<div class="row bg-dark text-light list-item">'
				+'<div '
					+'class="col-1 d-flex justify-content-end align-items-center rating-counter-wrap">'
					+'<label class="rating-counter">9999</label>'
				+'</div>'

				+'<div class="col-1 d-flex align-items-center">'
					+'<div class="arrows">'
					//+'<img class="arrow-up" src="<c:url value="/resources/images/arrow_up.png"/>">' 
					//+'<img class="arrow-down" src="<c:url value="/resources/images/arrow_down.png"/>">'
					+'</div>'
				+'</div>'
				+'<div class="col-8">'
					+'<div>'
						+'<h5 class="versus-title">'
						+ array[i].title
						+'</h5>'
					+'</div>'
					+'<div class="versus-description">'
					+ array[i].description
					+'</div>'
				+'</div>'
				+'<div class="col-2 versus-author-wrap">'
					+'<div class="versus-author">'
						+'<h5>'
						+ array[i].author
						'</h5>'
						+'<p class="author-nickname">nickname</p>'
					+'</div>'
				+'</div>'
			+'</div>';

	return list_item;
}

function appendArrows(){

	var arrow_up = jQuery('<img/>', {
		class: 'arrow-up',
		src : '<c:url value="/resources/images/arrow_down.png"/>'
	});

	return arrow_up;
}

/*
+'<img class="arrow-up" '
							+'src="<c:url value=/resources/images/arrow_up.png">">'
							+'<img class="arrow-down" src="<c:url value="/resources/images/arrow_down.png"/>">'

*/


