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
    public Long newOrganization(@RequestBody Organization body) {

        //ниже временный код для проверки работы метода saveOrganization()
        Organization organization = new Organization();
        organization.setOrgForm(body.getOrgForm());
        organization.setFullName(body.getFullName());
        organization.setShortName(body.getShortName());
        organization.setInn(body.getInn());
        organization.setKpp(body.getKpp());
        organization.setOgrn(body.getOgrn());
        organization.setOkpo(body.getOkpo());
        organization.setOkved(body.getOkved());
        organization.setShareCapital(body.getShareCapital());
        organization.setDescription(organization.getDescription());
        organization.setComment(organization.getComment());

        Long newOrganizationId = this.organizationService.saveOrganization(organization).getId();
        return newOrganizationId;
    }


    @PutMapping(path = "/v0/organizations")
    public boolean saveOrganization(@RequestBody Organization body) {

        //ниже временный код для проверки работы метода saveRequestLogRecord()
        Organization organization = new Organization();
        organization.setId(body.getId());
        organization.setOrgForm(body.getOrgForm());
        organization.setFullName(body.getFullName());
        organization.setShortName(body.getShortName());
        organization.setInn(body.getInn());
        organization.setKpp(body.getKpp());
        organization.setOgrn(body.getOgrn());
        organization.setOkpo(body.getOkpo());
        organization.setOkved(body.getOkved());
        organization.setShareCapital(body.getShareCapital());
        organization.setDescription(organization.getDescription());
        organization.setComment(organization.getComment());

        this.organizationService.saveOrganization(organization);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
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
