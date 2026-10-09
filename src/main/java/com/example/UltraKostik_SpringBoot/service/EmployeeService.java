package com.example.UltraKostik_SpringBoot.service;

import com.example.UltraKostik_SpringBoot.model.Employee;
import com.example.UltraKostik_SpringBoot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> search(String name, String active){
        if (Objects.equals(active, "all")){
            return employeeRepository.findAll();
        }

    }
}
