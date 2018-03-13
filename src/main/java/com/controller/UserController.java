package com.controller;

import com.com.beans.response.LoginResponse;
import com.com.beans.response.UserResponse;
import com.model.SessionToken;
import com.model.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/")
public class UserController {

    @Autowired
    private UserService service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserResponse> getAllUsers() {
        return service.getAllUsers();
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public UserResponse addUser(@Valid @RequestBody User user) {
        return new UserResponse(service.addNewUser(user));
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public LoginResponse login(@Valid @RequestBody User user){
        if(service.checkIfUserExists(user)) {
            String sessionId=service.createNewSessionToken(user.getName(), user.getPassword());
            //service.storeNewSeasion(sessionId, user);
            return new LoginResponse(sessionId,user);
        }
        return new LoginResponse();
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public UserResponse updateUser(@Valid @RequestBody User user, @PathVariable("id") String id) {
        return new UserResponse(service.updateUser(id, user));
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") String id) {
        service.deleteUser(id);
    }

}