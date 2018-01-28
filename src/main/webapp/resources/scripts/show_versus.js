jQuery(window).on('load', getOneVersus);
	function getOneVersus() {
		var location = document.location.href;
		var len = location.length;
		var route = '/VoteMe/api/versus/get/' + location[len - 1];

		jQuery.ajax({
			url : route,
			type : 'GET',
			contentType : "application/json",
			dataType : 'json'
		}).done(function(data) {
			console.log("good");
			console.log(data);
			$("#versus-title").append(data.title);
			$("#opinion1").append(data.opinions[0].text);
			$("#op1-mark").append(getMark(data.opinions[0].marks));
			$("#op2-mark").append(getMark(data.opinions[1].marks));
			$("#opinion2").append(data.opinions[1].text);
			$("#description").append(data.description);
		}).fail(function(data) {
			console.log(data);
		});
	}
	
	function getMark(marks){
		//Here must be foreach loop to iterate over marks array 
		//Then return ((sum of positive) - (sum of negative)) marks or return positive and negative marks
		//as Likes and Dislikes??
		return Math.floor(Math.random() * 1001); 
	}

