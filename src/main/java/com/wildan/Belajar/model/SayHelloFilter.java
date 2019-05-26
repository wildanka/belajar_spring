package com.wildan.Belajar.model;

import org.springframework.stereotype.Component;

/**
 * Contoh Jika Bean dengan TipeData yang dibutuhkan tidak tersedia (kita Hapus @Component di class ini
 * Description:
 * Parameter 0 of constructor in com.wildan.Belajar.model.SayHello required a bean of type 'com.wildan.Belajar.model.SayHelloFilter' that could not be found.
 * Action:
 * Consider defining a bean of type 'com.wildan.Belajar.model.SayHelloFilter' in your configuration.
 */
public class SayHelloFilter {
    public String filter(String value){
        return value.toUpperCase();
    }
}
