package com.adesh.courseapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	private String email;
	
	@Column(name="Message",columnDefinition="LONGTEXT")
	private String message;
	
}
