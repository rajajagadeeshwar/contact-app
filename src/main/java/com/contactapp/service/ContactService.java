package com.contactapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactapp.model.Contact;
import com.contactapp.repository.ContactRepository;
import com.contactapp.util.Formatter;
import com.contactapp.util.Validator;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;

	@Autowired
	private Formatter formatter;

	@Autowired
	private Validator validator;

	public void listAllContacts() {

		List<Contact> contacts = new ArrayList<>();
		repository.findAll().forEach(contacts::add);

		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}

	public void findById() {

		System.out.println("Input user id");
		Scanner sc = new Scanner(System.in);

		Long id = sc.nextLong();

		Contact contact = repository.findById(id).orElse(null);

		if (Objects.nonNull(contact)) {
			System.out.println("Contact found");
			System.out.println(contact.toString());

		} else {
			System.out.println("Contact not found.");
		}

	}

	public void editContact() {

		System.out.println("Input user id");
		Scanner sc = new Scanner(System.in);
		Long id = sc.nextLong();
		sc.nextLine();

		Contact contact = repository.findById(id).orElse(null);

		System.out.println("Input the new name:");
		String name = sc.nextLine();

		System.out.println("Input the new phone number:");
		String phoneNumber = sc.nextLine();

		System.out.println("Input the new business number:");
		String businessNumber = sc.nextLine();

		System.out.println("Input the new email:");
		String email = sc.nextLine();

		contact.setName(name);
		contact.setPhonenumber(phoneNumber);
		contact.setBusinessnumber(businessNumber);
		contact.setEmail(email);

	}

	public void removeContactById() {

		System.out.println("Enter the id to remove");
		Scanner sc = new Scanner(System.in);
		Long id = sc.nextLong();
		sc.nextLine();
		repository.deleteById(id);

	}

	public Contact createContact() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input your name:");
		String name = sc.nextLine();
		name = name.toUpperCase();

		System.out.println("Input your phone number:");
		String phoneNumber = sc.nextLine();

		validator.validatePhoneNumberLength(phoneNumber);

		validator.validateDigits(phoneNumber);

		phoneNumber = formatter.formatPhoneNumber(phoneNumber);

		System.out.println(phoneNumber);

		System.out.println("Input your business number:");
		String businessNumber = sc.nextLine();

		System.out.println("Input your email:");
		String email = sc.nextLine();

		validator.validateEmail(email);

		Contact contact = new Contact();
		contact.setName(name);
		contact.setPhonenumber(phoneNumber);
		contact.setBusinessnumber(businessNumber);
		contact.setEmail(email);

		repository.save(contact);

		return contact;

	}

}
