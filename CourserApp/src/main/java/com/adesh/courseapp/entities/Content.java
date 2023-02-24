package com.adesh.courseapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Content {
	
	@Id
	private Integer id;
	
	private String title;
	
	@Column(name="description",columnDefinition="LONGTEXT")
	private String description;
	
	private String imageName;
	

}
