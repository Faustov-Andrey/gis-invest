package com.sbt.vap.controller;

import com.sbt.vap.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sbt.vap.service.OrganizationService;

import java.sql.Date;
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
    public ResponseEntity<List<Organization>> getAllRequestLogRecords() {
        List<Organization> organizationList = this.organizationService.findAll();
        return new ResponseEntity<>(organizationList, headers, HttpStatus.OK);
    }

    @PostMapping(path = "/v0/organizations")
    public Long newOrganization(@RequestBody Organization body) {

        //ниже временный код для проверки работы метода saveOrganization()
        Organization organization = new Organization();
        organization.setFullName(body.getFullName());
        organization.setShortName(body.getShortName());
        organization.setInn(body.getInn());
        organization.setKpp(body.getKpp());
        organization.setOgrn(body.getOgrn());
        organization.setOkpo(body.getOkpo());
        organization.setOkved(body.getOkved());
        organization.setLegalAddress(body.getLegalAddress());
        organization.setPostAddress(body.getPostAddress());
        organization.setDesignCompany(body.getDesignCompany());
        organization.setRrepresentativePersoneName(body.getRepresentativePersoneName());
        organization.setRepresentativePersoneInn(body.getRepresentativePersoneInn());
        organization.setRepresentativePersoneEmail(body.getRepresentativePersoneEmail());
        organization.setRepresentativePersonePhone(body.getRepresentativePersonePhone());
        organization.setFounderName(body.getFounderName());
        organization.setFounderInn(body.getFounderInn());
        organization.setBankAccountNumber(body.getBankAccountNumber());
        organization.setDescription(organization.getDescription());
        organization.setComment(organization.getComment());

        Long newOrganizationId = this.organizationService.saveOrganization(organization).getId();
        return newOrganizationId;
    }


    @PutMapping(path = "/v0/organizations")
    public boolean saveRequestLogRecord(@RequestBody Organization body) {

        //ниже временный код для проверки работы метода saveRequestLogRecord()
        Organization organization = new Organization();
        organization.setFullName(body.getFullName());
        organization.setShortName(body.getShortName());
        organization.setInn(body.getInn());
        organization.setKpp(body.getKpp());
        organization.setOgrn(body.getOgrn());
        organization.setOkpo(body.getOkpo());
        organization.setOkved(body.getOkved());
        organization.setLegalAddress(body.getLegalAddress());
        organization.setPostAddress(body.getPostAddress());
        organization.setDesignCompany(body.getDesignCompany());
        organization.setRrepresentativePersoneName(body.getRepresentativePersoneName());
        organization.setRepresentativePersoneInn(body.getRepresentativePersoneInn());
        organization.setRepresentativePersoneEmail(body.getRepresentativePersoneEmail());
        organization.setRepresentativePersonePhone(body.getRepresentativePersonePhone());
        organization.setFounderName(body.getFounderName());
        organization.setFounderInn(body.getFounderInn());
        organization.setBankAccountNumber(body.getBankAccountNumber());
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
    public boolean deleteRequestLogRecordById(Long id) {
        Organization organization = getOrganizationById(id);
        this.organizationService.deleteOrganization(organization);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
    }


}
