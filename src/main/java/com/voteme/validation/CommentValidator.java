package com.voteme.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.Comment;
import com.voteme.model.Versus;
import com.voteme.service.UserService;
import com.voteme.service.VersusService;

@Component
public class CommentValidator implements Validator {

//	@Autowired
//	private CommentService commentService;
	
	@Autowired 
	private VersusService versusService;
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Versus.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text",
				"Text should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "versus",
				"Versus should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author",
				"Author should not be null or empty! Please, set a correct value.");

		Comment c = (Comment) target;

		if(c.getAuthor() != null && c.getText() != null && c.getVersus() != null) {
			if (c.getText().length() > 255) {
				errors.rejectValue("text", "Text length must be less or equals 255 symbols.");
			}
			if (userService.get(c.getAuthor().getId()) == null) {
				errors.rejectValue("author", "User with such id does not exists!");
			}
			
			if (versusService.get(c.getVersus().getId()) == null) {
				errors.rejectValue("versus", "Versus with such id does not exists!");
			}
		}
	}

}
