package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Money {


    private BigInteger tzw_money_id;
    private BigInteger tzw_money_num;

    private Timestamp tzw_money_createDate;
    private Timestamp tzw_money_updateDate;

    public Timestamp getTzw_money_createDate() {
        return tzw_money_createDate;
    }

    public void setTzw_money_createDate(Timestamp tzw_money_createDate) {
        this.tzw_money_createDate = tzw_money_createDate;
    }

    public Timestamp getTzw_money_updateDate() {
        return tzw_money_updateDate;
    }

    public void setTzw_money_updateDate(Timestamp tzw_money_updateDate) {
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
