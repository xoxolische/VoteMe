package com.voteme.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.voteme.model.CommentMark;
import com.voteme.service.CommentMarkService;
import com.voteme.service.CommentService;

@Component
public class CommentMarkValidator implements Validator {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentMarkService commentMarkService;

	@Override
	public boolean supports(Class<?> clazz) {
		return CommentMark.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mark", "Mark should not be null or empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "User should not be null or empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "Comment should not be null or empty!");

		CommentMark m = (CommentMark) target;

		if (m.getComment() != null && m.getUser() != null) {

			// if comment exists
			if (commentService.get(m.getComment().getId()) == null) {
				errors.rejectValue("comment", "Comment does not exists!");
			}
			// if user already voted
			if (commentMarkService.userHasVote(m.getUser().getId(), m.getComment().getId())) {
				errors.rejectValue("user", "You already voted for this comment!");
			}
		}

	}

}
