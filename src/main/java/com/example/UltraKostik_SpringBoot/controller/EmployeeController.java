package com.example.UltraKostik_SpringBoot.controller;

import ch.qos.logback.core.model.Model;
import com.example.UltraKostik_SpringBoot.model.Employee;
import com.example.UltraKostik_SpringBoot.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//    @GetMapping
//    public String list(@RequestParam(required = false) String name, @RequestParam(required = false) String active, Model model) {
//        List<Employee> list = employeeService.search(name, active);
//    return "employees-list";
//    }
//
//    @GetMapping("/add")
//    public String FormAddProduct(Model model){
//        model.addAttribute("product", new Employee());
//        return "product-form";
//    }
//
//    @PostMapping("/add")
//    public String addProduct(@ModelAttribute("product") Employee employee){
//        employeeService.saveProduct(employee);
//        return "redirect:/products";
//    }
}
