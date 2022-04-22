package com.zhbit.hospital.bean;

import org.springframework.stereotype.Component;

@Component
public class Doctor {

    private int D_id;
    private String D_username;
    private String D_pwd;
    private String D_name;
    private int D_age;
    private String D_sex;
    private String SUR_id;

    @Override
    public String toString() {
        return "Doctor{" +
                "D_id=" + D_id +
                ", D_username='" + D_username + '\'' +
                ", D_pwd='" + D_pwd + '\'' +
                ", D_name='" + D_name + '\'' +
                ", D_age=" + D_age +
                ", D_sex='" + D_sex + '\'' +
                ", SUR_id='" + SUR_id + '\'' +
                '}';
    }

    public int getD_id() {
        return D_id;
    }

    public void setD_id(int d_id) {
        D_id = d_id;
    }

    public String getD_username() {
        return D_username;
    }

    public void setD_username(String d_username) {
        D_username = d_username;
    }

    public String getD_pwd() {
        return D_pwd;
    }

    public void setD_pwd(String d_pwd) {
        D_pwd = d_pwd;
    }

    public String getD_name() {
        return D_name;
    }

    public void setD_name(String d_name) {
        D_name = d_name;
    }

    public int getD_age() {
        return D_age;
    }

    public void setD_age(int d_age) {
        D_age = d_age;
    }

    public String getD_sex() {
        return D_sex;
    }

    public void setD_sex(String d_sex) {
        D_sex = d_sex;
    }

    public String getSUR_id() {
        return SUR_id;
    }

    public void setSUR_id(String SUR_id) {
        this.SUR_id = SUR_id;
    }

    public Doctor(int d_id, String d_username, String d_pwd, String d_name, int d_age, String d_sex, String SUR_id) {
        D_id = d_id;
        D_username = d_username;
        D_pwd = d_pwd;
        D_name = d_name;
        D_age = d_age;
        D_sex = d_sex;
        this.SUR_id = SUR_id;
    }

    public Doctor() {
    }
}
