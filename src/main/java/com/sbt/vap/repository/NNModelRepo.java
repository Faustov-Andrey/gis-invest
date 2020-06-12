package com.sbt.vap.repository;

import com.sbt.vap.model.NNModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NNModelRepo extends JpaRepository<NNModel, Long> {


}