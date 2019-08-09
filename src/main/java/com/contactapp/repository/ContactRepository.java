package com.contactapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contactapp.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	
}
