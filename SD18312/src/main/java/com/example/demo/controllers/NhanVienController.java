package com.example.demo.controllers;

import com.example.demo.entities.NhanVien;
import com.example.demo.repositories.assignment2.NhanVienRepository;
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
public class NhanVienController {
    @Autowired
    private NhanVienRepository nvRepo;

    @GetMapping("nhan-vien/create")
    public String addMauSac() {
        return "nhan_vien/create";
    }

    @PostMapping("nhan-vien/store")
    public String store(Model model,
                        @Valid NhanVien sp, BindingResult validateResult
    ) {
        if (validateResult.hasErrors()) {
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "nhan_vien/create";
        }

        this.nvRepo.save(sp);

        return "redirect:/nhan-vien/index";
    }

    @GetMapping("nhan-vien/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.nvRepo.deleteById(id);
        return "nhan_vien/create";
    }

    @GetMapping("nhan-vien/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNo,
                        @RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword)
    {
        PageRequest p = PageRequest.of(pageNo, pageSize);
        String s = "%" + keyword + "%";
        Page<NhanVien> ds = this.nvRepo.findByTenLike(s, p);
        model.addAttribute("data", ds);
        return "nhan_vien/index";

    }

    @GetMapping("nhan-vien/edit/{id}")
    public String edit(@PathVariable("id") NhanVien ms, Model model) {
        model.addAttribute("data", ms);
        return "nhan_vien/edit";
    }

    @PostMapping("nhan-vien/update/{id}")
    public String update(Model model,
                         @Valid NhanVien sp, BindingResult validateResult, @PathVariable("id") Integer id) {
        if (validateResult.hasErrors()) {
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "nhan_vien/edit";
        }

        this.nvRepo.save(sp);

        return "redirect:/nhan-vien/index";
    }

//    @GetMapping("nhan-vien/search")
//    public String searchSanPham(@RequestParam String query, Model model) {
//        List<NhanVien> result = nvRepo.sech(query);
//        model.addAttribute("data", result);
//        return "nhan_vien/index";
//    }
}
