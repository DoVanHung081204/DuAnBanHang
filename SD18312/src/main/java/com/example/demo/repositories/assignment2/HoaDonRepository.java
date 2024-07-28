package com.example.demo.repositories.assignment2;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
//    public Page<HoaDon> findByTenLike(String keyword, PageRequest p);
}

