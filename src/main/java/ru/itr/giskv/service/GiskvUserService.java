package ru.itr.giskv.service;

import ru.itr.giskv.model.GiskvUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itr.giskv.repository.GiskvUserRepo;

import java.util.List;

@Service
public class GiskvUserService {

    @Autowired
    private GiskvUserRepo giskvUserRepo;

    public GiskvUser saveUser(final GiskvUser giskvUser) {
        GiskvUser user = this.giskvUserRepo.saveAndFlush(giskvUser);
        return user;
    }

    public List<GiskvUser> findAll() {
        return this.giskvUserRepo.findAll();
    }

    public GiskvUser getUserByID(final long id){
        return this.giskvUserRepo.getOne(id);
    }

    public void deleteUser(final GiskvUser giskvUser){
        this.giskvUserRepo.delete(giskvUser);
    }

}