package com.wildan.Belajar;

import com.wildan.Belajar.model.DataBean;
import com.wildan.Belajar.model.DependenBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by DAN on 3/15/2018.
 */
@SpringBootApplication
public class BelajarConfiguration {

    @Bean
    public DataBean createDataBean(){
        DataBean bean = new DataBean("Wildan Kurniadi");
        return bean;
    }

    // jika kita ingin mengambil atribut yang ada pada bean lain (di kasus ini DataBean) alias dependensi
    // maka tidak perlu membuat instance manual ataupun memanggil method beannya,
    // cukup dengan menjadikan object ari bean tersebut sebagai parameter
    @Bean
    public DependenBean createDependenBean(DataBean dataBean){
        DependenBean bean = new DependenBean(dataBean);
        return bean;
    }
}
