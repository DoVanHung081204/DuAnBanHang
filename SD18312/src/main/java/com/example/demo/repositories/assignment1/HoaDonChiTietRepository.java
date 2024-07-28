package com.example.demo.repositories.assignment1;

import com.example.demo.entities.HoaDonCT;
import com.example.demo.entities.KhachHang;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HoaDonChiTietRepository {
    private List<HoaDonCT> dshdct ;

//    public HoaDonChiTietRepository(){
//        this.dshdct = new ArrayList<>();
//        this.dshdct.add(new HoaDonCT(1, 1, 1, 5,  200000, 1));
//        this.dshdct.add(new HoaDonCT(2, 2, 2, 7,  120000, 1));
//        this.dshdct.add(new HoaDonCT(3, 3, 3, 10,  200, 0));
//    }

    public List<HoaDonCT> findAll(){
        return this.dshdct;
    }

    public void create(HoaDonCT kt) {
        this.dshdct.add(kt);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dshdct.size(); i++) {
            HoaDonCT kh = this.dshdct.get(i);
            if (kh.getId() == id) {
                this.dshdct.remove(i);
            }
        }
    }

    public HoaDonCT findById(int id)
    {
        for (int i = 0; i < this.dshdct.size(); i++) {
            HoaDonCT m = this.dshdct.get(i);
            if (m.getId() == id) {
                return m;
            }
        }

        return null;
    }

    public void update(HoaDonCT ms){
        for (int i = 0; i < this.dshdct.size(); i++){
            HoaDonCT p = this.dshdct.get(i);
            if(p.getId() == ms.getId()){
                this.dshdct.set(i, ms);
            }
        }
    }


}
