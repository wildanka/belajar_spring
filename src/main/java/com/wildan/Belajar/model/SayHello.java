package com.wildan.Belajar.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Component akan membuat Bean dari sebuah class.
 * Jika Bean yang akan kita buat masih sederhana,
 * kita dapat menggunakan @Component untuk memudahkan kita ketimbang mengetik method yang panjang di Configuration
 */
@Component
public class SayHello {
    private SayHelloFilter filter;

    /**
     * dengan menambahkan @Autowired kita memberitahu Spring bahwa di dalam constructor yang kita buat
     * kita membutuhkan Di yang perlu dimasukkan oleh Spring
     * @param filter
     * intinya jika kita ingin melakukan DI melalui constructor atau method,
     * kita cukup tambahkan di dalam constructor atau method tersebut @Autowired.
     * Dengan demikian maka secara otomatis Spring akan mendeteksi parameter apa yang dibutuhkan
     * lalu Spring akan meng-inject Bean yang sesuai dengan tipe data tersebut. namun jikalau tidak ada Bean dengan Tipedata tersebut
     * maka akan terjadi error
     */
    @Autowired
    public SayHello(SayHelloFilter filter) {
        this.filter = filter;
    }

    public String sayHello(String name){
        return filter.filter("Hello "+name);
    }
}
