package com.sbt.vap.service;

import com.sbt.vap.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbt.vap.repository.RoleRepo;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public void saveRole(final Role role) { this.roleRepo.saveAndFlush(role); }

    public List<Role> findAll() {
        return this.roleRepo.findAll();
    }

    public Role getRoleByID(final long id){
        return this.roleRepo.getOne(id);
    }

    public void deleteRole(final Role role){
        this.roleRepo.delete(role);
    }

}
