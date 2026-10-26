package com.example.UltraKostik_SpringBoot.service;//package com.example.UltraKostik_SpringBoot.service;
//
//import com.example.UltraKostik_SpringBoot.model.User;
//import com.example.UltraKostik_SpringBoot.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//
//@Service
//public class EmployeeService {
//
//    private final UserRepository employeeRepository;
//
//    public EmployeeService(UserRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;V
//    }
//
//    public List<User> search(String name, String active) {
//        boolean hasName = (name != null && !name.isBlank());
//
//        if (active == null || Objects.equals(active, "all")) {
//            if (hasName) {
//                return employeeRepository.findByFullNameContainingIgnoreCase(name);
//            }
//            return employeeRepository.findAll();
//        }
//
//        if (Objects.equals(active, "true")) {
//            if (hasName) {
//                return employeeRepository.findByFullNameContainingIgnoreCaseAndActive(name, true);
//            }
//            return employeeRepository.findByActive(true);
//        }
//
//        if (Objects.equals(active, "false")) {
//            if (hasName) {
//                return employeeRepository.findByFullNameContainingIgnoreCaseAndActive(name, false);
//            }
//            return employeeRepository.findByActive(false);
//        }
//        return employeeRepository.findAll();
//    }
//
//    public User getById(Long id){
//        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Сотрудник должен обладать корректным ID"));
//    }
//
//    public boolean emailExists(String email){
//        return employeeRepository.existsByEmail(email);
//    }
//
//    public User saveEmployee(User employee){
//        if (employee.getId() == null) {
//            if (employeeRepository.existsByEmail(employee.getEmail())) {
//                throw new RuntimeException("Email уже занят");
//            }
//        } else {
//            if (employeeRepository.existsByEmailAndIdNot(employee.getEmail(), employee.getId())) {
//                throw new RuntimeException("Email уже занят другим сотрудником");
//            }
//        }
//        return employeeRepository.save(employee);
//    }
//
//    public void deleteEmployee(Long id){
//        employeeRepository.deleteById(id);
//    }
//}