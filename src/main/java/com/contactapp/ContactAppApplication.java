package com.contactapp;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contactapp.model.Contact;
import com.contactapp.repository.ContactRepository;

@SpringBootApplication
public class ContactAppApplication {

	public static void main(String[] args) {

		Contact jag = new Contact();
		jag.setName("Jag");
		jag.setPhonenumber("123456");
		jag.setBusinessnumber("456789");
		jag.setEmail("email@jag.com");

		Contact evo = new Contact();
		evo.setName("Evo");
		evo.setPhonenumber("44444");
		evo.setBusinessnumber("555555");
		evo.setEmail("email@evo.com");

		Contact joe = new Contact();
		joe.setName("Joe");
		joe.setPhonenumber("9999999");
		joe.setBusinessnumber("8888888");
		joe.setEmail("email@joe.com");

		ContactRepository repository = new ContactRepository();
		repository.save(jag);
		repository.save(evo);
		repository.save(joe);

		String option;
		do {
			System.out.println("choose an option");

			System.out.println("1: create menu contact");
			System.out.println("2: edit contact");
			System.out.println("3: list all contacts");
			System.out.println("4: find by id");
			System.out.println("5: remove the contact");
			System.out.println("6: exit");

			Scanner sc1 = new Scanner(System.in);
			option = sc1.nextLine();
			switch (option) {

			case "1":
				getContactFromInput();

				break;
			case "2":
				editContact();
				break;
			case "3":
				listAllContacts();
				break;
			case "4":
				findById();
				break;
			case "5":
				removeContactById();
				break;
			case "6":
				System.out.println("Opption 6 called");
				break;

			default:

				System.out.println("no option");
				break;
			}

		} while (!option.equals("6"));

		System.out.println("loop exit");

	}

	public static Contact getContactFromInput() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Input your name:");
		String name = sc.nextLine();

		System.out.println("Input your phone number:");
		String phoneNumber = sc.nextLine();

		System.out.println("Input your business number:");
		String businessNumber = sc.nextLine();

		System.out.println("Input your email:");
		String email = sc.nextLine();

		Contact contact = new Contact();
		contact.setName(name);
		contact.setPhonenumber(phoneNumber);
		contact.setBusinessnumber(businessNumber);
		contact.setEmail(email);

		ContactRepository repository = new ContactRepository();
		repository.save(contact);

		return contact;

	}

	public static void listAllContacts() {

		ContactRepository repository = new ContactRepository();
		List<Contact> contacts = repository.findAll();

		for (Contact contact : contacts) {

			System.out.println(contact);
			System.out.println();
		}
	}

	public static void findById() {

		System.out.println("Input user id");
		Scanner sc = new Scanner(System.in);

		Long id = sc.nextLong();

		ContactRepository repository = new ContactRepository();
		Contact contact = repository.findById(id);

		if (Objects.nonNull(contact)) {
			System.out.println("Contact found");
			System.out.println(contact.toString());

		} else {
			System.out.println("Contact not found.");
		}

	}

	public static void editContact() {

		System.out.println("Input user id");
		Scanner sc = new Scanner(System.in);
		Long id = sc.nextLong();
		sc.nextLine();
		ContactRepository repository = new ContactRepository();

		Contact contact = repository.findById(id);

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

	public static void removeContactById() {

		System.out.println("Enter the id to remove");
		Scanner sc = new Scanner(System.in);
		Long id = sc.nextLong();
		sc.nextLine();
		ContactRepository repository = new ContactRepository();
		repository.removeContact(id);

	}

}
