package com.example.demo.repositories.assignment2;

import com.example.demo.entities.NhanVien;
import com.example.demo.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    public Page<NhanVien> findByTenLike(String keyword, PageRequest p);
}
