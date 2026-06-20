package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.entity.Course;

public interface CourseService {

	public void addCourse(Course course);

	public Course getCourse(int id);

	public List<Course> getAllCourse();

	public void deleteCourse(int id);
	
	public void updateCourse(int id, String name);
	
	public void updateCourseDetails(int id, Course c);
}
