package com.controller;

import com.com.beans.response.UserResponse;
import com.model.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;


    // GET
    @RequestMapping(value = "/")
    public List<UserResponse> getAllUsers() {
        return service.getAllUsers();
    }


    // POST
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UserResponse addPost(@Valid @RequestBody User user) {
        return new UserResponse(service.addNewUser(user));
    }


    // PUT
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public UserResponse updateUser(@Valid @RequestBody User user, @PathVariable("id") String id) {
        return new UserResponse(service.updateUser(id, user));
    }


    // DELETE
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable("id") String id) {
        service.deleteUser(id);
    }

}