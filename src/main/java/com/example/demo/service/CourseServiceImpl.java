package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.exception.CourseServiceException;
import com.example.demo.interfaces.CourseService;
import com.example.demo.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository cr;

	@Override
	public void addCourse(Course course) {
		if (cr.existsByCoursename(course.getCoursename())) {
			throw new CourseServiceException("Course is already present", HttpStatus.CONFLICT);
		}
		cr.save(course);
	}

	@Override
	public Course getCourse(int id) {
		if (cr.findById(id).isPresent()) {
			return cr.findById(id).get();
		}
		throw new CourseServiceException("Invalid Entry!!!", HttpStatus.NOT_FOUND);

	}

	@Override
	public List<Course> getAllCourse() {
		List<Course> all = cr.findAll();
		if (all.isEmpty()) {
			throw new CourseServiceException("Course not found", HttpStatus.NOT_FOUND);
		}
		return cr.findAll();
	}

	@Override
	public void deleteCourse(int id) {
		if (cr.findById(id).isEmpty()) {
			throw new CourseServiceException("Course not found", HttpStatus.NOT_FOUND);
		}
		cr.deleteById(id);

	}

	@Override
	public void updateCourse(int id, String name) {
		if (cr.findById(id).isEmpty()) {
			throw new CourseServiceException("please select the correct id", HttpStatus.BAD_REQUEST);
		}
		Course course = cr.findById(id).get();
		course.setCoursename(name);
		cr.save(course);
	}
	

	@Override
	public void updateCourseDetails(int id, Course c) {
		if (cr.findById(id).isEmpty()) {
			throw new CourseServiceException("please select the correct id", HttpStatus.BAD_REQUEST);
		}
		Course course = cr.findById(id).get();
		course.setCourseDuration(c.getCourseDuration());
		course.setCoursename(c.getCoursename());
		course.setStatus(c.getStatus());
		course.setVideoRecording(c.getVideoRecording());
		cr.save(course);
		
	}

	
	

}
