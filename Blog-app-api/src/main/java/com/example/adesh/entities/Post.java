package com.example.adesh.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.adesh.payloads.CommentDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name="post_title",length=100,nullable=false)
	private String title;
	
	@Column(length=10000)
	private String content;
	
	private String imageName;
	
	private Date addDate;
	
	//fk
	
	@ManyToOne    // many post in one category
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne// one user can have multiple postt
	private User user;
	
	@OneToMany(mappedBy="post")     //one post has multiple comment
	private Set<Comment> comments=new HashSet<>();
	
	
	
	
	
	
	

}
