package com.neodev.cupgift.controller;

import com.neodev.cupgift.model.JwtResponse;
import com.neodev.cupgift.model.Login;
import com.neodev.cupgift.model.User;
import com.neodev.cupgift.service.JwtService;
import com.neodev.cupgift.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {
	
	@Autowired
	private UserServiceImpl userService;

    @Autowired
    private JwtService jwtService;
	
    @PostMapping({"/login"})
    public JwtResponse createJwtToken(@RequestBody Login data) throws NullPointerException {
        return jwtService.createJwtToken(data);
    }

	@PostMapping({"/isAdmin"})
	public boolean isAdminPresent(@RequestBody String email) {
		User user = userService.findUserByEmail(email);
		return user != null && user.getUserRole().equals("Admin");
	}
	@PostMapping({"/isUser"})
	public boolean isUserPresent(@RequestBody String email) {
		User user = userService.findUserByEmail(email);
		return (user != null && user.getUserRole().equals("User"));
	}
	@PostMapping({"/isSuperAdmin"})
	public boolean isSuperAdminPresent(@RequestBody String email) {
		User user = userService.findUserByEmail(email);
		return (user != null && user.getUserRole().equals("SuperAdmin"));
	}
}
