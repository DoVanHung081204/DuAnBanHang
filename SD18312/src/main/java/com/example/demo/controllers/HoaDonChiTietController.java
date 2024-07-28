package com.example.demo.controllers;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.HoaDonCT;


import com.example.demo.repositories.assignment2.HoaDonCTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hoa-donct")
class HoaDonChiTietController {
    @Autowired
    private HoaDonCTRepository hoaDonCTRepository;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "1") int pageNo,
                        @RequestParam(name = "limit", defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        PageRequest p = PageRequest.of(pageNo, pageSize);

        String s = "%" + keyword + "%";
        Page<HoaDonCT> ds = this.hoaDonCTRepository.findAll(p);
        model.addAttribute("data", ds);
        return "hoa_donct/index";

    }

    @GetMapping("/edit/{id}")
    public String editHoaDonCT(@PathVariable HoaDonCT hoaDonCT, Model model) {
        model.addAttribute("hoaDonCT", hoaDonCT);
        return "hoa_donct/edit";
    }

    @PostMapping("save")
    public String saveHoaDonCT(@ModelAttribute HoaDonCT hoaDonCT) {
        hoaDonCTRepository.save(hoaDonCT);
        return "redirect:/hoa-donct";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        this.hoaDonCTRepository.deleteById(id);
        return "hoa_donct/index";
    }


}
