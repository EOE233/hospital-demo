package com.zhbit.hospital.bean;

import org.springframework.stereotype.Component;

@Component
public class Surgery {

    private int SUR_id;
    private int O_id;
    private String  SUR_site;
    private String SUR_mana;

    @Override
    public String toString() {
        return "Surgery{" +
                "SuR_id=" + SUR_id +
                ", O_id=" + O_id +
                ", SUR_site='" + SUR_site + '\'' +
                ", SUR_mana='" + SUR_mana + '\'' +
                '}';
    }

    public int getSUR_id() {
        return SUR_id;
    }

    public void setSUR_id(int suR_id) {
        SUR_id = suR_id;
    }

    public int getO_id() {
        return O_id;
    }

    public void setO_id(int o_id) {
        O_id = o_id;
    }

    public String getSUR_site() {
        return SUR_site;
    }

    public void setSUR_site(String SUR_site) {
        this.SUR_site = SUR_site;
    }

    public String getSUR_mana() {
        return SUR_mana;
    }

    public void setSUR_mana(String SUR_mana) {
        this.SUR_mana = SUR_mana;
    }

    public Surgery(int suR_id, int o_id, String SUR_site, String SUR_mana) {
        SUR_id = suR_id;
        O_id = o_id;
        this.SUR_site = SUR_site;
        this.SUR_mana = SUR_mana;
    }

    public Surgery() {
    }
}
