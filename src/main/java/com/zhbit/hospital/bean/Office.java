package com.zhbit.hospital.bean;

import org.springframework.stereotype.Component;

@Component
public class Office {

    private int O_id;
    private String O_name;
    private String O_des;
    private String O_site;

    @Override
    public String toString() {
        return "Office{" +
                "O_id=" + O_id +
                ", O_name='" + O_name + '\'' +
                ", O_des='" + O_des + '\'' +
                ", O_site='" + O_site + '\'' +
                '}';
    }

    public int getO_id() {
        return O_id;
    }

    public void setO_id(int o_id) {
        O_id = o_id;
    }

    public String getO_name() {
        return O_name;
    }

    public void setO_name(String o_name) {
        O_name = o_name;
    }

    public String getO_des() {
        return O_des;
    }

    public void setO_des(String o_des) {
        O_des = o_des;
    }

    public String getO_site() {
        return O_site;
    }

    public void setO_site(String o_site) {
        O_site = o_site;
    }

    public Office(int o_id, String o_name, String o_des, String o_site) {
        O_id = o_id;
        O_name = o_name;
        O_des = o_des;
        O_site = o_site;
    }

    public Office() {
    }
}
