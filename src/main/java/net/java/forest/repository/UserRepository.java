package net.java.forest.repository;

import net.java.forest.model.Userdata;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Userdata, Long> {
    @Query("select * from userdata where email = :email")
    Mono<Userdata> findByEmail(String email);
}
