package com.wildan.Belajar;

import com.wildan.Belajar.model.DataBean;
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
}
