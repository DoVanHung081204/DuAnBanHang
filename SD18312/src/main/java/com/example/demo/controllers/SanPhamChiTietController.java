package com.example.demo.controllers;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.SanPhamChiTiet;
import com.example.demo.repositories.assignment2.SPCTRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/san-phamct")
public class SanPhamChiTietController {
    @Autowired
    private SPCTRepository spctRepo;

    @GetMapping("/create")
    public String addSanPhamChiTiet(Model model) {
        model.addAttribute("data", new SanPhamChiTiet());
        return "san_phamct/create";
    }

    @PostMapping("/store")
    public String store(Model model, @Valid @ModelAttribute("data") SanPhamChiTiet sp, BindingResult validateResult) {
        if (validateResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe : validateResult.getFieldErrors()) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "san_phamct/create";
        }

        spctRepo.save(sp);
        return "redirect:/san-phamct/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        spctRepo.deleteById(id);
        return "redirect:/san-phamct/index";
    }

    @GetMapping("/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNo,
                        @RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        PageRequest p = PageRequest.of(pageNo, pageSize);

        String s = "%" + keyword + "%";
        Page<SanPhamChiTiet> ds = this.spctRepo.findAll(p);
        model.addAttribute("data", ds);
        return "san_phamct/index";

    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") SanPhamChiTiet sp, Model model) {
        model.addAttribute("data", sp);
        return "san_phamct/edit";
    }


    @PostMapping("/update/{id}")
    public String update(Model model,
                         @Valid SanPhamChiTiet sp, BindingResult validateResult) {
        if (validateResult.hasErrors()) {
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "san_phamct/edit";
        }

        this.spctRepo.save(sp);

        return "redirect:/san-phamct/index";
    }

//    @GetMapping("/search")
//    public String searchSanPham(@RequestParam("query") String query, Model model) {
//        List<SanPhamChiTiet> result = spctRepo.sech(query);
//        model.addAttribute("data", result);
//        return "san_phamct/index";
//    }
}
