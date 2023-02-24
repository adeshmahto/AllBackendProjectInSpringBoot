package com.example.adesh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.adesh.entities.Category;
import com.example.adesh.entities.Post;
import com.example.adesh.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
	
	
	//custom method
	List<Post> findByUser(User user);
	List<Post> findByCategory( Category category);
	
	@Query("select p from Post p where p.title like :key")
	List<Post> searchByTitleContaining(@Param("key")String title);                           
	
	

}
