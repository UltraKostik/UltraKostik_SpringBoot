package com.example.UltraKostik_SpringBoot.controller;

import com.example.UltraKostik_SpringBoot.model.Grade;
import com.example.UltraKostik_SpringBoot.model.User;
import com.example.UltraKostik_SpringBoot.service.GradeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("/grades")
    public String listGrades(@RequestParam(required = false) String subject, HttpSession session, Model model){
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        List<Grade> grades = gradeService.getGrades(currentUser, subject);
        model.addAttribute("grades", grades);
        model.addAttribute("subject", subject);
        return "grades-list";

    }

    @GetMapping("/grades/add")
    public String addForm(HttpSession session, Model model){
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("grade", new Grade());
        return "grade-form";
    }

    @PostMapping("/grades/add")
    public String add(@ModelAttribute("grade") Grade grade, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null){
            return "redirect:/login";
        }
        grade.setUser(currentUser);
        gradeService.saveGrade(grade);
        return "redirect:/grades";
    }

    @GetMapping("/grades/edit/{id}")
    public String editForm(@PathVariable Long id, HttpSession session, Model model){
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        Grade grade = gradeService.getById(id);
        model.addAttribute("grade", grade);
        return "grade-form";
    }

    @PostMapping("/grades/edit/{id}")
    public String edit(@PathVariable Long id, @ModelAttribute("grade") Grade grade, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        grade.setId(id);
        grade.setUser(currentUser);
        gradeService.saveGrade(grade);
        return "redirect:/grades";
    }

    @PostMapping("/grades/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        gradeService.deleteGrade(id);
        return "redirect:/grades";
    }
}
