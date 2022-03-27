package com.chegg.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chegg.entities.User;
import com.chegg.service.SearchService;

@RestController
@RequestMapping("/find")
public class SearchController {
	@GetMapping("/students/{school}")
	@ResponseBody
	public ResponseEntity<List<User>> getStudents(@PathVariable("school") String school) {
		SearchService service = SearchService.getInstance();
		List<User> result=service.searchStudentInSchool(school);
		return new ResponseEntity<List<User>>(result,HttpStatus.OK);
		
	}
	
	@GetMapping("/professors/{school}")
	@ResponseBody
	public ResponseEntity<List<User>> getProfessors(@PathVariable("school") String school) {
		SearchService service = SearchService.getInstance();
		List<User> result=service.searchProfessorInSchool(school);
		return new ResponseEntity<List<User>>(result,HttpStatus.OK);
		
	}
	
	@GetMapping("/professors/course/{course}")
	@ResponseBody
	public ResponseEntity<List<User>> getProfessorsCourse(@PathVariable("course") String course) {
		SearchService service = SearchService.getInstance();
		List<User> result=service.searchProfessorInCourse(course);
		return new ResponseEntity<List<User>>(result,HttpStatus.OK);
		
	}
	@GetMapping("/student/{id}")
	@ResponseBody
	public ResponseEntity<User> getStudentsFromId(@PathVariable("id") String id) {
		SearchService service = SearchService.getInstance();
		User result=service.findStudent(id);
		return new ResponseEntity<User>(result,HttpStatus.OK);
		
	}
	@GetMapping("/professor/{id}")
	@ResponseBody
	public ResponseEntity<User> getProfessorsFromId(@PathVariable("id") String id) {
		SearchService service = SearchService.getInstance();
		User result=service.findProfessor(id);
		return new ResponseEntity<User>(result,HttpStatus.OK);
		
	}

}
