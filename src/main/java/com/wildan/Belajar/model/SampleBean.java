package com.wildan.Belajar.model;

/**
 * Created by DAN on 3/15/2018.
 */
public class SampleBean {
    private DataBean databean;

    public SampleBean(DataBean databean) {
        this.databean = databean;
    }

    public DataBean getDatabean() {
        return databean;
    }

    public void setDatabean(DataBean databean) {
        this.databean = databean;
    }
}
