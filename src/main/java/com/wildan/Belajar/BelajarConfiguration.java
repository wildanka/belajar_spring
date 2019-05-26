package com.wildan.Belajar;

import com.wildan.Belajar.model.OtherBean;
import com.wildan.Belajar.model.DataBean;
import com.wildan.Belajar.model.SampleBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by DAN on 3/15/2018.
 */
@SpringBootApplication
public class BelajarConfiguration {

    @Bean(name = "namaDepan")
    //@Primary
    public DataBean createDataBean(){
        DataBean bean = new DataBean("Wildan");
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
