package com.example.demo.controllers;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.MauSac;
import com.example.demo.repositories.assignment2.HoaDonRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HoaDonController {
    @Autowired
    private HoaDonRepository hdRepo;

    @GetMapping("hoa-don/create")
    public String create() {
        return "hoa_don/create";
    }

    @GetMapping("hoa-don/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNo,
                        @RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        PageRequest p = PageRequest.of(pageNo, pageSize);

        String s = "%" + keyword + "%";
        Page<HoaDon> ds = this.hdRepo.findAll(p);
        model.addAttribute("data", ds);
        return "hoa_don/index";

    }

    @PostMapping("hoa-don/store")
    public String store(Model model,
                        @Valid HoaDon sp, BindingResult validateResult
    ) {
        if (validateResult.hasErrors()) {
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "hoa_don/create";
        }

        this.hdRepo.save(sp);

        return "redirect:/hoa-don/index";
    }


    @GetMapping("hoa-don/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.hdRepo.deleteById(id);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("hoa-don/edit/{id}")
    public String edit(@PathVariable("id") HoaDon sp, Model model) {
        model.addAttribute("data", sp);
        return "hoa_don/edit";
    }

    @PostMapping("hoa-don/update/{id}")
    public String update(Model model,
                         @Valid HoaDon sp, BindingResult validateResult, @PathVariable("id") Integer id) {
        if (validateResult.hasErrors()) {
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "hoa_don/edit";
        }

        this.hdRepo.save(sp);

        return "redirect:/hoa-don/index";
    }
}
