package com.wildan.Belajar;

import com.wildan.Belajar.model.OtherBean;
import com.wildan.Belajar.model.DataBean;
import com.wildan.Belajar.model.SampleBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Random;
import java.util.UUID;

/**
 * Created by DAN on 3/15/2018.
 */
@SpringBootApplication
public class BelajarConfiguration {

    /**
     * untuk membuat objek baru setiap kali kita memanggil getBean, gunakan @Scope("prototype")
     * sebenarnya ada juga scope yang lain, yaitu session, request namun itu hanya terjadi di dalam wired (untuk di web)
     * jika scopenya request maka bean akan dibuat setiap request yang berbeda,
     * begitupun dengan session, akan di create setiap session yang berbeda.
     * namun untuk aplikasi console dan desktop hanya ada 2 Scope (singleton/prototype)
     *
     * @return
     */
    @Bean(name = "namaDepan")
    @Scope("prototype")
    public DataBean createDataBean() {
        String random = UUID.randomUUID().toString();
        DataBean bean = new DataBean(random);
        return bean;
    }

    /**
     * jika kita perhatikan lagi saat menjalankan program, semua method dengan @PostConstruct terlihat dipanggil semua
     * namun method @PreDestroy hanya dipanggil yang @Scope-nya singleton saja, mengapa?
     * hal ini dikarenakan Spring hanya bertanggung jawab sampai objek itu selesai dibuat,
     * jadi ketika diberikan ke yang memanggilnya, maka tanggung jawab diberikan kepada si pemanggil tersebut.
     * maka oleh karena itu dalam @Scope prototype Spring tidak akan memanggil @PreDestroy method yang ada di dalam prototype.
     * jadi @PreDestroy:
     * Singleton = Bean masih ada di dalam container Spring
     * Prototype = Bean akan diberikan kepada Bean baru yang memanggil, dan Spring akan lepas tanggung jawab dari Bean Prototype tersebut
     *
     * untuk @PostConstruct:
     * keduanya bisa memanggil @PostConstruct
     * @return
     */
    @Bean(name = "namaBelakang")
    public DataBean createDataBean2() {
        DataBean bean = new DataBean("Kurniadi");
        return bean;
    }
    /*
    * Terdapat 3 cara yang dapat dilakukan jika tipe objek yang di-return sama, namun berbeda nama method
    *
    * 1 : menggunakan @Primary
    * 2 : menggunakan @Unique( name = "namaBean") -- @Qualifier("namaBean")*/

    // jika kita ingin mengambil atribut yang ada pada bean lain (di kasus ini DataBean) alias dependensi
    // maka tidak perlu membuat instance manual ataupun memanggil method beannya,
    // cukup dengan menjadikan object dari bean tersebut sebagai parameter
    @Bean
    public SampleBean createSampleBean(@Qualifier("namaDepan") DataBean dataBean) {
        SampleBean bean = new SampleBean(dataBean);
        return bean;
    }

    @Bean
    public OtherBean createOtherBean(@Qualifier("namaBelakang") DataBean dataBean, SampleBean sampleBean) {
        OtherBean bean = new OtherBean(dataBean, sampleBean);
        return bean;
    }

}
