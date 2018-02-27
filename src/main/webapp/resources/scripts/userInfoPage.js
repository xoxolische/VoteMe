

jQuery('#user-password').css('width', function(){
	var string = jQuery('#user-password').val();
	return string.length + 'em';
});


jQuery('#show-password-button').mousedown(function(){
	jQuery('#user-password').attr('type', 'text');
});

jQuery('#show-password-button').mouseup(function(){
	jQuery('#user-password').attr('type', 'password');
});

if (jQuery('#user-status').val() != 'verified'){
	jQuery('#verify-button').css('display', 'block');
}
