package com.wildan.Belajar;

import com.wildan.Belajar.model.DataBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


public class BelajarApplication {

	public static void main(String[] args) {
		//saat aplkasi di running, maka semua konfigurasi dari class BelajarConfiguration akan digunakan
		ApplicationContext context =  SpringApplication.run(BelajarConfiguration.class, args);

		DataBean dataNama = context.getBean(DataBean.class);
		System.out.println(dataNama.getNama());
	}
}
