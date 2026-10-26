package com.example.UltraKostik_SpringBoot.controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.UltraKostik_SpringBoot.model.User;
import com.example.UltraKostik_SpringBoot.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listEmployees(@RequestParam(required = false) String name, @RequestParam(required = false) String active, Model model){

        List<User> employees = employeeService.search(name, active);
        model.addAttribute("employees", employees);
        model.addAttribute("name", name);
        model.addAttribute("active", active);
        return "employees-list";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("employee",new User());
        return "employee-form";
    }

    @PostMapping("/add")
    public String addValid(@Valid @ModelAttribute("employee") User employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-form";
        }
        try {
            employeeService.saveEmployee(employee);
        } catch (RuntimeException e) {
            bindingResult.rejectValue("email", "error.employee", e.getMessage());
            return "employee-form";
        }
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model){
        User employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

}
