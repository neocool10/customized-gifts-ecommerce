package com.virtusa.springapp.model;

public class JwtResponse {

    private String userRole;
    private int userId;
    private String jwtToken;

    public JwtResponse(String userRole,int userId, String jwtToken) {
        this.userRole = userRole;
        this.userId = userId;
        this.jwtToken = jwtToken;
    }
    
    public JwtResponse() {
    	
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUser(String userRole) {
        this.userRole = userRole;
    }

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
