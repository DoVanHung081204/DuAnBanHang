package com.example.demo.controllers;

import com.example.demo.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private static final String Name = "Hung";
    private static final String MatKhau = "Hung1234";

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(User request, HttpSession session, Model model) {
        if (Name.equals(request.getUsername()) && MatKhau.equals(request.getPassword())) {
            session.setAttribute("DangNhap", request.getUsername());
            return "redirect:trang-chu";
        }
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    public static boolean chuyengiao(HttpSession session) {
        return session.getAttribute("DangNhap") != null;
    }
}