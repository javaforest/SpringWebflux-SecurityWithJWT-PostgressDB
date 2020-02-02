package net.java.forest.repository;

import net.java.forest.model.Userdata;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Userdata, Long> {
    /*@Query("Select * from user where user.email=")
    Mono<User> findByEmail(String email);*/
}
