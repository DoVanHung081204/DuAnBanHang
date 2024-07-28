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
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "Phải nhập Tên")
    @Column(name = "Ten")
    public String ten;
    @NotBlank(message = "Phải nhập Số Điện Thoại ")
    @Size(max = 11 , message = "Quá ký tự cho phép")
    @Column(name = "SDT")
    public String sdt;
    @NotBlank(message = "Phải nhập Mã Khách Hàng")
    @Column(name = "Ma")
    private String maKH;
    @NotNull(message = "Phải chọn Trạng Thái ")
    @Column(name = "TrangThai")
    public int trangThai;
}
