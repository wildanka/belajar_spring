package com.wildan.Belajar.model;

/**
 * Created by DAN on 3/16/2018.
 */
public class OtherBean {
    private DataBean dataBean;
    private SampleBean sampleBean;

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

}
