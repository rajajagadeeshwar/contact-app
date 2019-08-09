package com.contactapp;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.contactapp.service.ContactService;

@SpringBootApplication
public class ContactAppApplication {

	static ContactService service;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ContactAppApplication.class, args);

		service = context.getBean(ContactService.class);

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
				service.createContact();
				break;
			case "2":
				service.editContact();
				break;
			case "3":
				service.listAllContacts();
				break;
			case "4":
				service.findById();
				break;
			case "5":
				service.removeContactById();
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

	}

}
