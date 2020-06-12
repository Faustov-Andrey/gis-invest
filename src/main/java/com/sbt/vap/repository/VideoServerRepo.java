package com.sbt.vap.repository;

import com.sbt.vap.model.NNModel;
import com.sbt.vap.model.VideoServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoServerRepo extends JpaRepository<VideoServer, Long> {


}
