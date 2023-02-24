package com.adesh.springframwork.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="USER_TBL")

public class User {
	
	@Id
	private int id;
	private String userName;
	private String password;
	private String email;
	

}
