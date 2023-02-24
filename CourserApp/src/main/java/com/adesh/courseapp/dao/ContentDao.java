package com.adesh.courseapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.courseapp.entities.Content;

public interface ContentDao extends JpaRepository<Content, Integer> {

}
