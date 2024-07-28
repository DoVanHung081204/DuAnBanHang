package com.example.demo.repositories.assignment1;

import com.example.demo.entities.HoaDon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HoaDonRepository {
    private List<HoaDon> dshd ;

//    public HoaDonRepository(){
//        this.dshd = new ArrayList<>();
//       this.dshd.add(new HoaDon(1, 1, 1, H"12/04/2023",1));
//        this.dshd.add(new HoaDon(2, 2, 2, "12/04/2023",0));
//    }

    public List<HoaDon> findAll(){
        return this.dshd;
    }

    public void create(HoaDon hd){
        this.dshd.add(hd);
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.dshd.size(); i++) {
            HoaDon kh = this.dshd.get(i);
            if (kh.getId() == id) {
                this.dshd.remove(i);
            }
        }
    }

    public HoaDon findById(int id)
    {
        for (int i = 0; i < this.dshd.size(); i++) {
            HoaDon m = this.dshd.get(i);
            if (m.getId() == id) {
                return m;
            }
        }

        return null;
    }

    public void update(HoaDon hd){
        for (int i = 0; i < this.dshd.size(); i++){
            HoaDon p = this.dshd.get(i);
            if(p.getId() == hd.getId()){
                this.dshd.set(i, hd);
            }
        }
    }

}
