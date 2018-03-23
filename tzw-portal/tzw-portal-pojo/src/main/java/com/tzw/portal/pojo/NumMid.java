package com.tzw.portal.pojo;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018/2/1.
 */
public class NumMid {

    private BigInteger tzw_mid_id;
    private BigInteger tzw_item_id;
    private BigInteger tzw_user_id;
    private BigInteger tzw_num_id;

    private Integer tzw_num_status;
    private String tzw_num_content;
    private String tzw_num_updateDate;
    private String tzw_num_createDate;

    public String getTzw_num_updateDate() {
        return tzw_num_updateDate;
    }

    public void setTzw_num_updateDate(String tzw_num_updateDate) {
        this.tzw_num_updateDate = tzw_num_updateDate;
    }

    public String getTzw_num_createDate() {
        return tzw_num_createDate;
    }

    public void setTzw_num_createDate(String tzw_num_createDate) {
        this.tzw_num_createDate = tzw_num_createDate;
    }

    public BigInteger getTzw_mid_id() {
        return tzw_mid_id;
    }

    public void setTzw_mid_id(BigInteger tzw_mid_id) {
        this.tzw_mid_id = tzw_mid_id;
    }

    public BigInteger getTzw_item_id() {
        return tzw_item_id;
    }

    public void setTzw_item_id(BigInteger tzw_item_id) {
        this.tzw_item_id = tzw_item_id;
    }

    public BigInteger getTzw_user_id() {
        return tzw_user_id;
    }

    public void setTzw_user_id(BigInteger tzw_user_id) {
        this.tzw_user_id = tzw_user_id;
    }

    public BigInteger getTzw_num_id() {
        return tzw_num_id;
    }

    public void setTzw_num_id(BigInteger tzw_num_id) {
        this.tzw_num_id = tzw_num_id;
    }

    public Integer getTzw_num_status() {
        return tzw_num_status;
    }

    public void setTzw_num_status(Integer tzw_num_status) {
        this.tzw_num_status = tzw_num_status;
    }

    public String getTzw_num_content() {
        return tzw_num_content;
    }

    public void setTzw_num_content(String tzw_num_content) {
        this.tzw_num_content = tzw_num_content;
    }
}
