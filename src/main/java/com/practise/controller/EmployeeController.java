package com.practise.controller;

import com.practise.entity.Employee;
import com.practise.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        System.err.println(employee);
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>("Employee Data Add Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllData(){
       List<Employee> employeeList = employeeService.getAllEmployee();
       return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable ("id") int id){
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        String delete = employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable ("id") int id, @RequestBody Employee employee){
        Employee updateDeveloper = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(updateDeveloper, HttpStatus.OK);
    }
    @PostMapping("/ListOfEmployee")
    public ResponseEntity<List<Employee>> saveListOfEmployee(@RequestBody List<Employee> employeeList){
        employeeService.savelistOfEmployee(employeeList);
        return new ResponseEntity<>(employeeList, HttpStatus.CREATED);
    }

}
