package com.adesh.springframwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	

	public static void main(String[] args) {
		
		//dependency injection
		
	 // getBean() can be use throgh two interfaces 1 Beanfactory or ApplicationContext
		
		
//		
//		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
//		
//		Vechile obj=(Vechile)context.getBean("vechile");
//		
//		//creat xml file to read the data we want 
//		
//		obj.drive();
		
		ApplicationContext factory=new AnnotationConfigApplicationContext(AppConfig.class);
		
		
	 Samsung s= factory.getBean(Samsung.class);
	 s.config();
	
//		
		
		
		
		
	}

}
