package com.adesh.coding30min.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adesh.coding30min.entities.Doc;

public interface DocRepository extends JpaRepository<Doc, Integer> {
	

}
