package com.example.demo.repositories.assignment2;

import com.example.demo.entities.SanPham;
import com.example.demo.entities.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SPCTRepository  extends JpaRepository<SanPhamChiTiet, Integer> {
//    public Page<SanPhamChiTiet> findByMaSPCTLike(String keyword, PageRequest p);
}
