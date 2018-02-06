package com.voteme.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.VersusMark;
import com.voteme.service.UserService;
import com.voteme.service.VersusMarkService;
import com.voteme.service.VersusService;

@Component
public class VersusMarkValidator implements Validator {

	@Autowired
	private VersusMarkService versusMarkService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VersusService versusService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return VersusMark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mark",
				"Mark should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "versus",
				"Versus should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user",
				"User should not be null or empty! Please, set a correct value.");

		VersusMark m = (VersusMark) target;
		
		if(m.getUser() != null && m.getVersus() != null) {
			//check if user exists
			if(userService.get(m.getUser().getId()) == null) {
				errors.rejectValue("user", "User with such id does not exists!");
			}
			//check if versus exists
			if(versusService.get(m.getVersus().getId()) == null) {
				errors.rejectValue("versus", "Versus with such id does not exists!");
			}
			//check if user didnt vote for this versus
			if(versusMarkService.userHasVote(m.getUser().getId(), m.getVersus().getId())) {
				errors.rejectValue("user", "This user already voted for this versus!");
			}
		}
		
	}

}
