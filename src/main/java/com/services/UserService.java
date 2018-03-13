package com.services;

import com.com.beans.response.UserResponse;
import com.model.SessionToken;
import com.model.User;
import com.repository.UserRepository;
import com.repository.UserRights;
import com.repository.UserToken;
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
        newUser.setRights(UserRights.USER);
        newUser.setEmail(user.getEmail());
        //newUser.setPassword(user.getPassword()); dont store passwords as plaintext
        UserToken token= new UserToken();
        newUser.setToken(token.generateToken(user.getName(), user.getPassword()));

        return repository.save(newUser);
    }

    public User updateUser(String id, User updateUserInfo) {
        User user = repository.findUserById(id);

        user.setName(updateUserInfo.getName());
        user.setRights(updateUserInfo.getRights());
        user.setEmail(updateUserInfo.getEmail());
        user.setPassword(updateUserInfo.getPassword());
        UserToken token= new UserToken();
        user.setToken(token.generateToken(user.getName(), user.getPassword()));

        return repository.save(user);
    }

    public void deleteUser(String id) {
        repository.delete(repository.findUserById(id));
    }

    public boolean checkIfUserExists(User user){
        Boolean areUserCredentialsGood = false;
        UserToken token = new UserToken();

        String hashcode = token.generateToken(user.getName(),user.getPassword());
        System.out.println(hashcode);
        if(repository.findUserByToken(hashcode)!=null){
            areUserCredentialsGood=true;
        }else{areUserCredentialsGood=false;}
            return areUserCredentialsGood;
    }

    public String createNewSessionToken(String name, String password) {
        SessionToken session = new SessionToken(name, password);
        return session.getSessionToken();
    }

}
