package ru.itr.giskv.controller;

import ru.itr.giskv.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itr.giskv.service.OrganizationService;

import java.util.List;

@RestController
@CrossOrigin
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.set("Access-Control-Allow-Origin", "*");
    }

    @GetMapping(path = "/v0/organizations")
    public List<Organization> getAllOrganizations() {
        List<Organization> organizationList = this.organizationService.findAll();
        return organizationList;
    }

    @PostMapping(path = "/v0/organizations")
    public Organization newOrganization(@RequestBody Organization body) {

        Organization organization = this.organizationService.saveOrganization(body);

        return organization;
    }


    @PutMapping(path = "/v0/organizations")
    public Organization saveOrganization(@RequestBody Organization body) {

        Organization org = this.organizationService.saveOrganization(body);

        return org;
    }


    @GetMapping(path = "/v0/organizations/{id}")
    public Organization getOrganizationById(Long id) {
        return this.organizationService.getOrganizationByID(id);
    }

    @DeleteMapping(path = "/v0/organizations/{id}")
    public boolean deleteOrganizationById(Long id) {
        Organization organization = getOrganizationById(id);
        this.organizationService.deleteOrganization(organization);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
    }


}
