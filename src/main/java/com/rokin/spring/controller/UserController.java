package com.rokin.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rokin.spring.model.User;
import com.rokin.spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping()
	public List<User> getAllUsers() {
		return this.userService.getAll();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") String userId) {
		return this.userService.getById(userId);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") String userId, @RequestBody User user) {
		return this.userService.update(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") String userId, @RequestBody User user) {
		this.userService.delete(user);
	}
	
	
}
