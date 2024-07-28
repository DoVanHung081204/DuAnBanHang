package com.example.demo.repositories.assignment1;

import com.example.demo.entities.NhanVien;
import com.example.demo.entities.SanPham;
import com.example.demo.entities.SanPhamChiTiet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SanPhamChiTietRepository {
    private List<SanPhamChiTiet> dsspct;

//    public SanPhamChiTietRepository(){
//        this.dsspct = new ArrayList<>();
//        this.dsspct.add(new SanPhamChiTiet( 1, "SPCT01", 1, 1, 1, 20, 200, 1));
//        this.dsspct.add(new SanPhamChiTiet( 2, "SPCT02", 3, 3, 3, 30, 460, 0));
//        this.dsspct.add(new SanPhamChiTiet( 3, "SPCT03", 2, 1, 2, 25, 250, 1));
//    }

    public List<SanPhamChiTiet> findAll(){
        return this.dsspct;
    }

    public void create(SanPhamChiTiet spct){
        this.dsspct.add(spct);
    }

    public void update(SanPhamChiTiet spct){
        for (int i = 0; i < this.dsspct.size(); i++){
            SanPhamChiTiet p = this.dsspct.get(i);
            if(p.getId() == spct.getId()){
                this.dsspct.set(i, spct);
            }
        }
    }

    public void deleteById(int id){
        for (int i = 0; i < this.dsspct.size(); i++){
            SanPhamChiTiet p = this.dsspct.get(i);
            if(p.getId() == id){
                this.dsspct.remove(i);
            }
        }
    }

    public SanPhamChiTiet findById(int id)
    {
        for (int i = 0; i < this.dsspct.size(); i++) {
            SanPhamChiTiet p = this.dsspct.get(i);
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

    public List<SanPhamChiTiet> sech(String query) {
        return dsspct.stream()
                .filter(sp -> sp.getMa().toLowerCase().contains(query.toLowerCase())
                       )
                .collect(Collectors.toList());
    }
}
