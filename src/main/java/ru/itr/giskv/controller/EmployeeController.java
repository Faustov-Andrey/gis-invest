package ru.itr.giskv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itr.giskv.model.Employee;
import ru.itr.giskv.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.set("Access-Control-Allow-Origin", "*");
    }

    @GetMapping(path = "/v0/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = this.employeeService.findAll();
        return new ResponseEntity<>(employeeList, headers, HttpStatus.OK);
    }

    @PostMapping(path = "/v0/employees")
    public Long newOwner(@RequestBody Employee body) {

        //ниже временный код для проверки работы метода saveOrganization()
        Employee employee = new Employee();
        employee.setOrganizationId(body.getOrganizationId());
        employee.setFio(body.getFio());
        employee.setPosition(body.getPosition());
        employee.setDirectorFlag(body.getDirectorFlag());
        employee.setEmployeeCredentials(body.getEmployeeCredentials());
        employee.setContactType(body.getContactType());
        employee.setContactValue(body.getContactValue());
        employee.setGiskvLogin(body.getGiskvLogin());
        employee.setEsiaLogin(body.getEsiaLogin());

        Long newEmployeeId = this.employeeService.saveEmployee(employee).getId();
        return newEmployeeId;
    }


    @PutMapping(path = "/v0/employees")
    public boolean saveRequestLogRecord(@RequestBody Employee body) {

        //ниже временный код для проверки работы метода saveOrganization()
        Employee employee = new Employee();
        employee.setId(body.getId());
        employee.setOrganizationId(body.getOrganizationId());
        employee.setFio(body.getFio());
        employee.setPosition(body.getPosition());
        employee.setDirectorFlag(body.getDirectorFlag());
        employee.setEmployeeCredentials(body.getEmployeeCredentials());
        employee.setContactType(body.getContactType());
        employee.setContactValue(body.getContactValue());
        employee.setGiskvLogin(body.getGiskvLogin());
        employee.setEsiaLogin(body.getEsiaLogin());

        this.employeeService.saveEmployee(employee);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
    }


    @GetMapping(path = "/v0/employees/{id}")
    public Employee getEmployeeById(Long id) {
        return this.employeeService.getEemployeeByID(id);
    }

    @DeleteMapping(path = "/v0/employees/{id}")
    public boolean deleteEmployeesById(Long id) {
        Employee employee = getEmployeeById(id);
        this.employeeService.deleteEemployee(employee);
        //возвращать true если созранение прошло успешно и false при сбое
        return true;
    }



}
