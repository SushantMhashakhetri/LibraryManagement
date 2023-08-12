package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Entities.User;
import com.library.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
  
	@GetMapping("/{userId}")
	ResponseEntity<Optional<User>> getUser(@PathVariable Long userId){
	  return ResponseEntity.ofNullable(this.userService.getUser(userId));
  }
	
	@GetMapping
	ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ofNullable(this.userService.getAllUser());
	}
	
	@PostMapping("/save")
	ResponseEntity<User> saveUser(@RequestBody User user){
		return ResponseEntity.ofNullable(this.userService.saveUser(user));
	}

}
