package com.voteme.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.Opinion;
import com.voteme.model.Versus;

public class VersusValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Versus.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"Title should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"Description should not be null or empty! Please, set a correct value.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author",
//				"Author should not be null or empty! Please, set a correct value.");
		
		Versus v = (Versus) target;

		if (v.getTitle().length() > 255) {
			errors.rejectValue("title", "Title length must be less or equals 255 symbols.");
		}
		if (v.getDescription().length() > 255) {
			errors.rejectValue("description", "Description length must be less or equals 255 symbols.");
		}

		int i = 0;
		for (Opinion o : v.getOpinions()) {
			errors.pushNestedPath("opinions[" + i + "]");
			ValidationUtils.invokeValidator(new OpinionValidator(), o, errors);
			errors.popNestedPath();
			i++;
		}
	}

}
