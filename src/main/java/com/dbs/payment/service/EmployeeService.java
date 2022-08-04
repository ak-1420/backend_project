package com.dbs.payment.service;

import com.dbs.payment.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    Optional<Employee> fetchEmployee(Long id);

    Optional<Employee> updateEmployee(Long id, Employee emp);

    String deleteEmployee(Long id);
}
