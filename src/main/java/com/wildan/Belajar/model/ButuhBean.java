package com.wildan.Belajar.model;

/**
 * Created by DAN on 3/16/2018.
 */
public class ButuhBean {
    private DataBean dataBean;
    private DependenBean dependenBean;

    public ButuhBean(DataBean dataBean, DependenBean dependenBean) {
        this.dataBean = dataBean;
        this.dependenBean = dependenBean;
    }

    public DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public DependenBean getDependenBean() {
        return dependenBean;
    }

    public void setDependenBean(DependenBean dependenBean) {
        this.dependenBean = dependenBean;
    }

}
