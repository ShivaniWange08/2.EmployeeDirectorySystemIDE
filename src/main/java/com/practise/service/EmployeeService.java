package com.practise.service;

import com.practise.entity.Employee;

import java.util.List;

public interface EmployeeService {

    String saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    String deleteEmployeeById(int id);

    Employee updateEmployee(int id, Employee newEmployee);

    List<Employee> savelistOfEmployee(List<Employee> employeeList);
}

