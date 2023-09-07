package com.websuppliercore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websuppliercore.exceptions.ResourceNotFoundException;
import com.websuppliercore.model.User;
import com.websuppliercore.repo.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findUserById(Long userId) throws ResourceNotFoundException {
		return userRepository.findById(userId)
		          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));
	}

	@Override
	public User updateUserDetails(Long userId) throws ResourceNotFoundException {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}
	
}
