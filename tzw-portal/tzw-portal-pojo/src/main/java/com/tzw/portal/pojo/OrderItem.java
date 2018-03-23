package com.tzw.portal.pojo;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018/1/19.
 */
public class OrderItem {

    private BigInteger tzw_order_item_id;
    private BigInteger tzw_order_id;
    private BigInteger tzw_item_id;

    private String tzw_item_name;
    private String tzw_item_picture;

    private Double tzw_item_price;
    private Double tzw_total_fee;

    private Integer tzw_item_num;

    public BigInteger getTzw_order_item_id() {
        return tzw_order_item_id;
    }

    public void setTzw_order_item_id(BigInteger tzw_order_item_id) {
        this.tzw_order_item_id = tzw_order_item_id;
    }

    public BigInteger getTzw_order_id() {
        return tzw_order_id;
    }

    public void setTzw_order_id(BigInteger tzw_order_id) {
        this.tzw_order_id = tzw_order_id;
    }

    public BigInteger getTzw_item_id() {
        return tzw_item_id;
    }

    public void setTzw_item_id(BigInteger tzw_item_id) {
        this.tzw_item_id = tzw_item_id;
    }

    public String getTzw_item_name() {
        return tzw_item_name;
    }

    public void setTzw_item_name(String tzw_item_name) {
        this.tzw_item_name = tzw_item_name;
    }

    public String getTzw_item_picture() {
        return tzw_item_picture;
    }

    public void setTzw_item_picture(String tzw_item_picture) {
        this.tzw_item_picture = tzw_item_picture;
    }

    public Double getTzw_item_price() {
        return tzw_item_price;
    }

    public void setTzw_item_price(Double tzw_item_price) {
        this.tzw_item_price = tzw_item_price;
    }

    public Double getTzw_total_fee() {
        return tzw_total_fee;
    }

    public void setTzw_total_fee(Double tzw_total_fee) {
        this.tzw_total_fee = tzw_total_fee;
    }

    public Integer getTzw_item_num() {
        return tzw_item_num;
    }

    public void setTzw_item_num(Integer tzw_item_num) {
        this.tzw_item_num = tzw_item_num;
    }
}
