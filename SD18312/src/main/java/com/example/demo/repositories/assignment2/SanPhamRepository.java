package com.example.demo.repositories.assignment2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.example.demo.entities.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
//    @Query("SELECT ms FROM SanPham ms WHERE ms.ten LIKE %:keyword%")
//    public Page<SanPham> findByKeyword(@Param("keyword") String ten, Pageable pageable);

    public Page<SanPham> findByTenLike(String keyword, PageRequest p);
}
