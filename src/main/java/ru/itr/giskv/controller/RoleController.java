package ru.itr.giskv.controller;

import ru.itr.giskv.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.itr.giskv.service.RoleService;

import java.util.List;

@RestController
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.set("Access-Control-Allow-Origin", "*");
    }

    @GetMapping(path = "/v0/roles")
    public List<Role> getAllRoles() {
        List<Role> roleList = this.roleService.findAll();
        return roleList;
    }

    @PostMapping(path = "/v0/roles")
    public Role newRole(@RequestBody Role body) {


        Role role = this.roleService.saveRole(body);
        return role;
    }

    @PutMapping(path = "/v0/roles")
    public Role saveRole(@RequestBody Role body) {

        Role role = this.roleService.saveRole(body);
        return role;
    }

    @GetMapping(path = "/v0/roles/{id}")
    public Role getRoleById(long id) {
        return this.roleService.getRoleByID(id);
    }

    @DeleteMapping(path = "/v0/roles/{id}")
    public boolean deleteRoleById(long id) {
        Role role = getRoleById(id);
        this.roleService.deleteRole(role);
        return true;
    }


}
