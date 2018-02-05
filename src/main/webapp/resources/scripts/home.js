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
function outputData(data){
	var p = $("#path").val();
	for (var i = 0; i < data.length; i++) {
		var $row = $("<div>").attr("class", "row bg-dark text-light list-item");
		var $ratingWrapper = $("<div>").attr("class", "col-1 d-flex justify-content-end align-items-center rating-counter-wrap");
		var $ratingLabel = $("<label>").attr("class", "rating-counter").append(getMark(data[i].marks));
		var $voteContainer = $("<div>").attr("class", "col-1 d-flex align-items-center");
		var $arrows = $("<div>").attr("class","arrow");
		var $up = $("<img>").attr("class","arrow-up").attr("src", p+"/resources/images/arrow_up.png");
		var $down = $("<img>").attr("class","arrow-down").attr("src", p+"/resources/images/arrow_up.png");
		var $infoContainer = $("<div>").attr("class","col-8");
		var $infoTitle = $("<div>").append($("<h5>").attr("class", "versus-title").attr("id", data[i].id).append(data[i].title));
		var $infoDescription = $("<div>").attr("class","versus-description").append(data[i].description);
		
		var $authorContainer = $("<div>").attr("class","col-2 versus-author-wrap");
		var $author = $("<div>").attr("class","versus-author").append($("<h5>").append("Author"));
		var $authorText = $("<p>").attr("class","author-nickname").append(data[i].author.nickName);
		
		
		$($ratingWrapper).append($ratingLabel);
		
		$($arrows).append($up).append($down);		
		$($voteContainer).append($arrows);
		
		$($infoContainer).append($infoTitle);
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
		if(marks[i].mark == true){
			counter++;
		}else{
			counter--;
		}
	}
	
	return counter;
}

/*
 * jQuery('.list-item').mouseenter(function (){
 * jQuery('.list-item').addClass('inverted'); });
 */

