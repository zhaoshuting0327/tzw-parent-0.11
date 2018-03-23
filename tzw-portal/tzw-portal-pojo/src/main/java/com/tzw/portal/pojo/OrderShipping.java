package com.tzw.portal.pojo;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018/1/19.
 */
public class OrderShipping {

    private BigInteger tzw_order_id;
    private BigInteger tzw_order_shipping_id;

    private  String tzw_receiver_name;
    private  String tzw_receiver_address;
    private  String tzw_receiver_phone;
    private  String tzw_shipping_createDate;
    private  String tzw_shipping_updateDate;

    public BigInteger getTzw_order_id() {
        return tzw_order_id;
    }

    public void setTzw_order_id(BigInteger tzw_order_id) {
        this.tzw_order_id = tzw_order_id;
    }

    public BigInteger getTzw_order_shipping_id() {
        return tzw_order_shipping_id;
    }

    public void setTzw_order_shipping_id(BigInteger tzw_order_shipping_id) {
        this.tzw_order_shipping_id = tzw_order_shipping_id;
    }

    public String getTzw_receiver_name() {
        return tzw_receiver_name;
    }

    public void setTzw_receiver_name(String tzw_receiver_name) {
        this.tzw_receiver_name = tzw_receiver_name;
    }

    public String getTzw_receiver_address() {
        return tzw_receiver_address;
    }

    public void setTzw_receiver_address(String tzw_receiver_address) {
        this.tzw_receiver_address = tzw_receiver_address;
    }

    public String getTzw_receiver_phone() {
        return tzw_receiver_phone;
    }

    public void setTzw_receiver_phone(String tzw_receiver_phone) {
        this.tzw_receiver_phone = tzw_receiver_phone;
    }

    public String getTzw_shipping_createDate() {
        return tzw_shipping_createDate;
    }

    public void setTzw_shipping_createDate(String tzw_shipping_createDate) {
        this.tzw_shipping_createDate = tzw_shipping_createDate;
    }

    public String getTzw_shipping_updateDate() {
        return tzw_shipping_updateDate;
    }

    public void setTzw_shipping_updateDate(String tzw_shipping_updateDate) {
        this.tzw_shipping_updateDate = tzw_shipping_updateDate;
    }
}
