package com.voteme.validation;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.dao.UserDao;
import com.voteme.model.User;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserDao userDao;

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
		try {
			InternetAddress emailAddr = new InternetAddress(u.getEmail());
			emailAddr.validate();
		} catch (Exception e) {
			errors.rejectValue("email", "Email is invalid!");
		}
		if (userDao.userExists(u.getEmail())) {
			errors.rejectValue("email", "User with such email already exists.");
		}
		// if (u.getEmail()) { email problem here
		// errors.rejectValue("email", "Email is invalid!");
		// }

		if (u.getPassword().length() > 255) {
			errors.rejectValue("password", "Password length must be less or equals 255 symbols.");
		}
		if (u.getNickName().length() > 255) {
			errors.rejectValue("nickName", "nickName length must be less or equals 255 symbols.");
		}
	}

}
