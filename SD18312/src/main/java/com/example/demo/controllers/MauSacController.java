package com.example.demo.controllers;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;
import com.example.demo.repositories.assignment2.MauSacRepository;
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
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;

    @GetMapping("mau-sac/create")
    public String addMauSac() {
        return "mau_sac/create";
    }

    @PostMapping("mau-sac/store")
    public String store(Model model,
                        @Valid MauSac sp, BindingResult validateResult
    ) {
        if(validateResult.hasErrors()){
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe: listError){
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "mau_sac/create";
        }

        this.msRepo.save(sp);

        return "redirect:/mau-sac/index";
    }

    @GetMapping("mau-sac/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.msRepo.deleteById(id);
        return "mau_sac/create";
    }
    @GetMapping("mau-sac/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNo,
                        @RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        PageRequest p = PageRequest.of(pageNo, pageSize);

        String s = "%" + keyword + "%";
        Page<MauSac> ds = this.msRepo.findByTenLike(s, p);
        model.addAttribute("data", ds);
        return "mau_sac/index";

    }

    @GetMapping("mau-sac/edit/{id}")
    public String edit(@PathVariable("id") MauSac ms, Model model) {
        model.addAttribute("data", ms);
        return "mau_sac/edit";
    }

    @PostMapping("mau-sac/update/{id}")
    public String update(Model model,
                         @Valid MauSac sp, BindingResult validateResult, @PathVariable("id") Integer id) {
        if(validateResult.hasErrors()){
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe: listError){
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "mau_sac/edit";
        }

        this.msRepo.save(sp);

        return "redirect:/mau-sac/index";
    }
//
//    @GetMapping("mau-sac/search")
//    public String searchSanPham(@RequestParam String query, Model model) {
//        List<MauSac> result = msRepo.query);
//        model.addAttribute("data", result);
//        return "mau_sac/index";
//    }
}
