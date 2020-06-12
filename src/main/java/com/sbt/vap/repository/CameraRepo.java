package com.sbt.vap.repository;

import com.sbt.vap.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CameraRepo extends JpaRepository<Camera, Long>{

    @Query(value = "SELECT i FROM Camera i WHERE i.bankUnitId = ?1")
    List<Camera> findByBankUnit(final Long bankUnitId);

}
