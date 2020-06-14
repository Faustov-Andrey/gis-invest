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

    @GetMapping(path = "/get-roles")
    public List<Role> getAllRoles() {
        List<Role> roleList = this.roleService.findAll();
        return roleList;
    }

    @GetMapping(path = "/new-role")
    public boolean newRole(String name, String description, String comment) {

        //ниже временный код для проверки работы метода saveRole()
        Role role = new Role();

        role.setName(name);
        role.setDescription(description);
        role.setComment(comment);

        this.roleService.saveRole(role);
        return true;
    }

    @GetMapping(path = "/save-role")
    public boolean saveRole(long id, String name, String description, String comment) {

        //Сделать парсинг request-а, выбрать из него атрибуры и засетить их в поля объекта
        //ниже временный код для проверки работы метода saveRole()
        Role role = new Role();
        role.setId(id);
        role.setName(name);
        role.setDescription(description);
        role.setComment(comment);

        this.roleService.saveRole(role);
        return true;
    }

    @GetMapping(path = "/get-role-by-id")
    public Role getRoleById(long id) {
        return this.roleService.getRoleByID(id);
    }

    @GetMapping(path = "/delete-role-by-id")
    public boolean deleteRoleById(long id) {
        Role role = getRoleById(id);
        this.roleService.deleteRole(role);
        return true;
    }


}
