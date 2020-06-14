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
    public Address newAddress(@RequestBody Address body) {

        Address address = this.addressService.saveAddress(body);

        return address;
    }


    @PutMapping(path = "/v0/addresses")
    public Address saveAddress(@RequestBody Address body) {

        Address address  = this.addressService.saveAddress(body);

        return address;
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
