
package com.adesh.reservation.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@Table(name="reservation")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer Id;
   private String user_name;
   private String  email;
   private String phoneno;
   private String checkIn;
   private String checkOut;
   
   
}
