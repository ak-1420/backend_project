package com.dbs.payment.controller;

import com.dbs.payment.entity.Employee;
import com.dbs.payment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> fetchAllEmployees(){
        return  employeeService.fetchAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> fetchEmployee(@PathVariable Long id){
        return employeeService.fetchEmployee(id);
    }

    @PatchMapping("/{id}")
    public Optional<Employee> updateEmployee(@PathVariable Long id ,@RequestBody Employee emp){
        return employeeService.updateEmployee(id , emp);
    }


    @DeleteMapping
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }



}
