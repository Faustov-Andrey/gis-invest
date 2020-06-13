package ru.itr.giskv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itr.giskv.model.OrganizationOwner;

@Repository
public interface OwnerRepo extends JpaRepository<OrganizationOwner, Long> {
}
