package com.contactapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.contactapp.controller.KeyboardDataInput;
import com.contactapp.model.Contact;
import com.contactapp.service.ContactService;

@SpringBootApplication
public class ContactAppApplication {

	static ContactService service;
	static KeyboardDataInput dataInput;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ContactAppApplication.class, args);

		service = context.getBean(ContactService.class);
		dataInput = context.getBean(KeyboardDataInput.class);

		String option;
		Scanner sc1 = new Scanner(System.in);

		do {
			System.out.println("choose an option");

			System.out.println("1: create menu contact");
			System.out.println("2: edit contact");
			System.out.println("3: list all contacts");
			System.out.println("4: find by id");
			System.out.println("5: remove the contact");
			System.out.println("6: exit");

			option = sc1.nextLine();
			switch (option) {

			case "1":
				Contact contact = dataInput.getContactFromKeyboard();
				service.createContact(contact);

				break;
			case "2":
				Contact contactToEdit = dataInput.editContact();
				service.editContact(contactToEdit);
				break;
			case "3":
				List<Contact> allContacts = service.findAll();

				// allContacts.forEach(element->System.out.println(element));
				allContacts.forEach(System.out::println);

				break;
			case "4":
				Long id = dataInput.getUserId();
				service.findById(id);
				break;
			case "5":
				Long idToRemove = dataInput.getUserId();
				service.removeContactById(idToRemove);
				break;
			case "6":
				System.out.println("Opption 6 called. Exiting.");
				break;

			default:

				System.out.println("no option");
				break;
			}

		} while (!option.equals("6"));

		System.out.println("loop exit");
		sc1.close();

	}

}
