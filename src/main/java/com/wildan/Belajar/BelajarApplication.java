package com.wildan.Belajar;

import com.wildan.Belajar.model.DataBean;
import com.wildan.Belajar.model.OtherBean;
import com.wildan.Belajar.model.SampleBean;
import com.wildan.Belajar.model.SayHello;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import javax.print.attribute.standard.MediaSize;


public class BelajarApplication {

    public static void main(String[] args) {
        //saat aplkasi di running, maka semua konfigurasi dari class BelajarConfiguration akan digunakan,
        /**
         * umumnya jika kita membuat sebuah aplikasi, ApplicationContextnya akan kita define di main programnya.
         * namun bagaimana jika kita perlu untuk mengakses context tersebut dari Bean, enggaplah OtherBean
         */
        // ini adalah container
        ApplicationContext context = SpringApplication.run(BelajarConfiguration.class, args); //config berisi bean

//		DataBean dataNama = context.getBean(DataBean.class);
//		System.out.println(dataNama.getNama());

//		SampleBean data = context.getBean(SampleBean.class);
//		System.out.println(data.getDatabean().getNama()); //karena yang kita ambil adalah variabel "nama" pada class "DataBean"

        OtherBean data = context.getBean(OtherBean.class);

        //sout Wildan Kurniadi (first_name)
        // DataBean (Kurniadi) -> OtherBean
        //System.out.println(data.getDataBean().getNama());

        //sout Kurniadi (last_name)
        // DataBean (Wildan) -> SampleBean -> OtherBean
        //System.out.println(data.getSampleBean().getDatabean().getNama());

//        SayHello hello = context.getBean(SayHello.class);
//        String response = hello.sayHello("Wildan Kurniadi");
//        System.out.println(response);

        //secara default Spring akan membuat Bean secara singleton,
        // dengan demikian value dari Bean yang ditampilkan dari perintah dibawah akan bernilai sama
//        DataBean wildan1 = context.getBean("namaDepan", DataBean.class);
//        //saat kita mengubah salah satu variable bean, maka akan mengubah data bean ketika selanjutnya digunakan lagi
//        wildan1.setNama("wildan");
//        System.out.println(wildan1.getNama());
//        DataBean wildan2 = context.getBean("namaDepan", DataBean.class);
//        System.out.println(wildan2.getNama());
//        DataBean wildan3 = context.getBean("namaDepan", DataBean.class);
//        System.out.println(wildan3.getNama());
//
//        //oleh karena itu ada yang namanya Scope,
//        // scope merupakan cara membuat Bean oleh Spring
//        // secara default Scope Spring bersifat Singleton. Artinya Spring hanya akan membuat Bean 1 kali
//
//        //sekarang kita coba penerapan Scope untuk parameter pada saat injection
//        SampleBean sampleBean = context.getBean(SampleBean.class);
//        System.out.println(sampleBean.getDatabean().getNama());

        // Aware
        /**
         * Aware sebenarnya adalah sebuah interface dimana nanti interface itu akan mengimplementasi sebuah method
         * dimana method itu akan di inject oleh spring sesuai dengan parameternya,
         * ada beberapa jenis aware di dalam Spring, contoh yang sering digunakan adalah ApplicationContextAware
         * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/Aware.html
         * didalam ApplicationContextAware sendiri terdapat sebuah method yaitu :
         * void setApplicationContext, dimana yang akan diinject adalah application contextnya dia sendiri.
         * di beberapa contoh sebelumnya kita sudah bahas cara meng-inject bean ke bean lainnya lagi. sedangkan terkadang
         * mungkin saja di dalam Bean tersebut kita butuh mendapatkan application context si Springnya,
         * caranya cukup mudah yaitu dengan meng-implement ApplicationContextAware
         * BeanNameAware:
         * agar Object Bean tersebut bisa tahu Nama Bean dia di dalam Container Spring
         *
         */
        OtherBean otherBean = context.getBean(OtherBean.class);
        otherBean.doSomething();
    }
}
