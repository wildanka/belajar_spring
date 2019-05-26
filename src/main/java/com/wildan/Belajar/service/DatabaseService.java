package com.wildan.Belajar.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by DAN on 5/26/2019.
 * Biasanya saat kita membuat database, otomatis ketika callbacknya dibuat yang perlu kita lakukan adalah connect ke database
 * sebenarnya kita bisa lakukan di dalam constructor, namun hal tersebut tidak direkomendasikan
 * karena proses yang berat jangan dilakukan di constructor
 * jadi lakukanlah di dalam method
 */
@Component
public class DatabaseService {

    /**
     * kita akan memberitahu bahwa method ini perlu dipanggil oleh spring
     * saat pertama kali Spring membuat objek DatabaseService ini
     * Spring secara otomatis akan memanggil method dengan @PostConstruct ketika objek DatabaseService selesai dibuat
     * dan semua DI-nya selesai dimasukkan kedalam DatabaseService
     */
    @PostConstruct
    public void openConnection() {
        System.out.println("MEMBUKA KONEKSI KE DATABASE");
    }

    /**
     * dipanggil ketika databaseService atau aplikasi di shutdown
     * untuk memanggil method yang akan dijalankan saat aplikasi selesai/shutdown kita bisa gunakan @PreDestroy
     */
    @PreDestroy
    public void closeConnection() {
        System.out.println("MENUTUP KONEKSI KE DATABASE");
    }
}
