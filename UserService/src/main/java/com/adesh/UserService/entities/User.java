package com.adesh.UserService.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="micro_users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@Column(name="Id")
	private String userId;
	@Column(name="Name",length=20)
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="About")
	private String about;
	
	//rating for hotel
	
	@Transient // when we dont want to store it in dB;
	private List<Rating> ratings=new ArrayList<>();
	
	

}
