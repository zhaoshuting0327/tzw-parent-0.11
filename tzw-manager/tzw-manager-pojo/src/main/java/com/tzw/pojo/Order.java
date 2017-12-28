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
    private String tzw_order_createDate;
    private String tzw_order_updateDate;
    private int tzw_order_num;
   private  String tzw_order_beizhu;
   private int tzw_order_status;
   private String tzw_user_username;
   private String tzw_item_name;

    public String getTzw_order_createDate() {
        return tzw_order_createDate;
    }

    public void setTzw_order_createDate(String tzw_order_createDate) {
        this.tzw_order_createDate = tzw_order_createDate;
    }

    public String getTzw_order_updateDate() {
        return tzw_order_updateDate;
    }

    public void setTzw_order_updateDate(String tzw_order_updateDate) {
        this.tzw_order_updateDate = tzw_order_updateDate;
    }

    public int getTzw_order_num() {
        return tzw_order_num;
    }

    public void setTzw_order_num(int tzw_order_num) {
        this.tzw_order_num = tzw_order_num;
    }

    public String getTzw_order_beizhu() {
        return tzw_order_beizhu;
    }

    public void setTzw_order_beizhu(String tzw_order_beizhu) {
        this.tzw_order_beizhu = tzw_order_beizhu;
    }

    public int getTzw_order_status() {
        return tzw_order_status;
    }

    public void setTzw_order_status(int tzw_order_status) {
        this.tzw_order_status = tzw_order_status;
    }

    public String getTzw_user_username() {
        return tzw_user_username;
    }

    public void setTzw_user_username(String tzw_user_username) {
        this.tzw_user_username = tzw_user_username;
    }

    public String getTzw_item_name() {
        return tzw_item_name;
    }

    public void setTzw_item_name(String tzw_item_name) {
        this.tzw_item_name = tzw_item_name;
    }
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

}
