package com.practise.serviceimpl;

import com.practise.entity.Employee;
import com.practise.repository.EmployeeRepository;
import com.practise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String saveEmployee(Employee employee) {
       Employee saveEmployee = employeeRepository.save(employee);
        return "employee saved";
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int id) {
     Employee employee = employeeRepository.findById(id)
             .orElseThrow(()-> new NullPointerException("Employee with id not found" +id));
        return employee;
    }

    @Override
    public String deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
        return "Developer Deleted";
    }

    @Override
    public Employee updateEmployee(int id, Employee newEmployee) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Employee  with id not found in database" +id));
        System.err.println("Old Employee from db :"+employee);
        System.err.println("Employee object with value to be updated" +newEmployee);
        employee.setName(newEmployee.getName());
        employee.setDesignation(newEmployee.getDesignation());
        employee.setSalary(newEmployee.getSalary());
        employee.setDepartment(newEmployee.getDepartment());

        Employee updatedEmployee = employeeRepository.save(employee);
        System.err.println("Employee with updated value " +updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public List<Employee> savelistOfEmployee(List<Employee> employeeList) {
        employeeRepository.saveAll(employeeList);
        return employeeList;
    }
}
