package ru.itr.giskv.controller;

import ru.itr.giskv.model.GiskvUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.itr.giskv.service.GiskvUserService;

import java.util.List;

@RestController
@CrossOrigin
public class GiskvUserController {

    @Autowired
    private GiskvUserService giskvUserService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.set("Access-Control-Allow-Origin", "*");
    }

    @GetMapping(path = "/v0/users")
    public List<GiskvUser> getAllUsers() {
        List<GiskvUser> giskvUserList = this.giskvUserService.findAll();
        return giskvUserList;
    }


    @PostMapping(path = "/v0/users")
    public GiskvUser newUser(@RequestBody GiskvUser body) {

        GiskvUser giskvUser = this.giskvUserService.saveUser(body);

        return giskvUser;
    }

    @PutMapping(path = "/v0/users")
    public GiskvUser saveUser(@RequestBody GiskvUser body) {

        GiskvUser giskvUser = this.giskvUserService.saveUser(body);
        return giskvUser;
    }

    @GetMapping(path = "/v0/users/{id}")
    public GiskvUser getUserById(long id) {
        return this.giskvUserService.getUserByID(id);
    }


    @DeleteMapping(path = "/v0/users/{id}")
    public boolean deleteUserById(long id) {
        GiskvUser giskvUser = getUserById(id);
        this.giskvUserService.deleteUser(giskvUser);
        return true;
    }

}
