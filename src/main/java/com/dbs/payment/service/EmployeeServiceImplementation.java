package com.dbs.payment.service;

import com.dbs.payment.entity.Employee;
import com.dbs.payment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> fetchEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> updateEmployee(Long id, Employee emp) {
        Optional<Employee> emO = employeeRepository.findById((id));
        if(emO.isPresent()){
            Employee em = emO.get();
            em.setEmployeeName(emp.getEmployeeName());
            em.setEmployeePassword(emp.getEmployeePassword());
        }
        return employeeRepository.findById(id);
    }

    @Override
    public String deleteEmployee(Long id) {
        return null;
    }
}
