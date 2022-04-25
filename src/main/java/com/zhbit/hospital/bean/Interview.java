package com.zhbit.hospital.bean;

import org.springframework.stereotype.Component;

/**
 * 预约信息
 */
@Component
public class Interview {

    private int I_id;
    private int P_id;
    private String I_date;
    private String I_time;
    private int D_id;

    @Override
    public String toString() {
        return "Interview{" +
                "I_id=" + I_id +
                ", P_id=" + P_id +
                ", I_date='" + I_date + '\'' +
                ", I_time='" + I_time + '\'' +
                ", D_id=" + D_id +
                '}';
    }

    public int getI_id() {
        return I_id;
    }

    public void setI_id(int i_id) {
        I_id = i_id;
    }

    public int getP_id() {
        return P_id;
    }

    public void setP_id(int p_id) {
        P_id = p_id;
    }

    public String getI_date() {
        return I_date;
    }

    public void setI_date(String i_date) {
        I_date = i_date;
    }

    public String getI_time() {
        return I_time;
    }

    public void setI_time(String i_time) {
        I_time = i_time;
    }

    public int getD_id() {
        return D_id;
    }

    public void setD_id(int d_id) {
        D_id = d_id;
    }

    public Interview(int i_id, int p_id, String i_date, String i_time, int d_id) {
        I_id = i_id;
        P_id = p_id;
        I_date = i_date;
        I_time = i_time;
        D_id = d_id;
    }

    public Interview() {
    }
}
