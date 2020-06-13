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
    public Long newOwner(@RequestBody OrganizationOwner body) {

        //ниже временный код для проверки работы метода saveOrganization()
        OrganizationOwner organizationOwner = new OrganizationOwner();
        organizationOwner.setOrganizationId(body.getOrganizationId());
        organizationOwner.setType(body.getType());
        organizationOwner.setSharesProportion(body.getSharesProportion());
        organizationOwner.setCapitalShares(body.getCapitalShares());
        organizationOwner.setOwnerOpf(body.getOwnerOpf());
        organizationOwner.setOwnerFullName(body.getOwnerFullName());
        organizationOwner.setInn(body.getInn());
        organizationOwner.setKpp(body.getKpp());
        organizationOwner.setOgrn(body.getOgrn());
        organizationOwner.setDirectorFullName(body.getDirectorFullName());
        organizationOwner.setBirthDate(body.getBirthDate());
        organizationOwner.setBirthPlace(body.getBirthPlace());
        organizationOwner.setCitizenship(body.getCitizenship());
        organizationOwner.setIdentificationDocument(body.getIdentificationDocument());
        organizationOwner.setResidenceRightDocument(body.getResidenceRightDocument());
        organizationOwner.setResidenceAddress(body.getResidenceAddress());
        organizationOwner.setContactType(body.getContactType());
        organizationOwner.setContactValue(body.getContactValue());
        organizationOwner.setBeneficialOwnerFlag(body.getBeneficialOwnerFlag());
        organizationOwner.setTaxResidentFlag(body.getTaxResidentFlag());



        Long newOwnerId = this.ownerService.saveOwner(organizationOwner).getId();
        return newOwnerId;
    }


    @PutMapping(path = "/v0/owners")
    public boolean saveRequestLogRecord(@RequestBody OrganizationOwner body) {

        OrganizationOwner organizationOwner = new OrganizationOwner();
        organizationOwner.setId(body.getId());
        organizationOwner.setOrganizationId(body.getOrganizationId());
        organizationOwner.setType(body.getType());
        organizationOwner.setSharesProportion(body.getSharesProportion());
        organizationOwner.setCapitalShares(body.getCapitalShares());
        organizationOwner.setOwnerOpf(body.getOwnerOpf());
        organizationOwner.setOwnerFullName(body.getOwnerFullName());
        organizationOwner.setInn(body.getInn());
        organizationOwner.setKpp(body.getKpp());
        organizationOwner.setOgrn(body.getOgrn());
        organizationOwner.setDirectorFullName(body.getDirectorFullName());
        organizationOwner.setBirthDate(body.getBirthDate());
        organizationOwner.setBirthPlace(body.getBirthPlace());
        organizationOwner.setCitizenship(body.getCitizenship());
        organizationOwner.setIdentificationDocument(body.getIdentificationDocument());
        organizationOwner.setResidenceRightDocument(body.getResidenceRightDocument());
        organizationOwner.setResidenceAddress(body.getResidenceAddress());
        organizationOwner.setContactType(body.getContactType());
        organizationOwner.setContactValue(body.getContactValue());
        organizationOwner.setBeneficialOwnerFlag(body.getBeneficialOwnerFlag());
        organizationOwner.setTaxResidentFlag(body.getTaxResidentFlag());

        this.ownerService.saveOwner(organizationOwner);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
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
