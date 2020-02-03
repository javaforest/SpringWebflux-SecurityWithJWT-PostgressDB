package net.java.forest.controller;

import net.java.forest.model.Userdata;
import net.java.forest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/alluser", method = RequestMethod.GET)
    public Flux<Userdata> getallUser(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public Mono<Userdata> addUser(){
       return  userService.addUpdateUser(new Userdata(null, "Mahade","hassan", "12345", "mahade.hasan68@gmail.com","Bd, Khustia", Arrays.asList("USER")));
    }
}
