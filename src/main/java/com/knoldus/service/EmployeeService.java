package com.knoldus.service;


import com.knoldus.model.Employee;
import com.knoldus.repository.EmployeeRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    public Employee insertEmployee(Employee employee)
    {
       return  employeeRepository.save(employee);
    }

    public Iterable<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }else{
            throw new RuntimeException("Employee not found for the id::" + id);
        }
    }
}
