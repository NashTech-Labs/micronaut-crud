package com.knoldus.controller;


import com.knoldus.service.EmployeeService;
import com.knoldus.model.Employee;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;


@Controller(value = "/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @Get("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeById(@QueryValue long id)
    {


         return employeeService.findById(id);
    }

    @Post("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse saveEmployee(@Valid @Body Employee employee)
    {
        employeeService.insertEmployee(employee);
        return HttpResponse.ok();
    }

    @Get("/employee/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployees();
    }
}
