package com.wildan.Belajar.model;

import org.springframework.stereotype.Component;

/**
 * Created by DAN on 3/16/2018.
 */
@Component
public class Transaksi {

    public String bayar(int bayar){
        return "Pembayaran : Rp."+bayar;
    }
}
