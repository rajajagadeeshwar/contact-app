package com.contactapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contactapp.model.Contact;

@SpringBootApplication
public class ContactAppApplication {

	public static void main(String[] args) {
		
		Contact contact= new Contact();
		contact.setId(10);
		contact.setName("jag");
		contact.setPhonenumber("(514)707-3172");
		contact.setBusinessnumber("(514)707-3172");
		contact.setEmail("jagvankadari@gmail.com");
		
		System.out.println(contact.toString());
		
//		SpringApplication.run(ContactAppApplication.class, args);
//		int k = 1;
//		int j = 2;
//		sum(k,j);
	}

	
	public static int sum(Integer a, Integer b) {
		return a + b;
	}
}
