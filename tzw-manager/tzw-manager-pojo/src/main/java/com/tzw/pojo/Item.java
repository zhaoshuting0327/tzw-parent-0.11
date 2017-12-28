package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Item {

    private BigInteger  tzw_item_id;
    private String  tzw_item_name;
    private Double  tzw_item_price;
    private BigInteger  tzw_item_num;

    private Integer  tzw_item_status;
    private String  tzw_item_picture;
    private String  tzw_item_desc;

    private int tzw_item_active;

    private String tzw_item_createDate;
    private String tzw_item_updateDate;

    public String getTzw_item_createDate() {
        return tzw_item_createDate;
    }

    public void setTzw_item_createDate(String tzw_item_createDate) {
        this.tzw_item_createDate = tzw_item_createDate;
    }

    public String getTzw_item_updateDate() {
        return tzw_item_updateDate;
    }

    public void setTzw_item_updateDate(String tzw_item_updateDate) {
        this.tzw_item_updateDate = tzw_item_updateDate;
    }

    public int getTzw_item_active() {
        return tzw_item_active;
    }

    public void setTzw_item_active(int tzw_item_active) {
        this.tzw_item_active = tzw_item_active;
    }

    private Integer peopleNum;

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
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

    public Double getTzw_item_price() {
        return tzw_item_price;
    }

    public void setTzw_item_price(Double tzw_item_price) {
        this.tzw_item_price = tzw_item_price;
    }

    public BigInteger getTzw_item_num() {
        return tzw_item_num;
    }

    public void setTzw_item_num(BigInteger tzw_item_num) {
        this.tzw_item_num = tzw_item_num;
    }


    public Integer getTzw_item_status() {
        return tzw_item_status;
    }

    public void setTzw_item_status(Integer tzw_item_status) {
        this.tzw_item_status = tzw_item_status;
    }

    public String getTzw_item_picture() {
        return tzw_item_picture;
    }

    public void setTzw_item_picture(String tzw_item_picture) {
        this.tzw_item_picture = tzw_item_picture;
    }

    public String getTzw_item_desc() {
        return tzw_item_desc;
    }

    public void setTzw_item_desc(String tzw_item_desc) {
        this.tzw_item_desc = tzw_item_desc;
    }
}
