package com.contactapp.util;

import org.springframework.stereotype.Component;

@Component
public class Formatter {

	public String formatPhoneNumber(String rawNumber) {
		return rawNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3");
	}

}
