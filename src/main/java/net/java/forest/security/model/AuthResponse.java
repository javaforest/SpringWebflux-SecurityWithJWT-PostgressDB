package net.java.forest.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class AuthResponse {
	
	private String token;

	public AuthResponse(String token) {
		this.token = token;
	}

	public AuthResponse() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AuthResponse{" +
				"token='" + token + '\'' +
				'}';
	}
}
