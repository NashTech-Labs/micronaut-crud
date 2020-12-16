package com.knoldus.repository;


import com.knoldus.model.Employee;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;


@JdbcRepository(dialect = Dialect.MYSQL)
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
