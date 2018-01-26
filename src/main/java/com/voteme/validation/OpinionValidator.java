package com.voteme.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.Opinion;

public class OpinionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Opinion.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text",
				"Text should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "versus",
				"Versus should not be null or empty! Please, set a correct value.");
		
		Opinion o = (Opinion) target;

		if (o.getText().length() > 255) {
			errors.rejectValue("text", "Text length must be less or equals 255 symbols.");
		}
	}

}
