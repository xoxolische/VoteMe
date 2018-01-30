package com.voteme.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.OpinionMark;
import com.voteme.service.OpinionMarkService;
import com.voteme.service.OpinionService;
import com.voteme.service.UserService;

@Component
public class OpinionMarkValidator implements Validator {

	@Autowired
	private OpinionMarkService opinionMarkService;

	@Autowired
	private OpinionService opinionService;

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return OpinionMark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "opinion",
				"Opinion should not be null or empty! Please, set a correct value.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user",
				"User should not be null or empty! Please, set a correct value.");

		OpinionMark m = (OpinionMark) target;

		if (m.getUser() != null && m.getOpinion() != null) {
			if (userService.get(m.getUser().getId()) != null) {
				if (opinionService.get(m.getOpinion().getId()) != null) {
					// ValidationUtils.invokeValidator(new MarkValidator(), m, errors);
					if (m.getOpinion() != null && m.getUser() != null) {
						OpinionMark opMark = opinionMarkService.getBy(m.getUser().getId(), m.getOpinion().getId());

						if (opMark != null) {
							errors.rejectValue("opinion", "This user already voted for this opinion!");
						} else {
							OpinionMark opMarkCouple = opinionMarkService.getCouple(m.getUser().getId(),
									m.getOpinion().getId());
							if (opMarkCouple != null) {
								errors.rejectValue("opinion", "User already voted in this versus for another opinion!");
							}
						}
					}
				} else {
					errors.rejectValue("opinion", "Opinion with such id does not exist!");
				}
			} else {
				errors.rejectValue("user", "User with such id does not exist!");
			}
		}

	}

}
