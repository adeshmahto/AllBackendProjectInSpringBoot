package com.adesh.courseapp.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.courseapp.dao.CourseDaoo;
import com.adesh.courseapp.entities.Course;
import com.adesh.courseapp.exception.ResourceNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDaoo courseDao;
	
	@Override
	public List<Course> getCourses() {
	   
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(Integer courseId) {
		Course entity=this.courseDao.findById(courseId).orElseThrow(()->new ResourceNotFoundException(null, null, 0));
		return entity;
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(Integer parsLong) {
		Course entity=courseDao.getOne(parsLong);
		courseDao.delete(entity);
		
	}
	

	
}
