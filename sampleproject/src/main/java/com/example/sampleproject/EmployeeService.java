package com.example.sampleproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id){
        return repository.findById(id);
    }
}
