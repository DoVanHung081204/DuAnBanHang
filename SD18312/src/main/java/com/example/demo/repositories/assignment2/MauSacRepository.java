package com.example.demo.repositories.assignment2;

import com.example.demo.entities.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    public Page<MauSac> findByTenLike(String keyword, PageRequest p);
}
