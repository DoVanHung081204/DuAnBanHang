package com.example.demo.repositories.assignment2;

import com.example.demo.entities.HoaDonCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonCTRepository extends JpaRepository<HoaDonCT, Integer> {
}
