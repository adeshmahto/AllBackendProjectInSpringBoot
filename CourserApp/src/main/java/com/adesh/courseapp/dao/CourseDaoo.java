package com.adesh.courseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.courseapp.entities.Course;

//Long is primary key Id
public interface CourseDaoo extends JpaRepository<Course, Integer> {
	
	

}
