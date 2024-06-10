package com.jspiders.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springboot.pojo.User;
import com.jspiders.springboot.repository.UserRepository;

@Service
public class UserService {
    @Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		// TODO Auto-generated method stub
		
		if(user!=null) {
		return userRepository.save(user);
			
		}
		else {
			return null;
		}
	}

	public User findUserById(long id) {
		// TODO Auto-generated method stub
		Optional<User>optional=userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {	
			return null;
		}
		
	}

	public User findUserByEmailAndPassword(String email, String password) {
		User findEmailAndPassword = userRepository.findUserByEmailAndPassword(email, password);
		if (findEmailAndPassword!=null) {
			return findEmailAndPassword;

		}else {
			return null;
		}

		
	}

	public User findUserByMobileAndPassword(String mobile, String password) {
		
		Long mob =Long.valueOf(mobile);
	User findMobileAndPassword = userRepository.findUserByMobileAndPassword(mob, password);
		if (findMobileAndPassword!=null) {
			return findMobileAndPassword;

		}else {
			return null;
		}

		
	}
	
    
    
	
	
}
