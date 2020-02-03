package net.java.forest.controller;


import net.java.forest.model.Userdata;
import net.java.forest.security.JWTUtil;
import net.java.forest.security.PBKDF2Encoder;
import net.java.forest.security.model.AuthRequest;
import net.java.forest.security.model.AuthResponse;
import net.java.forest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.awt.print.Book;
import java.net.URI;

@RestController
@Validated
public class AuthenticationREST {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PBKDF2Encoder passwordEncoder;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest ar) {
		return userService.findByUsername(ar.getUsername()).map((userDetails) -> {
			if (ar.getPassword().equals(userDetails.getPassword())) {
			//if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	/*@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public Mono<ServerResponse> signUp(ServerRequest request) {


	}*/

}
