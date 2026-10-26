package com.example.UltraKostik_SpringBoot.controller;

import com.example.UltraKostik_SpringBoot.model.User;
import com.example.UltraKostik_SpringBoot.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm(){
        return "login-form";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password, HttpSession session, Model model){
        User user = userService.authorization(login, password);
        if (user == null){
            model.addAttribute("error","Неверный логин или пароль");
            return "login-form";
        }
        else{
            session.setAttribute("currentUser",user);
            return "redirect:/grades";
        }
    }

    @GetMapping("/register")
    public String registerForm(){
        return "register-form";
    }

    @PostMapping("/register")
    public String register(@RequestParam String login, @RequestParam String password){
        userService.register(login, password);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

}
