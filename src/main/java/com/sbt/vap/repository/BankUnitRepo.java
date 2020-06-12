package com.sbt.vap.repository;

import com.sbt.vap.model.BankUnit;
import com.sbt.vap.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankUnitRepo  extends JpaRepository<BankUnit, Long> {

    @Query(value = "SELECT i FROM BankUnit i WHERE i.parentId = ?1")
    List<BankUnit> findByParentId(final Long parentId);

}
