package com.wildan.Belajar.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by DAN on 3/16/2018.
 */
public class OtherBean implements ApplicationContextAware{
    private DataBean dataBean;
    private SampleBean sampleBean;
    private ApplicationContext applicationContext;

    public OtherBean(DataBean dataBean, SampleBean sampleBean) {
        this.dataBean = dataBean;
        this.sampleBean = sampleBean;
    }

    public DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public SampleBean getSampleBean() {
        return sampleBean;
    }

    public void setSampleBean(SampleBean sampleBean) {
        this.sampleBean = sampleBean;
    }

    /**
     * kita tidak perlu menambahkan @Autowired, dengan implement ApplicationContextAware maka Spring sudah tau kalau
     * dia harus menginject object ApplicationContext kedalam Bean ini
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void doSomething(){
        if (applicationContext!=null){
            System.out.println("Correct, Context Ada");
        }else{
            System.out.println("Error, Context Tidak Ada");
        }
    }
}
