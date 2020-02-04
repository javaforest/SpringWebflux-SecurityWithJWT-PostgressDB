package net.java.forest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;


@RestController
public class UserResource {

	/**
	 * Endpoint for all user
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Mono<ResponseEntity<?>> publicUser(Principal principal) {
		return Mono.just(ResponseEntity.ok(principal.toString()));
	}

	/**
	 * Authorized endpoint for 'USER' type user
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/resource/user", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public Mono<ResponseEntity<?>> user(Principal principal) {
		return Mono.just(ResponseEntity.ok(principal.toString()));
	}
}
