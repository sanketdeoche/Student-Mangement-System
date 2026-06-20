package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.interfaces.CourseService;

@RestController

public class CourseController {

	@Autowired
	CourseService cs;

	@PostMapping("admin/createcourse")
	ResponseEntity<String> addCourse(@RequestBody Course course) {
		cs.addCourse(course);
		return new ResponseEntity<String>("course created", HttpStatus.CREATED);

	}

	@GetMapping("course/{id}")
	ResponseEntity<Course> getCourse(@PathVariable int id) {
		Course course = cs.getCourse(id);
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
 
	@GetMapping("courses")
	ResponseEntity <List<Course>> getallcourse() {
		List<Course> allCourse = cs.getAllCourse();
		return new ResponseEntity<>(allCourse, HttpStatus.OK);

	}

	@DeleteMapping("admin /course/{id}")
	ResponseEntity<String> deleteCourse(@PathVariable int id) {
		cs.deleteCourse(id);
		return new ResponseEntity<String>("course deleted", HttpStatus.OK);
	}

	@PatchMapping("admin/course/{id}/{name}")
	ResponseEntity<String> updateCourse(@PathVariable int id, @PathVariable String name) {
		cs.updateCourse(id, name);
		return new ResponseEntity<String>("course updated", HttpStatus.OK);
	}
	
	
	@PutMapping("admin/course/{id}")
	ResponseEntity<String> updateCoursedetails(@PathVariable int id, @RequestBody Course course) {
		cs.updateCourseDetails(id, course);
		return new ResponseEntity<String>("course updated", HttpStatus.OK);
		
	}
	
	

}
