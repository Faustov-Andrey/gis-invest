package ru.itr.giskv.service;

import ru.itr.giskv.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itr.giskv.repository.OrganizationRepo;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;

    public Organization saveOrganization(final Organization organization) { return this.organizationRepo.saveAndFlush(organization); }

    public List<Organization> findAll() {
        return this.organizationRepo.findAll();
    }

    public Organization getOrganizationByID(final long id){
        return this.organizationRepo.getOne(id);
    }

    public void deleteOrganization(final Organization organization){
        this.organizationRepo.delete(organization);
    }


}
