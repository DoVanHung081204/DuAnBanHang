package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "Mã Nhân Viên Không Được Bỏ Trống ")
    @Column(name = "Ma")
    public String maNV;
    @NotBlank(message = "Tên Nhân Viên Không Được Bỏ Trống ")
    @Column(name = "Ten")
    public String ten;
    @NotBlank(message = "Tên Đăng Nhập Không Được Bỏ Trống ")
    @Column(name = "TenDangNhap")
    public String tenDN;
    @NotBlank(message = "Phai nhap Mat Khau")
    @Column(name = "MatKhau")
    public String mk;
    @NotNull(message = "Phai tron trang thai")
    @Column(name = "TrangThai")
    public int trangThai;
}
