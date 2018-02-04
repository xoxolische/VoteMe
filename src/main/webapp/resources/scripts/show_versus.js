jQuery(window).on('load', getOneVersus);
	
	function getOneVersus() {
		var location = document.location.href;
		var versus_id = '';

		var i = location.length - 1;

		while (location[i] != '/'){
			i--;
		}

		while (i < location.length){
			versus_id += location[i];
			i++;
		}

		var route = $('#path').val() +'/api/versus/get/' + versus_id;

		jQuery.ajax({
			url : route,
			type : 'GET',
			contentType : "application/json",
			dataType : 'json'
		}).done(function(data) {
			console.log("good");
			console.log(data);
			jQuery('#versus-container').css('display', 'block');
			$("#versus-title").append(data.title);
			$("#opinion1").append(data.opinions[1].text);
			$("#op1-mark").append(getMark(data.opinions[1].marks));
			$("#op2-mark").append(getMark(data.opinions[0].marks));
			$("#opinion2").append(data.opinions[0].text);
			$("#description").append(data.description);
			$("#nick-name").append(data.author.nickName);
		}).fail(function(data) {
			console.log(data);
			jQuery('#error-warning').css('display', 'block');
		});
	}


	
	function getMark(marks){
		//Here must be foreach loop to iterate over marks array 
		//Then return ((sum of positive) - (sum of negative)) marks or return positive and negative marks
		//as Likes and Dislikes??
		return Math.floor(Math.random() * 1001); 
	}

