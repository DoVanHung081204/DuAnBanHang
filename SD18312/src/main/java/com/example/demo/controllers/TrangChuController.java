package com.example.demo.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TrangChuController {
    @GetMapping("trang-chu")
    public String index(HttpSession session){
//        if(LoginController.chuyengiao(session)){
            return "home/home";
//        }
//        return "redirect:/login";
    }
}
