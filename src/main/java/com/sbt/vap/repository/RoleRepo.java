package com.sbt.vap.repository;

import com.sbt.vap.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo  extends JpaRepository<Role, Long> {

}
