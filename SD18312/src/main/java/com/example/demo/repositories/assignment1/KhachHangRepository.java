package com.example.demo.repositories.assignment1;

import com.example.demo.entities.KhachHang;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KhachHangRepository {
    private List<KhachHang> dskh;

    public KhachHangRepository() {
        this.dskh = new ArrayList<>();
        this.dskh.add(new KhachHang(1, "Hung", "0353829690", "KH01", 1));
        this.dskh.add(new KhachHang(2, "Manh", "0353829690", "KH02", 1));
        this.dskh.add(new KhachHang(3, "Cuong", "0353829690", "KH03", 0));
    }

    public List<KhachHang> findAll() {
        return this.dskh;
    }

    public void create(KhachHang kt) {
        this.dskh.add(kt);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dskh.size(); i++) {
            KhachHang kh = this.dskh.get(i);
            if (kh.getId() == id) {
                this.dskh.remove(i);
            }
        }
    }

    public KhachHang findById(int id)
    {
        for (int i = 0; i < this.dskh.size(); i++) {
            KhachHang m = this.dskh.get(i);
            if (m.getId() == id) {
                return m;
            }
        }

        return null;
    }

    public void update(KhachHang ms){
        for (int i = 0; i < this.dskh.size(); i++){
            KhachHang p = this.dskh.get(i);
            if(p.getId() == ms.getId()){
                this.dskh.set(i, ms);
            }
        }
    }

    public List<KhachHang> sech(String query) {
        return dskh.stream()
                .filter(sp -> sp.getSdt().toLowerCase().contains(query.toLowerCase()) ||
                        sp.getTen().toLowerCase().contains(query.toLowerCase()) ||  sp.getMaKH().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

}
