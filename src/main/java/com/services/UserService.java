package com.services;

import com.com.beans.response.UserResponse;
import com.model.User;
import com.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponse> getAllUsers() {
        return repository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public User addNewUser(@Valid User user) {
        User newUser = new User();

        newUser.setId(new ObjectId());
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail());

        return repository.save(newUser);
    }

    public User updateUser(String id, User updateUserInfo) {
        User user = repository.findUserById(id);

        user.setName(updateUserInfo.getName());
        user.setAge(updateUserInfo.getAge());
        user.setEmail(updateUserInfo.getEmail());

        return repository.save(user);
    }

    public void deleteUser(String id) {
        repository.delete(repository.findUserById(id));
    }
}
