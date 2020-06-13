package ru.itr.giskv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itr.giskv.model.OrganizationOwner;
import ru.itr.giskv.repository.OwnerRepo;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepo ownerRepo;

    public OrganizationOwner saveOwner(final OrganizationOwner organizationOwner) { return this.ownerRepo.saveAndFlush(organizationOwner); }

    public List<OrganizationOwner> findAll() {
        return this.ownerRepo.findAll();
    }

    public OrganizationOwner getOwnerByID(final long id){
        return this.ownerRepo.getOne(id);
    }

    public void deleteOwner(final OrganizationOwner organizationOwner){
        this.ownerRepo.delete(organizationOwner);
    }


}
