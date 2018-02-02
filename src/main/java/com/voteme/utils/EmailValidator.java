package com.voteme.utils;

import java.util.regex.Pattern;

public class EmailValidator {

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@"
			+ "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	public static boolean validate(String email) {
		return true;
//		if (email == null)
//			return false;
//
//		Matcher matcher = EMAIL_PATTERN.matcher(email);
//		return matcher.matches();
	}
}