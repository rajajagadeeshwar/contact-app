package com.contactapp;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contactapp.model.Contact;
import com.contactapp.repository.ContactRepository;

@SpringBootApplication
public class ContactAppApplication {

	public static void main(String[] args) {

//		Contact contact = new Contact();
//		contact.setId(10);
//		contact.setName("jag");
//		contact.setPhonenumber("(514)707-3172");
//		contact.setBusinessnumber("(514)707-3172");
//		contact.setEmail("jagvankadari@gmail.com");

		boolean condition = false;
//		while(condition) {
//			System.out.println("Entered Loop");
//			condition = false;
//			System.out.println(condition);
//		}

//		do {
//			System.out.println("Entered Loop");
//			condition = false;
//			System.out.println(condition);
//			
//			
//		}while(condition);
		String option;
		do {
			System.out.println("choose an option");

			System.out.println("1: create menu contact");
			System.out.println("2: edit contact");
			System.out.println("3: list all contacts");
			System.out.println("4: exit");

			Scanner sc1 = new Scanner(System.in);
			option = sc1.nextLine();

			/*
			 * if(option.contentEquals("1")) { System.out.println("Opption 1 called"); }
			 * else if(option.contentEquals("2")) { System.out.println("Opption 2 called");
			 * } else if(option.contentEquals("3")) {
			 * System.out.println("Opption 3 called"); } else if(option.contentEquals("4"))
			 * { System.out.println("Opption 4 called"); } else {
			 * System.out.println("Unknown option called"); }
			 */

			switch (option) {
 
			case "1":
				getContactFromInput();
				
				break;
			case "2":
				System.out.println("Opption 2 called");
				break;
			case "3":
				System.out.println("Opption 3 called");
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

		
		//		Contact contact= getContactFromInput();
//		System.out.println(contact);
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
}
