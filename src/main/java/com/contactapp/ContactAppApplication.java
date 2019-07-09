package com.contactapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contactapp.model.Contact;
import com.contactapp.repository.ContactRepository;

@SpringBootApplication
public class ContactAppApplication {

	public static void main(String[] args) {

		String option;
		do {
			System.out.println("choose an option");

			System.out.println("1: create menu contact");
			System.out.println("2: edit contact");
			System.out.println("3: list all contacts");
			System.out.println("4: exit");

			Scanner sc1 = new Scanner(System.in);
			option = sc1.nextLine();
			switch (option) {
 
			case "1":
				getContactFromInput();
				
				break;
			case "2":
				System.out.println("Opption 2 called");
				break;
			case "3":
				listAllContacts();
				break;
			case "4":
				System.out.println("Opption 4 called");
				break;

			default:

				System.out.println("no option");
				break;
			}

		} while (!option.equals("4"));

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
	
	
	public static void  listAllContacts() {
		
		ContactRepository repository = new ContactRepository();
		List<Contact> contacts= repository.findAll();
		
		for (Contact contact: contacts) {
			
			System.out.println(contact);
			System.out.println();
		}
				
		
	}
}
