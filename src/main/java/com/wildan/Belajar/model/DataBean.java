package com.wildan.Belajar.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by DAN on 3/15/2018.
 */
public class DataBean {
    private String nama;

    public DataBean(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @PostConstruct
    public void init(){
        System.out.println("init databean = "+nama);
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Destroy databean = "+nama);
    }
}