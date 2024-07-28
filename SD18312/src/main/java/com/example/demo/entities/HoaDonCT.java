package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "IdHoaDon")
    private Integer idHd;
    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "IdSPCT")
    private int idSPCT;
    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "SoLuong")
    private int sl;
    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "DonGia")
    private float dg;

    @NotBlank(message = "Khong duoc bo trong")
    @Column(name = "ThoiGian")
    private Date tg;

    @NotNull(message = "Khong duoc bo trong")
    @Column(name = "TrangThai")
    private int trangThai;


}
