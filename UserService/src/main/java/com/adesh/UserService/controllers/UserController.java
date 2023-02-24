package com.adesh.UserService.controllers;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adesh.UserService.entities.User;
import com.adesh.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private  UserService userService;
	
	//create    // requestBody is used to convert the json formate data to User datatype
	@PostMapping
	public ResponseEntity<User>createUser(@RequestBody User user){
		User user1=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	int retryCount=1;
	//single user get
	@GetMapping("/{userId}")
	//@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//	@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="  userRateLimiter",fallbackMethod = "ratingHotelFallback")

	public ResponseEntity<User>getUserById(@PathVariable String userId){
		System.out.println("retry count"+ retryCount++);
		User user=this.userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	//creating fall back method for circuitfallbackMethod
	
	public ResponseEntity<User>ratingHotelFallback(String userId,Exception ex){
		
//			System.out.println("fallback is executed :"+ex.getMessage());
		
			User user=new User();
			user.setName("dummy");
			user.setAbout("the user is created");
			user.setEmail("adeshmahto@gmail.com");
			user.setUserId(userId);
			 
		return new ResponseEntity<User>((user),HttpStatus.OK);
	}

	
	
	//all
	@GetMapping
	public ResponseEntity<List<User>>getAll(){
		
		List<User> list=this.userService.getAllUser();
		return ResponseEntity.ok(list);
		
	}
	

}
