package com.example.demo.repositories.assignment1;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MauSacRepository {
    private List<MauSac> dsms;

    public MauSacRepository() {
        this.dsms = new ArrayList<>();
        this.dsms.add(new MauSac(1, "MS01", "Mau do", 1));
        this.dsms.add(new MauSac(2, "MS02", "Mau vang", 0));
    }

    public List<MauSac> findAll() {
        return this.dsms;
    }

    public void create(MauSac ms) {
        this.dsms.add(ms);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.dsms.size(); i++){
            MauSac m = this.dsms.get(i);
            if(m.getId() == id){
                this.dsms.remove(i);
            }
        }
    }
    public MauSac findById(int id)
    {
        for (int i = 0; i < this.dsms.size(); i++) {
            MauSac m = this.dsms.get(i);
            if (m.getId() == id) {
                return m;
            }
        }

        return null;
    }

    public void update(MauSac ms){
        for (int i = 0; i < this.dsms.size(); i++){
            MauSac p = this.dsms.get(i);
            if(p.getId() == ms.getId()){
                this.dsms.set(i, ms);
            }
        }
    }

    public List<MauSac> sech(String query) {
        return dsms.stream()
                .filter(sp -> sp.getMa().toLowerCase().contains(query.toLowerCase()) ||
                        sp.getTen().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

}
