package com.adesh.Hotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="hotels")
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;
	private Integer price;

}
