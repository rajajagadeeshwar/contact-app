package com.contactapp.util;

import org.springframework.stereotype.Component;

@Component
public class Validator {

	public void validatePhoneNumberLength(String phoneNumber) {

		if (phoneNumber.length() != 10) {

			throw new IllegalArgumentException("not equals to 10");

		}

	}

	public void validateDigits(String phoneNumber) {
		if (!phoneNumber.matches("[0-9]+")) {
			throw new IllegalArgumentException("Not a valid digits");

		}
	}

	public void validateEmail(String email) {

		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (!email.matches(regex)) {
			throw new IllegalArgumentException("not a valid email");

		}
	}

}
