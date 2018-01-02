package com.tzw.pojo;

import java.math.BigInteger;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Owner {

    private BigInteger tzw_owner_id;
    private String tzw_owner_name;
    private  String tzw_owner_pwd;
    private  String tzw_owner_img;

    public BigInteger getTzw_owner_id() {
        return tzw_owner_id;
    }

    public void setTzw_owner_id(BigInteger tzw_owner_id) {
        this.tzw_owner_id = tzw_owner_id;
    }

    public String getTzw_owner_name() {
        return tzw_owner_name;
    }

    public void setTzw_owner_name(String tzw_owner_name) {
        this.tzw_owner_name = tzw_owner_name;
    }

    public String getTzw_owner_pwd() {
        return tzw_owner_pwd;
    }

    public void setTzw_owner_pwd(String tzw_owner_pwd) {
        this.tzw_owner_pwd = tzw_owner_pwd;
    }

    public String getTzw_owner_img() {
        return tzw_owner_img;
    }

    public void setTzw_owner_img(String tzw_owner_img) {
        this.tzw_owner_img = tzw_owner_img;
    }
}
