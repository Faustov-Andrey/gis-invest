package ru.itr.giskv.repository;

import ru.itr.giskv.model.GiskvUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiskvUserRepo extends JpaRepository<GiskvUser, Long> {

}