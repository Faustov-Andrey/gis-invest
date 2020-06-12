package com.sbt.vap.service;

import com.sbt.vap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbt.vap.repository.UserRepo;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveUser(final User user) {
        this.userRepo.saveAndFlush(user);
    }

    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    public User getUserByID(final long id){
        return this.userRepo.getOne(id);
    }

    public void deleteUser(final User user){
        this.userRepo.delete(user);
    }

}