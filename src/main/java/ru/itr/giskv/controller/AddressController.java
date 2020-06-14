package ru.itr.giskv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itr.giskv.model.Address;
import ru.itr.giskv.model.Organization;
import ru.itr.giskv.service.AddressService;
import ru.itr.giskv.service.OrganizationService;

import java.util.List;

@RestController
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.set("Access-Control-Allow-Origin", "*");
    }

    @GetMapping(path = "/v0/addresses")
    public List<Address> getAllAddresses() {
        List<Address> addressList = this.addressService.findAll();
        return addressList;
    }

    @PostMapping(path = "/v0/addresses")
    public Long newAddress(@RequestBody Address body) {

        //ниже временный код для проверки работы метода saveOrganization()
        Address address = new Address();
        address.setType(body.getType());
        address.setZipCode(body.getZipCode());
        address.setState(body.getState());
        address.setRegion(body.getRegion());
        address.setTown(body.getTown());
        address.setTownDistrict(body.getTownDistrict());
        address.setRegionDistrict(body.getRegionDistrict());
        address.setSettlement(body.getSettlement());
        address.setTerritory(body.getTerritory());
        address.setStreet(body.getStreet());
        address.setStructure(body.getStructure());
        address.setBuilding(body.getBuilding());
        address.setCorpus(body.getCorpus());
        address.setFlat(body.getFlat());
        address.setAddr(body.getAddr());


        Long newAddressId = this.addressService.saveAddress(address).getId();
        return newAddressId;
    }


    @PutMapping(path = "/v0/addresses")
    public boolean saveAddress(@RequestBody Address body) {

        //ниже временный код для проверки работы метода saveOrganization()
        Address address = new Address();
        address.setId(body.getId());
        address.setOrganizationId(body.getOrganizationId());
        address.setType(body.getType());
        address.setZipCode(body.getZipCode());
        address.setState(body.getState());
        address.setRegion(body.getRegion());
        address.setTown(body.getTown());
        address.setTownDistrict(body.getTownDistrict());
        address.setRegionDistrict(body.getRegionDistrict());
        address.setSettlement(body.getSettlement());
        address.setTerritory(body.getTerritory());
        address.setStreet(body.getStreet());
        address.setStructure(body.getStructure());
        address.setBuilding(body.getBuilding());
        address.setCorpus(body.getCorpus());
        address.setFlat(body.getFlat());
        address.setAddr(body.getAddr());

        this.addressService.saveAddress(address);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
    }


    @GetMapping(path = "/v0/addresses/{id}")
    public Address getAddressById(Long id) {
        return this.addressService.getAddressByID(id);
    }

    @DeleteMapping(path = "/v0/addresses/{id}")
    public boolean deleteAddressById(Long id) {
        Address address = getAddressById(id);
        this.addressService.deleteAddress(address);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
    }





}
