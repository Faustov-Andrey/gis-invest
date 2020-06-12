package com.sbt.vap.controller;

import com.sbt.vap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbt.vap.service.UserService;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private User user;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        //headers.set("Access-Control-Allow-Origin", "*");
    }

    @GetMapping(path = "/get-users")
    public List<User> getAllUsers() {
        List<User> userList = this.userService.findAll();
        return userList;
    }


    @GetMapping(path = "/new-user")
    public boolean newUser(String lastName, String firstName, String fathersName, String personalNamber, String comment, String login, String pwd) {

        //ниже временный код для проверки работы метода saveUser()
        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setFathersName(fathersName);
        user.setPersonalNumber(personalNamber);
        user.setComment(comment);
        user.setLogin(login);
        user.setPwd(pwd);

        this.userService.saveUser(user);
        return true;
    }

    @GetMapping(path = "/save-user")
    public boolean saveUser(long id, String lastName, String firstName, String fathersName, String personalNamber, String comment, String login, String pwd) {

        //ниже временный код для проверки работы метода saveUser()
        User user = new User();
        user.setId(id);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setFathersName(fathersName);
        user.setPersonalNumber(personalNamber);
        user.setComment(comment);
        user.setLogin(login);
        user.setPwd(pwd);

        this.userService.saveUser(user);
        return true;
    }

    @GetMapping(path = "/get-user-by-id")
    public User getUserById(long id) {
        return this.userService.getUserByID(id);
    }


    @GetMapping(path = "/delete-user-by-id")
    public boolean deleteUserById(long id) {
        User user = getUserById(id);
        this.userService.deleteUser(user);
        return true;
    }

}
