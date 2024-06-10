package com.jspiders.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springboot.pojo.Product;
import com.jspiders.springboot.pojo.User;
import com.jspiders.springboot.response.ResponseStructure;
import com.jspiders.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/user")
	public ResponseStructure<User> addUser(@RequestBody User user) {
		User addedUser = userService.addUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (addedUser != null) {
			responseStructure.setMessage("USER ADDED");
			responseStructure.setHttpStatus(HttpStatus.CREATED);
			responseStructure.setHttpStatusCode(HttpStatus.CREATED.value());
			responseStructure.setData(addedUser);
		} else {
			responseStructure.setMessage("USER NOT ADDED");
			responseStructure.setHttpStatus(HttpStatus.BAD_REQUEST);
			responseStructure.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setData(addedUser);
		}

		return responseStructure;

	}

	@GetMapping(path = "/user/email")
	public ResponseStructure<User> findUserByEmailAndPassword(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		User findUserByEmailAndPassword = userService.findUserByEmailAndPassword(email, password);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (findUserByEmailAndPassword != null) {
			responseStructure.setMessage("USER FOUND");
			responseStructure.setHttpStatus(HttpStatus.FOUND);
			responseStructure.setHttpStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData (findUserByEmailAndPassword);

		} else {
			responseStructure.setMessage("USER NOT FOUND");
			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND);
			responseStructure.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(findUserByEmailAndPassword);
		}

		return responseStructure;

	}

	@GetMapping(path = "/user/mobile")
	public  ResponseStructure<User>  findUserByMobileAndPassword(@RequestParam(name = "mobile") String mobile,
			@RequestParam(name = "password") String password) {
		User findUserByMobileAndPassword = userService.findUserByMobileAndPassword(mobile, password);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (findUserByMobileAndPassword != null) {
			responseStructure.setMessage("USER FOUND");
			responseStructure.setHttpStatus(HttpStatus.FOUND);
			responseStructure.setHttpStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(findUserByMobileAndPassword);

		} else {
			responseStructure.setMessage("USER NOT FOUND");
			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND);
			responseStructure.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setData( findUserByMobileAndPassword);
		}

		return responseStructure;

	}

}
