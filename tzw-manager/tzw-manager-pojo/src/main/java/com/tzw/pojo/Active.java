package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Active {

    private BigInteger tzw_active_id;
    private String tzw_active_name;
    private Double tzw_active_price;
    private String tzw_active_bili;
    private Integer tzw_active_status;
    private Timestamp tzw_active_time;


    public BigInteger getTzw_active_id() {
        return tzw_active_id;
    }

    public void setTzw_active_id(BigInteger tzw_active_id) {
        this.tzw_active_id = tzw_active_id;
    }

    public String getTzw_active_name() {
        return tzw_active_name;
    }

    public void setTzw_active_name(String tzw_active_name) {
        this.tzw_active_name = tzw_active_name;
    }

    public Double getTzw_active_price() {
        return tzw_active_price;
    }

    public void setTzw_active_price(Double tzw_active_price) {
        this.tzw_active_price = tzw_active_price;
    }

    public String getTzw_active_bili() {
        return tzw_active_bili;
    }

    public void setTzw_active_bili(String tzw_active_bili) {
        this.tzw_active_bili = tzw_active_bili;
    }

    public Integer getTzw_active_status() {
        return tzw_active_status;
    }

    public void setTzw_active_status(Integer tzw_active_status) {
        this.tzw_active_status = tzw_active_status;
    }

    public Timestamp getTzw_active_time() {
        return tzw_active_time;
    }

    public void setTzw_active_time(Timestamp tzw_active_time) {
        this.tzw_active_time = tzw_active_time;
    }
}
