package net.java.forest.controller;

import net.java.forest.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;


@RestController
public class ResourceREST {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Mono<ResponseEntity<?>> publicUser(Principal principal) {
		return Mono.just(ResponseEntity.ok(new Message(principal.toString())));
	}
	
	@RequestMapping(value = "/resource/user", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public Mono<ResponseEntity<?>> user(Principal principal) {
		return Mono.just(ResponseEntity.ok(new Message(principal.toString())));
	}
	
	@RequestMapping(value = "/resource/admin", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public Mono<ResponseEntity<?>> admin() {
		return Mono.just(ResponseEntity.ok(new Message("Content for admin")));
	}
	
	@RequestMapping(value = "/resource/user-or-admin", method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Mono<ResponseEntity<?>> userOrAdmin() {
		return Mono.just(ResponseEntity.ok(new Message("Content for user or admin")));
	}
}
