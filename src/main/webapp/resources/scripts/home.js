

/*
var desc_height = 0;
function checkTextOverflow(){
	if (jQuery('.description', this).height() > 94) {

		desc_height = jQuery('.description', this).height();
		//add description overflow button
		jQuery('.overflow-button', this).css('display', 'block');
		jQuery('.description', this).css('height', '70px');
	}
	return false;
}

//check description overflow when window resized
jQuery(window).resize(function (){
	jQuery('.desc-and-button').each(checkTextOverflow);
	return false;
});

//check description overflow when page load
jQuery(window).on('load', function (){

	var i = 0;
	jQuery('.desc-and-button').each(function(i) {
		alert(jQuery('.description', this).height());
		if (jQuery('.description', this).height() > 94) {
			desc_height = jQuery('.description', this).height();
			//add description overflow button
			jQuery('.overflow-button', this).css('display', 'block');
			jQuery('.description', this).css('height', '70px');
		}
		return false;
	});
	return false;
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




//click on overflow button down
jQuery('body').on('click','.overflow-button.down', function() {

	//hide button
	jQuery(this).hide();

	//increase description height
	jQuery(this).parent().find('.description').css('height', function (){
		return desc_height + 'px';
	});

	//increase list item height
	var this_list_item = jQuery(this).parent().parent().parent();
	this_list_item.css('height', function() {
		return (desc_height + 30) + 'px';
	});

	//delete old and add new class to button
	jQuery(this).removeClass('down');
	jQuery(this).addClass('up');

	//show button
	jQuery(this).delay(400).queue(function() {
		jQuery(this).show();
		jQuery(this).dequeue();
		return false;
	});

	return false;
});


//click on overflow button up
jQuery('body').on('click', '.overflow-button.up', function() {

	//hide button
	jQuery(this).hide();

	//decrease description height
	jQuery(this).parent().find('.description').css('height', '70px');

	//decrease list item height
	var this_list_item = jQuery(this).parent().parent().parent();
	this_list_item.css('height', '100px');

	//delete old and add new class to button
	jQuery(this).removeClass('up');
	jQuery(this).addClass('down');

	//show button
	jQuery(this).delay(400).queue(function() {
		jQuery(this).show();
		jQuery(this).dequeue();
		return false;
	});
	return false;
});

*/
