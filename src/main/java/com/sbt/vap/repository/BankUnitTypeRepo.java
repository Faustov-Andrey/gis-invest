package com.sbt.vap.repository;

import com.sbt.vap.model.BankUnit;
import com.sbt.vap.model.BankUnitType;
import com.sbt.vap.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankUnitTypeRepo  extends JpaRepository<BankUnitType, Long> {

}