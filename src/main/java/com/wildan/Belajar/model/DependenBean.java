package com.wildan.Belajar.model;

/**
 * Created by DAN on 3/15/2018.
 */
public class DependenBean {
    private DataBean databean;

    public DependenBean(DataBean databean) {
        this.databean = databean;
    }

    public DataBean getDatabean() {
        return databean;
    }

    public void setDatabean(DataBean databean) {
        this.databean = databean;
    }
}
