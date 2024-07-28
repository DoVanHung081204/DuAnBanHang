package com.example.demo.controllers;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;
import com.example.demo.repositories.assignment2.KichThuocRepository;
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
public class KichThuocController {
    @Autowired
    private KichThuocRepository ktRepo ;

    @GetMapping("kich-thuoc/create")
    public String addKichThuoc() {
        return "kich_thuoc/create";
    }

    @PostMapping("kich-thuoc/store")
    public String store(Model model,
                        @Valid KichThuoc sp, BindingResult validateResult
    ) {
        if(validateResult.hasErrors()){
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe: listError){
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "kich_thuoc/create";
        }

        this.ktRepo.save(sp);

        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("kich-thuoc/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.ktRepo.deleteById(id);
        return "kich_thuoc/create";
    }

    @GetMapping("kich-thuoc/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNo,
                        @RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword, HttpSession session
    ) {
        PageRequest p = PageRequest.of(pageNo, pageSize);

        String s = "%" + keyword + "%";
        Page<KichThuoc> ds = this.ktRepo.findByTenLike(s, p);
        model.addAttribute("data", ds);
        return "kich_thuoc/index";

    }

    @GetMapping("kich-thuoc/edit/{id}")
    public String edit(@PathVariable("id") KichThuoc kt, Model model) {
        model.addAttribute("data", kt);
        return "kich_thuoc/edit";
    }

    @PostMapping("kich-thuoc/update/{id}")
    public String update(Model model,
                         @Valid KichThuoc sp, BindingResult validateResult, @PathVariable("id") Integer id) {
        if(validateResult.hasErrors()){
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe: listError){
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "kich_thuoc/edit";
        }

        this.ktRepo.save(sp);

        return "redirect:/kich-thuoc/index";
    }

//    @GetMapping("kich-thuoc/search")
//    public String searchSanPham(@RequestParam String query, Model model) {
//        List<KichThuoc> result = ktRepo.sech(query);
//        model.addAttribute("data", result);
//        return "kich_thuoc/index";
//    }
}
