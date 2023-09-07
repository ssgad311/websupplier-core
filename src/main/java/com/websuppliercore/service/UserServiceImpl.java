package com.websuppliercore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websuppliercore.dao.UserDao;
import com.websuppliercore.exceptions.ResourceNotFoundException;
import com.websuppliercore.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public User findUserById(Long userId) throws ResourceNotFoundException {
		return userDao.findUserById(userId);
	}

	@Override
	public User updateUser(Long userId) throws ResourceNotFoundException {
		return userDao.updateUserDetails(userId);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

}
