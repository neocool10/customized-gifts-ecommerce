package com.neodev.cupgift.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neodev.cupgift.model.User;
import com.neodev.cupgift.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceInterface{

	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User registerNewUser(User user) {
        user.setPassword(getEncodedPassword(user.getPassword()));
        return userRepository.save(user);
    }
    public void saveUser(User user) {
    	userRepository.save(user);
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
    
    public List<User> getAllUsers(){
    	return userRepository.findAll();
    	
	}
    
    public User getById(Integer id){
        Optional<User> u = userRepository.findById(id);
        if(u.isPresent())
        	return u.get();
        else
        	return null;
    }
    
    public String deleteUser(Integer id) {
    	userRepository.deleteById(id);
    	return "User deleted successfully";
    }
}
