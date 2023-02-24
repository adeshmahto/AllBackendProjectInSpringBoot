package com.adesh.courseapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {
	
	@Id
	private Integer id;
	
	private String title;
	@Column(name="description" , columnDefinition = "LONGTEXT") // not null
	private String description;
	

	
}
