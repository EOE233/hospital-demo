package com.zhbit.hospital.bean;

import org.springframework.stereotype.Component;

/**
 * 排班信息
 */
@Component
public class SCH {

    private int D_id;
    private int SUR_id;
    private String SCH_date;
    private String SCH_time;
    private int SCH_size;
    private int SCH_booked;

    @Override
    public String toString() {
        return "SCH{" +
                "D_id=" + D_id +
                ", SUR_id=" + SUR_id +
                ", SCH_date='" + SCH_date + '\'' +
                ", SCH_time='" + SCH_time + '\'' +
                ", SCH_size=" + SCH_size +
                ", SCH_booked=" + SCH_booked +
                '}';
    }

    public int getD_id() {
        return D_id;
    }

    public void setD_id(int d_id) {
        D_id = d_id;
    }

    public int getSUR_id() {
        return SUR_id;
    }

    public void setSUR_id(int SUR_id) {
        this.SUR_id = SUR_id;
    }

    public String getSCH_date() {
        return SCH_date;
    }

    public void setSCH_date(String SCH_date) {
        this.SCH_date = SCH_date;
    }

    public String getSCH_time() {
        return SCH_time;
    }

    public void setSCH_time(String SCH_time) {
        this.SCH_time = SCH_time;
    }

    public int getSCH_size() {
        return SCH_size;
    }

    public void setSCH_size(int SCH_size) {
        this.SCH_size = SCH_size;
    }

    public int getSCH_booked() {
        return SCH_booked;
    }

    public void setSCH_booked(int SCH_booked) {
        this.SCH_booked = SCH_booked;
    }

    public SCH(int d_id, int SUR_id, String SCH_date, String SCH_time, int SCH_size, int SCH_booked) {
        D_id = d_id;
        this.SUR_id = SUR_id;
        this.SCH_date = SCH_date;
        this.SCH_time = SCH_time;
        this.SCH_size = SCH_size;
        this.SCH_booked = SCH_booked;
    }

    public SCH() {
    }
}

