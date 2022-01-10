/**
 * 
 */
package com.example.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.controllers.BookDataAcitvityPerform;
import com.example.models.Book;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@RestController
@RequestMapping


public class Auth {

	/**
	 * 
	 */
	public Auth() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "name") String name, @RequestParam(name = "password") String pass) {

		String username = "Deepak";
		String Password = "Pass";
		System.out.print(name);

		if (pass.equals(Password) && username.equals(name)) {
			return "user logged in successfully";
		} else {
			return "user log in failed";
		}
	}

	@GetMapping(path = "/addUser/{id}/{name}/{desc}")
	public void addUser(@PathVariable String id, @PathVariable String name, @PathVariable String desc) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/example/config/config.xml");

		BookDataAcitvityPerform bean = applicationContext.getBean("bookDataPerform", BookDataAcitvityPerform.class);       

		Book login = new Book(id, name, desc);

		int InsertedId = bean.insert(login);
		System.out.println("INSERTED ID+++" + InsertedId);
	}

	@GetMapping("/getAllUsers")
	public List<Book> getAllUsers() {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/example/config/config.xml");
		BookDataAcitvityPerform bean = applicationContext.getBean("bookDataPerform", BookDataAcitvityPerform.class);
		List<Book> data = bean.getAll();
		return data;
	}

}
