package com.zhbit.hospital.bean;

import org.springframework.stereotype.Component;

@Component
public class Administrator {
    private String M_id;
    private String M_pwd;

    @Override
    public String toString() {
        return "Administrator{" +
                "M_id='" + M_id + '\'' +
                ", M_pwd='" + M_pwd + '\'' +
                '}';
    }

    public String getM_id() {
        return M_id;
    }

    public void setM_id(String m_id) {
        M_id = m_id;
    }

    public String getM_pwd() {
        return M_pwd;
    }

    public void setM_pwd(String m_pwd) {
        M_pwd = m_pwd;
    }

    public Administrator(String m_id, String m_pwd) {
        M_id = m_id;
        M_pwd = m_pwd;
    }

    public Administrator() {
    }
}
