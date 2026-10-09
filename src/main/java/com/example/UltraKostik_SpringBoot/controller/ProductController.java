package com.example.UltraKostik_SpringBoot.controller;


import com.example.UltraKostik_SpringBoot.model.Employee;
import com.example.UltraKostik_SpringBoot.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final EmployeeService employeeService;

    public ProductController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listProducts(Model model){
        model.addAttribute("products", employeeService.getAllProducts());
        return "products-list";
    }

    @GetMapping("/add")
    public String FormAddProduct(Model model){
        model.addAttribute("product", new Employee());
        return "product-form";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Employee employee){
        employeeService.saveProduct(employee);
        return "redirect:/products";
    }
}
