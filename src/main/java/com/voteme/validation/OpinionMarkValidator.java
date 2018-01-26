package com.voteme.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.OpinionMark;

public class OpinionMarkValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OpinionMark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "opinion",
				"Opinion should not be null or empty! Please, set a correct value.");

		OpinionMark m = (OpinionMark) target;

		ValidationUtils.invokeValidator(new MarkValidator(), m, errors);

	}

}
