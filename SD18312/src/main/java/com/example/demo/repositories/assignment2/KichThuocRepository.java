package com.example.demo.repositories.assignment2;

import com.example.demo.entities.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {
    public Page<KichThuoc> findByTenLike(String keyword, PageRequest p);
}
