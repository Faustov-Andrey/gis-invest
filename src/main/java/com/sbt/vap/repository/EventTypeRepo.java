package com.sbt.vap.repository;

import com.sbt.vap.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepo extends JpaRepository<EventType, Long> {
}
