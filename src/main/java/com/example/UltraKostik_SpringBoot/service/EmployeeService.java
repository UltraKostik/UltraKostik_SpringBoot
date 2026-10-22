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

    public List<Employee> search(String name, String active) {
        boolean hasName = (name != null && !name.isBlank());

        if (active == null || Objects.equals(active, "all")) {
            if (hasName) {
                return employeeRepository.findByFullNameContainingIgnoreCase(name);
            }
            return employeeRepository.findAll();
        }

        if (Objects.equals(active, "true")) {
            if (hasName) {
                return employeeRepository.findByFullNameContainingIgnoreCaseAndActive(name, true);
            }
            return employeeRepository.findByActive(true);
        }

        if (Objects.equals(active, "false")) {
            if (hasName) {
                return employeeRepository.findByFullNameContainingIgnoreCaseAndActive(name, false);
            }
            return employeeRepository.findByActive(false);
        }
        return employeeRepository.findAll();
    }

    public Employee getById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Сотрудник должен обладать корректным ID"));
    }

    public boolean emailExists(String email){
        return employeeRepository.existsByEmail(email);
    }

    public Employee saveEmployee(Employee employee){
        if (employee.getId() == null) {
            if (employeeRepository.existsByEmail(employee.getEmail())) {
                throw new RuntimeException("Email уже занят");
            }
        } else {
            if (employeeRepository.existsByEmailAndIdNot(employee.getEmail(), employee.getId())) {
                throw new RuntimeException("Email уже занят другим сотрудником");
            }
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}