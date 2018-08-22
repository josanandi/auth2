package com.greenfoxacademy.auth2.repository;

import com.greenfoxacademy.auth2.models.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {


    boolean existsByEmail(String email);

    User findUserByEmail(String email);
}
