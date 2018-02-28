package com.voteme.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.VersusMark;

@Component
public class CommentMarkValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return VersusMark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "c", "Message");

		VersusMark m = (VersusMark) target;

		if (true) {
			// check
			if (true) {
				errors.rejectValue("user", "User with such id does not exists!");
			}
			
			//if comment exists
			
			//if user exists
			
			//if user already voted
			

		}

	}

}
