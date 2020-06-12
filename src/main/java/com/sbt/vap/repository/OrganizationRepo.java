package com.sbt.vap.repository;

import com.sbt.vap.controller.OrganizationController;
import com.sbt.vap.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Long>{


}
