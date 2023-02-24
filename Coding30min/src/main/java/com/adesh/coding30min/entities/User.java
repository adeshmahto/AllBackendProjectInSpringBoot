package com.adesh.coding30min.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="user")
@NoArgsConstructor
public class User {
	
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
     
     private String name;
     
     private String email;
     
     private String password;

}
