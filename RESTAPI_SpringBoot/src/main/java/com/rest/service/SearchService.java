package com.chegg.service;

import java.util.ArrayList;
import java.util.List;

import com.chegg.controllers.SearchController;
import com.chegg.entities.User;

public class SearchService {
	private static SearchService searchServiceObj = null;

	public List<User> searchStudentInSchool(String schoolName) {
		UserServiceImpl userregd = UserServiceImpl.getInstance();
		List<User> allusers = userregd.getUsers();
		List<User> students = new ArrayList<User>();
		for (User user : allusers) {
			if (user.getType().equals("Student") && user.getSchoolName().equals(schoolName)) {
				students.add(user);
			}
		}
		return students;
	}

	public User findStudent(String id) {
		UserServiceImpl userregd = UserServiceImpl.getInstance();
		User user = userregd.getUser(id);
		if (user == null)
			return null;
		if (user.getType().equals("Student")) {
			return user;
		} else {
			return null;
		}
	}

	public User findProfessor(String id) {
		UserServiceImpl userregd = UserServiceImpl.getInstance();
		User user = userregd.getUser(id);
		if (user == null)
			return null;
		if (user.getType().equals("Professor")) {
			return user;
		} else {
			return null;
		}
	}

	public List<User> searchProfessorInSchool(String schoolName) {
		UserServiceImpl userregd = UserServiceImpl.getInstance();
		List<User> allusers = userregd.getUsers();
		List<User> professors = new ArrayList<User>();
		for (User user : allusers) {
			if (user.getType().equals("Professor") && user.getSchoolName().equals(schoolName)) {
				professors.add(user);
			}
		}
		return professors;
	}

	public List<User> searchProfessorInCourse(String courseName) {
		UserServiceImpl userregd = UserServiceImpl.getInstance();
		List<User> allusers = userregd.getUsers();
		List<User> professors = new ArrayList<User>();
		for (User user : allusers) {
			if (user.getType().equals("Professor") && user.getCourseTaught().equals(courseName)) {
				professors.add(user);
			}
		}
		return professors;
	}

	public static SearchService getInstance() {
		if (searchServiceObj == null) {
			searchServiceObj=new SearchService();
			return searchServiceObj;
		} else {
			return searchServiceObj;
		}
	}
}
