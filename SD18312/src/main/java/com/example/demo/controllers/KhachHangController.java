package com.example.demo.controllers;

import com.example.demo.entities.KhachHang;
import com.example.demo.entities.MauSac;
import com.example.demo.repositories.assignment2.KhachHangRepository;
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
public class KhachHangController {
    @Autowired
    private KhachHangRepository khRepo;

    @GetMapping("khach-hang/create")
    public String addKhachHang() {
        return "khach_hang/create";
    }

    @PostMapping("khach-hang/store")
    public String store(Model model,
                        @Valid KhachHang sp, BindingResult validateResult
    ) {
        if(validateResult.hasErrors()){
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe: listError){
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "khach_hang/create";
        }

        this.khRepo.save(sp);

        return "redirect:/khach-hang/index";
    }

    @GetMapping("khach-hang/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.khRepo.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("khach-hang/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNo,
                        @RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        PageRequest p = PageRequest.of(pageNo, pageSize);

        String s = "%" + keyword + "%";
        Page<KhachHang> ds = this.khRepo.findByTenLike(s, p);
        model.addAttribute("data", ds);
        return "khach_hang/index";

    }

    @GetMapping("khach-hang/edit/{id}")
    public String edit(@PathVariable("id") KhachHang sp, Model model) {
        model.addAttribute("data", sp);
        return "khach_hang/edit";
    }

    @PostMapping("khach-hang/update/{id}")
    public String update(Model model,
                         @Valid KhachHang sp, BindingResult validateResult, @PathVariable("id") Integer id) {
        if(validateResult.hasErrors()){
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe: listError){
                errors.put(fe.getField(), fe.getDefaultMessage());
            }

            model.addAttribute("errors", errors);
            model.addAttribute("data", sp);
            return "khach_hang/edit";
        }

        this.khRepo.save(sp);

        return "redirect:/khach-hang/index";
    }

//    @GetMapping("khach-hang/search")
//    public String searchSanPham(@RequestParam String query, Model model) {
//        List<KhachHang> result = khRepo.sech(query);
//        model.addAttribute("data", result);
//        return "khach_hang/index";
//    }
}
