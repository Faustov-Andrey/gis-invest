package ru.itr.giskv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itr.giskv.model.Employee;
import ru.itr.giskv.model.Organization;
import ru.itr.giskv.repository.EmployeeRepo;
import ru.itr.giskv.repository.OrganizationRepo;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee saveEmployee(final Employee employee) { return this.employeeRepo.saveAndFlush(employee); }

    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }

    public Employee getEemployeeByID(final long id){
        return this.employeeRepo.getOne(id);
    }

    public void deleteEemployee(final Employee employee){
        this.employeeRepo.delete(employee);
    }

}
