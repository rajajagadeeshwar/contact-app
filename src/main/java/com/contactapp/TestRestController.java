package com.contactapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

	@RequestMapping("/testallo")
	public void anyMethod() {
		System.out.println("Hello world, testing spring");
	}
}
