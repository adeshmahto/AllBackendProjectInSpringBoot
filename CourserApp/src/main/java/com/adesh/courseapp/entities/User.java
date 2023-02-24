package com.adesh.courseapp.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy ="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	List<Order> orders=new ArrayList<>();
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns= @JoinColumn(name="user",referencedColumnName ="id"),
	inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id")
	)
	private Set<Role> roles=new HashSet<>();


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	 
		List<SimpleGrantedAuthority> authorities=this.roles.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authorities;

		

	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

	
	
	
	
}
