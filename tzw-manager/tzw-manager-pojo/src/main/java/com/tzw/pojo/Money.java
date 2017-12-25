package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Money {


    private BigInteger tzw_money_id;
    private BigInteger tzw_money_num;
    private Timestamp tzw_money_time;

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

    public Timestamp getTzw_money_time() {
        return tzw_money_time;
    }

    public void setTzw_money_time(Timestamp tzw_money_time) {
        this.tzw_money_time = tzw_money_time;
    }
}
