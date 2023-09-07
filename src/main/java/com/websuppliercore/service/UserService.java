package com.websuppliercore.service;

import java.util.List;

import com.websuppliercore.exceptions.ResourceNotFoundException;
import com.websuppliercore.model.User;

public interface UserService {

	List<User> findAllUsers();

	User saveUser(User user);

	User findUserById(Long userId) throws ResourceNotFoundException;

	User updateUser(Long userId) throws ResourceNotFoundException;

	void delete(User user);

}
