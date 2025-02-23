package com.example.sampleproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service){
        this.service=service;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable Long id){
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
