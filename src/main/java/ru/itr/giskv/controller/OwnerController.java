package ru.itr.giskv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itr.giskv.model.OrganizationOwner;
import ru.itr.giskv.service.OwnerService;

import java.util.List;

@RestController
@CrossOrigin
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.set("Access-Control-Allow-Origin", "*");
    }

    @GetMapping(path = "/v0/owners")
    public List<OrganizationOwner> getAllOwners() {
        List<OrganizationOwner> organizationOwnerList = this.ownerService.findAll();
        return organizationOwnerList;
    }

    @PostMapping(path = "/v0/owners")
    public OrganizationOwner newOwner(@RequestBody OrganizationOwner body) {

        OrganizationOwner organizationOwner = this.ownerService.saveOwner(body);
        return organizationOwner;
    }


    @PutMapping(path = "/v0/owners")
    public OrganizationOwner saveOwner(@RequestBody OrganizationOwner body) {

        OrganizationOwner organizationOwner = this.ownerService.saveOwner(body);
        //возвращать true если созранение прошло успешно и false при сбое
        return organizationOwner;
    }


    @GetMapping(path = "/v0/owners/{id}")
    public OrganizationOwner getOwnerById(Long id) {
        return this.ownerService.getOwnerByID(id);
    }

    @DeleteMapping(path = "/v0/owners/{id}")
    public boolean deleteOwnerById(Long id) {
        OrganizationOwner organizationOwner = getOwnerById(id);
        this.ownerService.deleteOwner(organizationOwner);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
    }






}
