package com.example.demo.repositories.assignment1;

import com.example.demo.entities.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NhanVienRepository {
    private List<NhanVien> dsnv;

    public NhanVienRepository(){
        this.dsnv = new ArrayList<>();
        this.dsnv.add(new NhanVien(1, "Truong", "PH01", "truong123", "1234", 0));
        this.dsnv.add(new NhanVien(2, "Cuong", "PH02", "cuongphin", "1234", 1));
    }

    public  List<NhanVien> findAll(){
        return this.dsnv;
    }

    public void create(NhanVien sp){
        this.dsnv.add(sp);
    }

    public void update(NhanVien sp){
        for (int i = 0; i < this.dsnv.size(); i++){
            NhanVien p = this.dsnv.get(i);
            if(p.getId() == sp.getId()){
                this.dsnv.set(i, sp);
            }
        }
    }

    public void deleteById(int id){
        for (int i = 0; i < this.dsnv.size(); i++){
            NhanVien p = this.dsnv.get(i);
            if(p.getId() == id){
                this.dsnv.remove(i);
            }
        }
    }

    public NhanVien findById(int id)
    {
        for (int i = 0; i < this.dsnv.size(); i++) {
            NhanVien p = this.dsnv.get(i);
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public List<NhanVien> sech(String query) {
        return dsnv.stream()
                .filter(sp -> sp.getTen().toLowerCase().contains(query.toLowerCase()) ||
                        sp.getTenDN().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
