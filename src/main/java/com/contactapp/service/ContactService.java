package com.contactapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public List<Contact> findAll() {

		List<Contact> contacts = new ArrayList<>();
		repository.findAll().forEach(contacts::add);

		return contacts;
	}

	public void findById(Long id) {

		Contact contact = repository.findById(id).orElse(null);

		if (Objects.nonNull(contact)) {
			System.out.println("Contact found");
			System.out.println(contact.toString());

		} else {
			System.out.println("Contact not found.");
		}

	}

	public Contact editContact(Contact contactToEdit) {

		Contact existingContact = repository.findById(contactToEdit.getId()).orElse(null);
		if (Objects.isNull(existingContact)) {
			System.out.println("Contact not found");
			throw new IllegalArgumentException("Contact not found");
		}

		validator.validatePhoneNumberLength(contactToEdit.getPhonenumber());
		validator.validateDigits(contactToEdit.getPhonenumber());
		validator.validateEmail(contactToEdit.getEmail());

		String formattedPhoneNumber = formatter.formatPhoneNumber(contactToEdit.getPhonenumber());
		contactToEdit.setPhonenumber(formattedPhoneNumber);

		return repository.save(contactToEdit);

	}

	public void removeContactById(Long id) {

		repository.deleteById(id);

	}

	public Contact createContact(Contact contact) {
		validator.validatePhoneNumberLength(contact.getPhonenumber());
		validator.validateDigits(contact.getPhonenumber());
		validator.validateEmail(contact.getEmail());

		String formattedPhoneNumber = formatter.formatPhoneNumber(contact.getPhonenumber());
		contact.setPhonenumber(formattedPhoneNumber);

		return repository.save(contact);
	}

}
