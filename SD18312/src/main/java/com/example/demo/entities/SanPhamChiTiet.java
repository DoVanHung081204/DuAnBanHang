package com.example.demo.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "MaSPCT")
    private String ma;
    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "IdKichThuoc")
    private Integer idKt;
    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "IdMauSac")
    private Integer idMs;


    @NotBlank(message = "Khong duoc bo trong")
    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sp;


    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "SoLuong")
    private int sl;
    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "DonGia")
    private float dg;

    @Column(name = "TrangThai")
    private int tt;
}
