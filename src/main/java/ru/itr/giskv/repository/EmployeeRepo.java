package ru.itr.giskv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itr.giskv.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
