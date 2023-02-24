package com.adesh.courseapp.services;

import java.util.List;

import com.adesh.courseapp.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	
	public Course getCourse(Integer courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(Integer parsLong);
	
	

}
