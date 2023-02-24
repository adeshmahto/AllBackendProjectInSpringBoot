package com.adesh.courseapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adesh.courseapp.entities.Course;
import com.adesh.courseapp.services.CourseService;


@RestController
public class MyController {
	
     //dependency injection
	@Autowired
	private CourseService courseService;
	
	//get the 
	
	
	@CrossOrigin
	@GetMapping("/courses")
	public ResponseEntity <List<Course>>getCourses(){
		this.courseService.getCourses();
		return new ResponseEntity<List<Course>>(this.courseService.getCourses(),HttpStatus.OK);
	}
	//single courses get
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") Integer courseId) {
		return this.courseService.getCourse(courseId);
	}
	
	//add course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
		
	}
	
	//update
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
		
	}
	
	//Delete
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus>deleteCourse(@PathVariable Integer courseId ){
		try {
			this.courseService.deleteCourse(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
