package net.java.forest.controller;


import lombok.extern.slf4j.Slf4j;
import net.java.forest.model.LoginRequest;
import net.java.forest.model.LoginResponse;
import net.java.forest.model.Userdata;
import net.java.forest.security.CustomEncoder;
import net.java.forest.service.UserService;
import net.java.forest.utils.JWTUtil;
import net.java.forest.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@Validated
public class LoginSignup {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private CustomEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private UtilService util;

	/**
	 * Login request endpoint
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Mono<ResponseEntity<?>> login(@RequestBody LoginRequest request) {
        return userService.findByUsername(request.getUsername()).map((userDetails) -> {
            if (passwordEncoder.encode(request.getPassword()).equals(userDetails.getPassword())) {
                return ResponseEntity.ok(new LoginResponse(jwtUtil.generateToken(userDetails)));
            } else {
                log.info("password not matching");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

	/**
	 * Signup endpoint
	 * @param user
	 * @return
	 */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Mono<ResponseEntity<?>> createPerson(@RequestBody Userdata user) {
        String message = util.validation(user);
       // String message ="";
        if (message.isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return Mono.just(ResponseEntity.ok(userService.addUpdateUser(user)));
        } else {
            return Mono.just(ResponseEntity.badRequest().body(message));
        }
    }
}
