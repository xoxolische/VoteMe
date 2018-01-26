package com.voteme.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"Email should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName",
				"nickName should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"Password should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role",
				"Role should not be null or empty! Please, set a correct value.");

		User u = (User) target;

		if (u.getEmail().length() > 255) {
			errors.rejectValue("email", "Email length must be less or equals 255 symbols.");
		}
		if (u.getPassword().length() > 255) {
			errors.rejectValue("password", "Password length must be less or equals 255 symbols.");
		}
		if (u.getNickName().length() > 255) {
			errors.rejectValue("nickName", "nickName length must be less or equals 255 symbols.");
		}
	}

}
