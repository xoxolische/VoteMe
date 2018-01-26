package com.voteme.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.Mark;

public class MarkValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Mark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mark",
				"Mark should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user",
				"User should not be null or empty! Please, set a correct value.");
	}

}
