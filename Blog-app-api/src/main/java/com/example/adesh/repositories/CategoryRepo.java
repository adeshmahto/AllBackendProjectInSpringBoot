package com.example.adesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adesh.entities.Category;


public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
