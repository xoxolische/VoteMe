package com.voteme.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.VersusMark;

@Component
public class VersusMarkValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return VersusMark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "versus",
				"Versus should not be null or empty! Please, set a correct value.");

		VersusMark m = (VersusMark) target;

		//ValidationUtils.invokeValidator(new MarkValidator(), m, errors);
	}

}
