package com.company.user_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSystemApplication.class, args);
		System.out.println(".");
		//It's necessary to manage dependencies in a better way
		//You have to decide to use either jdbc or hibernate and how to articulate it to jpa or whatever we have here
	}
}
