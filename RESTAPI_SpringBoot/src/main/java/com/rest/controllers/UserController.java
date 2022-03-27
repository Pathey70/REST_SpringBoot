package com.chegg.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.chegg.entities.User;
import com.chegg.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
		boolean result = UserServiceImpl.getInstance().deleteUser(id);
		if (result) {
			return new ResponseEntity<String>("Success id:" + result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllStudents() {
		List<User> result = UserServiceImpl.getInstance().getUsers();
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable("id") String id) {
		UserServiceImpl regObj = UserServiceImpl.getInstance();
		User user = regObj.getUser(id);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/")
	public ResponseEntity<String> registerUser(@RequestBody User user) {

		String result = UserServiceImpl.getInstance().add(user);
		if (!result.equals("error")) {
			return new ResponseEntity<String>("Success id:" + result, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable String id) {

		boolean result = UserServiceImpl.getInstance().updateUser(id, user);
		if (result) {
			return new ResponseEntity<String>("successful", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("ID not found", HttpStatus.NOT_FOUND);
		}
	}
}