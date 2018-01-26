package com.voteme.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.Versus;

public class VersusValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Versus.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "Title should not be null or empty! Please, set a correct value.");
		
		Versus v = (Versus) target;
		
		if(v.getTitle().length() > 10) {
			errors.rejectValue("title", "Title length must be less or equals 10 symbols.");
		}
	}

}
