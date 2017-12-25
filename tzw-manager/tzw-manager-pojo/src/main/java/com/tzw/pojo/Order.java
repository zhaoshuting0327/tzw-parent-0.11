package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Order {

    private BigInteger tzw_order_id;
    private BigInteger tzw_user_id;
    private BigInteger tzw_item_id;
    private String tzw_order_address;
    private Timestamp tzw_order_createdate;

    public BigInteger getTzw_order_id() {
        return tzw_order_id;
    }

    public void setTzw_order_id(BigInteger tzw_order_id) {
        this.tzw_order_id = tzw_order_id;
    }

    public BigInteger getTzw_user_id() {
        return tzw_user_id;
    }

    public void setTzw_user_id(BigInteger tzw_user_id) {
        this.tzw_user_id = tzw_user_id;
    }

    public BigInteger getTzw_item_id() {
        return tzw_item_id;
    }

    public void setTzw_item_id(BigInteger tzw_item_id) {
        this.tzw_item_id = tzw_item_id;
    }

    public String getTzw_order_address() {
        return tzw_order_address;
    }

    public void setTzw_order_address(String tzw_order_address) {
        this.tzw_order_address = tzw_order_address;
    }

    public Timestamp getTzw_order_createdate() {
        return tzw_order_createdate;
    }

    public void setTzw_order_createdate(Timestamp tzw_order_createdate) {
        this.tzw_order_createdate = tzw_order_createdate;
    }
}
