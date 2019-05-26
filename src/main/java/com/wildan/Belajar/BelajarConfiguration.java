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
     * @return
     */
    @Bean(name = "namaDepan")
    @Scope("singleton")
    public DataBean createDataBean(){
        String random = UUID.randomUUID().toString();
        DataBean bean = new DataBean(random);
        return bean;
    }

    @Bean(name = "namaBelakang")
    public DataBean createDataBean2(){
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
    public SampleBean createSampleBean(@Qualifier("namaDepan") DataBean dataBean){
        SampleBean bean = new SampleBean(dataBean);
        return bean;
    }

    @Bean
    public OtherBean createOtherBean(@Qualifier("namaBelakang") DataBean dataBean, SampleBean sampleBean){
        OtherBean bean = new OtherBean(dataBean, sampleBean);
        return bean;
    }

}
