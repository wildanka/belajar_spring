package com.wildan.Belajar;

import com.wildan.Belajar.model.DataBean;
import com.wildan.Belajar.model.DependenBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


public class BelajarApplication {

	public static void main(String[] args) {
		//saat aplkasi di running, maka semua konfigurasi dari class BelajarConfiguration akan digunakan
		ApplicationContext context =  SpringApplication.run(BelajarConfiguration.class, args); //config berisi bean

//		DataBean dataNama = context.getBean(DataBean.class);
//		System.out.println(dataNama.getNama());

		DependenBean data = context.getBean(DependenBean.class);
		System.out.println(data.getDatabean().getNama()); //karena yang kita ambil adalah variabel "nama" pada class "DataBean"
	}
}
