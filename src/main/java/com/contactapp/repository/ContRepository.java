package com.contactapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.contactapp.model.Contact;

public interface ContRepository extends CrudRepository<Contact, Long> {

}
