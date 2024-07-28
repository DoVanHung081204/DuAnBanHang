package com.example.demo.repositories.assignment1;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KichThuocRepository {
    private List<KichThuoc> dskt;

    public KichThuocRepository() {
        this.dskt = new ArrayList<>();
        this.dskt.add(new KichThuoc(3, "KT03", "S", 1));
        this.dskt.add(new KichThuoc(1, "KT01", "XL", 1));
        this.dskt.add(new KichThuoc(2, "KT02", "XXL", 0));
    }

    public List<KichThuoc> findAll() {
        return this.dskt;
    }

    public void create(KichThuoc kt) {
        this.dskt.add(kt);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dskt.size(); i++) {
            KichThuoc k = this.dskt.get(i);
            if (k.getId() == id) {
                this.dskt.remove(i);
            }
        }
    }

    public KichThuoc findById(int id)
    {
        for (int i = 0; i < this.dskt.size(); i++) {
            KichThuoc m = this.dskt.get(i);
            if (m.getId() == id) {
                return m;
            }
        }

        return null;
    }

    public void update(KichThuoc ms){
        for (int i = 0; i < this.dskt.size(); i++){
            KichThuoc p = this.dskt.get(i);
            if(p.getId() == ms.getId()){
                this.dskt.set(i, ms);
            }
        }
    }
    public List<KichThuoc> sech(String query) {
        return dskt.stream()
                .filter(sp -> sp.getMa().toLowerCase().contains(query.toLowerCase()) ||
                        sp.getTen().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}
