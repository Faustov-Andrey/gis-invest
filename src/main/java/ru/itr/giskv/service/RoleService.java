package ru.itr.giskv.service;

import ru.itr.giskv.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itr.giskv.repository.RoleRepo;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role saveRole(final Role role) { return this.roleRepo.saveAndFlush(role); }

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
