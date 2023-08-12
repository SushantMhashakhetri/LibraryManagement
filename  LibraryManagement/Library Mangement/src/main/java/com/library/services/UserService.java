package com.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.Entities.User;
import com.library.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUser(){
		return this.userRepo.findAll();
	}
	
	public User saveUser(User user) {
		return this.userRepo.save(user);
	}
	
	public Optional<User> getUser(Long userId) {
		return this.userRepo.findById(userId);
	}

}
