package com.example.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.DataBaseHandler;
import com.example.models.Login;
import com.example.models.User;

@RestController
public class Employee {

	DataBaseHandler dataBaseHandler = DataBaseHandler.getInstance();
	org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
	private String TAG = "unable to save specimen";
	private String ERROR_TAG = "ERROR";

	@PostMapping(path = { "/register" })
	public String addUser(@RequestBody User user) {
		try {
			dataBaseHandler.getControler().insert(user);
			return "Inserted successfully.";
		} catch (Exception e) {
			log.error(TAG, e);
			e.printStackTrace();
			return ERROR_TAG;
		}
	}

	@PostMapping(path = { "/login" })
	public String getUser(@RequestBody Login login) {
		try {
			User data = dataBaseHandler.getControler().getUserData(login.getEmail(), login.getPassword());
			return data != null ? "Login successfully." : "Invalid Login Credentials.";
		} catch (Exception e) {
			log.error(TAG, e);
			e.printStackTrace();
			return ERROR_TAG;
		}

	}

	@PutMapping(path = { "/updateUser" })
	public String updateUser(@RequestBody User user) {
		try {
			int data = dataBaseHandler.getControler().update(user);
			return data != 0 ? "Record Updated successfully." : "Invalid id.";
		} catch (Exception e) {
			log.error(TAG, e);
			e.printStackTrace();
			return ERROR_TAG;
		}

	}

	@GetMapping(path = { "/getall" })
	public List<User> getAllUser() {
		try {
			List<User> data = dataBaseHandler.getControler().getAll();
			return data;
		} catch (Exception e) {
			log.error(TAG, e);
			e.printStackTrace();
			return new ArrayList<User>();
		}

	}

	@PostMapping(path = { "/deleteuser" })
	public String deleteUser(@RequestBody int id) {
		try {
			int data = dataBaseHandler.getControler().delete(id);
			return data != 0 ? "Deleted successfully." : "Invalid ID.";
		} catch (Exception e) {
			log.error(TAG, e);
			e.printStackTrace();
			return ERROR_TAG;
		}

	}
}
