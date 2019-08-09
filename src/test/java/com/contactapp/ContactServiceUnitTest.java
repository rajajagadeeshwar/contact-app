package com.contactapp;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.contactapp.service.ContactService;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceUnitTest {
	
	@InjectMocks
	private ContactService contactService;
	
	
	
	@Test
	public void nothing() {
		String formattedNumber = contactService.formatPhoneNumber("1234567890");
		
		Assert.assertThat(formattedNumber, Matchers.is("(123)456-7890"));

	}
}
