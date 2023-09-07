package com.websuppliercore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.websuppliercore.exceptions.ResourceNotFoundException;
import com.websuppliercore.model.User;
import com.websuppliercore.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}

	@PostMapping("/addUser")
	public User addUser(@Validated @RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userService.findUserById(userId);
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/user-update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Validated @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userService.updateUser(userId);

		user.setEmailId(userDetails.getEmailId());
		user.setLastName(userDetails.getLastName());
		user.setFirstName(userDetails.getFirstName());
		final User updatedEmployee = userService.saveUser(user);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/user-delete/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
         throws ResourceNotFoundException {
		User user = userService.findUserById(userId);
		userService.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
