

//check description overflow when window resized
jQuery(window).resize(function (){

	jQuery('.desc-and-button').each(function(){
		if (jQuery(this).height() > 94) {

			//add description overflow button
			jQuery(this).css('display', 'block');
			jQuery(this).addClass('description-overflow');
		}

	});
});

//check description overflow when page load
jQuery(window).on('load', function (){

	jQuery('.desc-and-button').each(function(){

		if (jQuery('.description', this).height() > 94) {

			//add description overflow button
			jQuery('.overflow-button', this).css('display', 'block');
			jQuery('.description', this).addClass('description-overflow');
			jQuery('.description', this).css('height', '70px');

		}

	});

});


function setOverflowButtonWidth(){
	jQuery('.overflow-button').css('width', function(){
		return jQuery('.description').width() + 'px';
	});
}

jQuery(window).on('load', setOverflowButtonWidth());

//jQuery(window).on('resize', setOverflowButtonWidth());
//why is this shit not working
//but this works
jQuery(window).on('resize', function (){
	jQuery('.overflow-button').css('width', function(){
		return jQuery('.description').width() + 'px';
	});
});
