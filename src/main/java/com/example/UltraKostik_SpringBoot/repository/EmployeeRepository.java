package com.example.UltraKostik_SpringBoot.repository;

import com.example.UltraKostik_SpringBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email, Long id);
    boolean existsByEmailAndIdNot(String email);
    List<Employee> findByFullNameContainingIgnoreCase(String fullName);
    List<Employee> findByActive(Boolean active);
    List<Employee> findByFullNameContainingIgnoreCaseAndActive(String fullName, Boolean active);
}
