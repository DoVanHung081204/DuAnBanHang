package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotBlank(message = "Ma Khong Duoc Bo Trong")
    @Column(name = "Ma")
    public String ma;
    @NotBlank(message = "Ten khong duoc bo trong")
    @Column(name = "Ten")
    public String ten;
    @NotNull(message = "Phai tron trang thai")
    @Column(name = "TrangThai")
    public int trangThai;
}
