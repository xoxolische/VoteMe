package com.voteme.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.BugReport;
import com.voteme.model.VersusMark;

@Component
public class BugReportValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return VersusMark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
				"Description should not be null or empty! Please, set a correct value.");

		BugReport b = (BugReport) target;
		
		if(b != null) {
			if(b.getDescription() != null && b.getDescription().length() > 255) {
				errors.rejectValue("description", "Description must be less than 255 symbols!");
			}
		}
		
	}

}
