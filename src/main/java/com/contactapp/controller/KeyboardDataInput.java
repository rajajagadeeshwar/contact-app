package com.contactapp.controller;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.contactapp.model.Contact;

@Component
public class KeyboardDataInput {

	
	public Contact getContactFromKeyboard() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Input your name:");
		String name = sc.nextLine();
		name = name.toUpperCase();

		System.out.println("Input your phone number:");
		String phoneNumber = sc.nextLine();

		System.out.println(phoneNumber);

		System.out.println("Input your business number:");
		String businessNumber = sc.nextLine();

		System.out.println("Input your email:");
		String email = sc.nextLine();

		Contact contact = new Contact();
		contact.setName(name);
		contact.setPhonenumber(phoneNumber);
		contact.setBusinessnumber(businessNumber);
		contact.setEmail(email);

		sc.close();

		return contact;
	}

	public Contact editContact() {

		System.out.println("Input user id");
		Scanner sc = new Scanner(System.in);
		Long id = sc.nextLong();
		sc.nextLine();

		System.out.println("Input the new name:");
		String name = sc.nextLine();

		System.out.println("Input the new phone number:");
		String phoneNumber = sc.nextLine();

		System.out.println("Input the new business number:");
		String businessNumber = sc.nextLine();

		System.out.println("Input the new email:");
		String email = sc.nextLine();

		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setPhonenumber(phoneNumber);
		contact.setBusinessnumber(businessNumber);
		contact.setEmail(email);

		sc.close();
		return contact;
	}

	public Long getUserId() {

		System.out.println("Input user id");
		Scanner sc = new Scanner(System.in);

		Long id = sc.nextLong();

		sc.close();
		return id;
	}
}
