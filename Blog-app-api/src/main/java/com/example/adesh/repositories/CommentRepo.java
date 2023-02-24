package com.example.adesh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adesh.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
