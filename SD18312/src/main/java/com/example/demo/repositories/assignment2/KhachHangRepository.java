package com.example.demo.repositories.assignment2;

import com.example.demo.entities.KhachHang;
import com.example.demo.entities.KichThuoc;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    public Page<KhachHang> findByTenLike(String keyword, PageRequest p);
}
