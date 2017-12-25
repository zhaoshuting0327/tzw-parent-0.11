package com.tzw.pojo;

import java.math.BigInteger;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Owner {

    private BigInteger tzw_owner_id;
    private String tzw_active_name;
    private  String tzw_active_pwd;

    public BigInteger getTzw_owner_id() {
        return tzw_owner_id;
    }

    public void setTzw_owner_id(BigInteger tzw_owner_id) {
        this.tzw_owner_id = tzw_owner_id;
    }

    public String getTzw_active_name() {
        return tzw_active_name;
    }

    public void setTzw_active_name(String tzw_active_name) {
        this.tzw_active_name = tzw_active_name;
    }

    public String getTzw_active_pwd() {
        return tzw_active_pwd;
    }

    public void setTzw_active_pwd(String tzw_active_pwd) {
        this.tzw_active_pwd = tzw_active_pwd;
    }
}
