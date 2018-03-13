package com.repository;

import com.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String>{

    List<User> findAll();
    User findUserById(String id);
    String findUserByToken(String token);
}
