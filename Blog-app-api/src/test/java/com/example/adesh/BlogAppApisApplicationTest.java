package com.example.adesh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.adesh.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTest {
	
	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
		
	}
	@Test
	public void repoTest() {
		String className=this.userRepo.getClass().getName();
		String packName=this.userRepo.getClass().getPackageName();
		System.out.print(className);
		System.out.print(packName);
		
	}
	

}
