package com.wildan.Belajar;

import com.wildan.Belajar.model.ButuhBean;
import com.wildan.Belajar.model.DataBean;
import com.wildan.Belajar.model.DependenBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Created by DAN on 3/15/2018.
 */
@SpringBootApplication
public class BelajarConfiguration {

    @Bean(name = "1")
    //@Primary
    public DataBean createDataBean(){
        DataBean bean = new DataBean("Wildan Kurniadi");
        return bean;
    }

    @Bean(name = "2")
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
    // cukup dengan menjadikan object ari bean tersebut sebagai parameter
    @Bean
    public DependenBean createDependenBean(@Qualifier("1") DataBean dataBean){
        DependenBean bean = new DependenBean(dataBean);
        return bean;
    }

    @Bean
    public ButuhBean ButuhBean(@Qualifier("2") DataBean dataBean, DependenBean dependenBean){
        ButuhBean bean = new ButuhBean(dataBean,dependenBean);
        return bean;
    }

}
