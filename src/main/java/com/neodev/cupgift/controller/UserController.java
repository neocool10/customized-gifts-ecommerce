package com.neodev.cupgift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neodev.cupgift.model.User;
import com.neodev.cupgift.service.UserServiceImpl;
import com.neodev.cupgift.tempmodel.TempUser;


@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping({"/signup"})
    public User registerNewUser(@RequestBody TempUser newUser) {
    	User user = new User();
		user.setEmail(newUser.getEmail());
		user.setMobileNumber(newUser.getMobileNumber());
		user.setUsername(newUser.getUsername());
		user.setUserRole(newUser.getUserRole());
        return userService.registerNewUser(user);
    }
    
    @GetMapping("/superAdmin/getAllUsers")
    @PreAuthorize("hasRole('SuperAdmin')")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
    
    @GetMapping("/superAdmin/getUser/{id}")
    @PreAuthorize("hasRole('SuperAdmin')")
	public User getUser(@PathVariable(name="id") Integer id) throws NullPointerException{
		
    	User user = null;
		try {
			user=userService.getById(id);
		}
		catch(Exception e) {
			throw new NullPointerException("User not found!");
		}
		return user;
	}
    
    @DeleteMapping("/superAdmin/deleteUser/{id}")
    @PreAuthorize("hasRole('SuperAdmin')")
	public String deleteUser(@PathVariable(name="id") Integer id) {
		return userService.deleteUser(id);
	}
    
    @PutMapping("/superAdmin/editUser/{id}")
    @PreAuthorize("hasRole('SuperAdmin')")
	public String editUser(@RequestBody TempUser newUser, @PathVariable(name="id") Integer id) {
		User user = userService.getById(id);
		user.setEmail(newUser.getEmail());
		user.setMobileNumber(newUser.getMobileNumber());
		user.setUsername(newUser.getUsername());
		user.setUserRole(newUser.getUserRole());
		
		userService.saveUser(user);
		return("User edited successfully");
	}
    
    @PostMapping("/superAdmin/addUser")
    @PreAuthorize("hasRole('SuperAdmin')")
	public String addUser(@RequestBody TempUser newUser) {
    	User user = new User();
		user.setEmail(newUser.getEmail());
		user.setMobileNumber(newUser.getMobileNumber());
		user.setUsername(newUser.getUsername());
		user.setUserRole(newUser.getUserRole());
		
		userService.registerNewUser(user);
		return "User added successfully";
	} 
}
