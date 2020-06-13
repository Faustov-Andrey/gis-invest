package ru.itr.giskv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itr.giskv.model.Address;
import ru.itr.giskv.repository.AddressRepo;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public Address saveAddress(final Address address) { return this.addressRepo.saveAndFlush(address); }

    public List<Address> findAll() {
        return this.addressRepo.findAll();
    }

    public Address getAddressByID(final long id){
        return this.addressRepo.getOne(id);
    }

    public void deleteAddress(final Address address){
        this.addressRepo.delete(address);
    }
}
