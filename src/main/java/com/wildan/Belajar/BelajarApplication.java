package com.wildan.Belajar;

import com.wildan.Belajar.model.ButuhBean;
import com.wildan.Belajar.model.DataBean;
import com.wildan.Belajar.model.DependenBean;
import com.wildan.Belajar.model.Transaksi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


public class BelajarApplication {

	public static void main(String[] args) {
		//saat aplkasi di running, maka semua konfigurasi dari class BelajarConfiguration akan digunakan
		ApplicationContext context =  SpringApplication.run(BelajarConfiguration.class, args); //config berisi bean

//		DataBean dataNama = context.getBean(DataBean.class);
//		System.out.println(dataNama.getNama());

//		DependenBean data = context.getBean(DependenBean.class);
//		System.out.println(data.getDatabean().getNama()); //karena yang kita ambil adalah variabel "nama" pada class "DataBean"


		/*DOI3
		ButuhBean data = context.getBean(ButuhBean.class);

		//sout Wildan Kurniadi (1)
		System.out.println(data.getDataBean().getNama());
		//sout Kurniadi (2)
		System.out.println(data.getDependenBean().getDatabean().getNama());*/

		/* Component */
		Transaksi trx = context.getBean(Transaksi.class);
		String pembayaran = trx.bayar(200000);

		System.out.println(pembayaran);
	}
}
