package com.websuppliercore.dao;

import java.util.List;

import com.websuppliercore.exceptions.ResourceNotFoundException;
import com.websuppliercore.model.User;

public interface UserDao {

	List<User> findAllUsers();

	User saveUser(User user);

	User findUserById(Long userId) throws ResourceNotFoundException;

	User updateUserDetails(Long userId) throws ResourceNotFoundException;

	void delete(User user);

}
