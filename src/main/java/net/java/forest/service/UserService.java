package net.java.forest.service;

import net.java.forest.model.Userdata;
import net.java.forest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<Userdata> addUpdateUser(Userdata user){
        return userRepository.save(user);
    }

    public Flux<Userdata> getAllUser(){
        return userRepository.findAll();
    }

    /*public Mono<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }*/

    public Mono<Userdata> getUserById(long id){
        return userRepository.findById(id);
    }
}
