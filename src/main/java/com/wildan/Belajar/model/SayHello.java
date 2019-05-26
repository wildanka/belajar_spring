package com.wildan.Belajar.model;

import org.springframework.stereotype.Component;

/**
 * Created by DAN on 5/26/2019.
 */

/**
 * Component akan membuat Bean dari sebuah class.
 * Jika Bean yang akan kita buat masih sederhana,
 * kita dapat menggunakan @Component untuk memudahkan kita ketimbang mengetik method yang panjang di Configuration
 */
@Component
public class SayHello {
    public String sayHello(String name){
        return "Hello "+name;
    }
}
