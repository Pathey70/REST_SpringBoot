package com.chegg.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


import com.chegg.entities.User;

public class UserServiceImpl {
	private static HashMap<String, User> userRecords;

	private static UserServiceImpl userregd = null;

	private static long idCounter;

	private UserServiceImpl() {
		userRecords = new HashMap<String, User>();
		idCounter = 0;
	}

	public static UserServiceImpl getInstance() {

		if (userregd == null) {
			userregd = new UserServiceImpl();
			return userregd;
		} else {
			return userregd;
		}
	}

	public String add(User user) {
		try {
			idCounter++;
			user.setId(Long.toString(idCounter));
			userRecords.put(Long.toString(idCounter), user);
			return Long.toString(idCounter);
		} catch (Exception e) {
			System.out.println(e);
			return "Error bad Object type";
		}
	}

	public boolean updateUser(String id, User user) {
		try {
			
			if (userRecords.containsKey(id)) {
				user.setId(id);
				userRecords.put(id, user);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public boolean deleteUser(String id) {
		if (userRecords.containsKey(id)) {
			userRecords.remove(id);
			return true;
		} else {
			return false;
		}
	}

	public User getUser(String id) {
		if (userRecords.containsKey(id)) {
			return userRecords.get(id);
		} else {
			return null;
		}
	}

	public List<User> getUsers() {
		Collection values = userRecords.values();
		List<User> listOfUsers = new ArrayList<User>(values);
		return listOfUsers;
	}
}
