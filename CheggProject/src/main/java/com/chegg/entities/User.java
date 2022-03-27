package com.chegg.entities;

public class User {
	public User(String name, String email, String type, String id, String schoolName, String courseTaught) {
		super();
		this.name = name;
		this.email = email;
		this.type = type;
		this.id = id;
		this.schoolName = schoolName;
		this.courseTaught = courseTaught;
	}
	public User()
	{
		
	}
	/*public User(String name, String email, String schoolName) {
		
		this.name = name;
		this.email = email;
		this.schoolName = schoolName;
	}*/
	String name;
	String email;
	String type;
	String id;
	String schoolName;
	String courseTaught;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getCourseTaught() {
		return courseTaught;
	}
	public void setCourseTaught(String courseTaught) {
		this.courseTaught = courseTaught;
	}
}
