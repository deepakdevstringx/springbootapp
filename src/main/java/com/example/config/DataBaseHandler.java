package com.example.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.controllers.UserDatabaseControler;

public class DataBaseHandler {

	private static DataBaseHandler baseHandler = null;
	private static UserDatabaseControler controler;

	@SuppressWarnings("resource")
	public static DataBaseHandler getInstance() {
		if (baseHandler == null) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"com/example/config/config.xml");
			controler = context.getBean("UserDatabaseControler", UserDatabaseControler.class);
			baseHandler = new DataBaseHandler();
		}
		return baseHandler;
	}

	public UserDatabaseControler getControler() {
		return controler;
	}
}
