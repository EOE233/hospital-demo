package com.zhbit.hospital.bean;

import org.springframework.stereotype.Component;

@Component
public class Patient {

    private int P_id;
    private String P_username;
    private String P_pwd;
    private String P_name;
    private String P_sex;
    private int P_age;
    private String P_num;
    private String P_med;
    private String P_ill;

    @Override
    public String toString() {
        return "Patient{" +
                "P_id=" + P_id +
                ", P_username='" + P_username + '\'' +
                ", P_pwd='" + P_pwd + '\'' +
                ", P_name='" + P_name + '\'' +
                ", P_sex='" + P_sex + '\'' +
                ", P_age=" + P_age +
                ", P_num='" + P_num + '\'' +
                ", P_med='" + P_med + '\'' +
                ", P_ill='" + P_ill + '\'' +
                '}';
    }

    public int getP_id() {
        return P_id;
    }

    public void setP_id(int p_id) {
        P_id = p_id;
    }

    public String getP_username() {
        return P_username;
    }

    public void setP_username(String p_username) {
        P_username = p_username;
    }

    public String getP_pwd() {
        return P_pwd;
    }

    public void setP_pwd(String p_pwd) {
        P_pwd = p_pwd;
    }

    public String getP_name() {
        return P_name;
    }

    public void setP_name(String p_name) {
        P_name = p_name;
    }

    public String getP_sex() {
        return P_sex;
    }

    public void setP_sex(String p_sex) {
        P_sex = p_sex;
    }

    public int getP_age() {
        return P_age;
    }

    public void setP_age(int p_age) {
        P_age = p_age;
    }

    public String getP_num() {
        return P_num;
    }

    public void setP_num(String p_num) {
        P_num = p_num;
    }

    public String getP_med() {
        return P_med;
    }

    public void setP_med(String p_med) {
        P_med = p_med;
    }

    public String getP_ill() {
        return P_ill;
    }

    public void setP_ill(String p_ill) {
        P_ill = p_ill;
    }

    public Patient(int p_id, String p_username, String p_pwd, String p_name, String p_sex, int p_age, String p_num, String p_med, String p_ill) {
        P_id = p_id;
        P_username = p_username;
        P_pwd = p_pwd;
        P_name = p_name;
        P_sex = p_sex;
        P_age = p_age;
        P_num = p_num;
        P_med = p_med;
        P_ill = p_ill;
    }

    public Patient() {
    }
}
