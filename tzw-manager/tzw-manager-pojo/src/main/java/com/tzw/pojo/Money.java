package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Money {


    private BigInteger tzw_money_id;
    private BigInteger tzw_money_num;

    private String tzw_money_createDate;
    private String tzw_money_updateDate;

    private int tzw_money_size;
    private String tzw_money_desc;
    private int tzw_money_type;
    private BigInteger  tzw_money_user_id;

    public String getTzw_money_createDate() {
        return tzw_money_createDate;
    }

    public int getTzw_money_size() {
        return tzw_money_size;
    }

    public void setTzw_money_size(int tzw_money_size) {
        this.tzw_money_size = tzw_money_size;
    }

    public String getTzw_money_desc() {
        return tzw_money_desc;
    }

    public void setTzw_money_desc(String tzw_money_desc) {
        this.tzw_money_desc = tzw_money_desc;
    }

    public int getTzw_money_type() {
        return tzw_money_type;
    }

    public void setTzw_money_type(int tzw_money_type) {
        this.tzw_money_type = tzw_money_type;
    }

    public BigInteger getTzw_money_user_id() {
        return tzw_money_user_id;
    }

    public void setTzw_money_user_id(BigInteger tzw_money_user_id) {
        this.tzw_money_user_id = tzw_money_user_id;
    }


    public void setTzw_money_createDate(String tzw_money_createDate) {
        this.tzw_money_createDate = tzw_money_createDate;
    }

    public String getTzw_money_updateDate() {
        return tzw_money_updateDate;
    }

    public void setTzw_money_updateDate(String tzw_money_updateDate) {
        this.tzw_money_updateDate = tzw_money_updateDate;
    }

    public BigInteger getTzw_money_id() {
        return tzw_money_id;
    }

    public void setTzw_money_id(BigInteger tzw_money_id) {
        this.tzw_money_id = tzw_money_id;
    }

    public BigInteger getTzw_money_num() {
        return tzw_money_num;
    }

    public void setTzw_money_num(BigInteger tzw_money_num) {
        this.tzw_money_num = tzw_money_num;
    }

}
