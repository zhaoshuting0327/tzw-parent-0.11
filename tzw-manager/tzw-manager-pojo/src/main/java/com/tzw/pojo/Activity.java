package com.tzw.pojo;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018/1/18.
 */
public class Activity {

    private BigInteger tzw_activity_id;
    private String tzw_activity_updateDate;
    private String tzw_activity_createDate;
    private String tzw_activity_startDate;
    private String tzw_activity_stopDate;
    private String tzw_activity_name;
    private String tzw_activity_rule;
    private String tzw_activity_picture;

    public String getTzw_activity_startDate() {
        return tzw_activity_startDate;
    }

    public void setTzw_activity_startDate(String tzw_activity_startDate) {
        this.tzw_activity_startDate = tzw_activity_startDate;
    }

    public String getTzw_activity_stopDate() {
        return tzw_activity_stopDate;
    }

    public void setTzw_activity_stopDate(String tzw_activity_stopDate) {
        this.tzw_activity_stopDate = tzw_activity_stopDate;
    }

    public BigInteger getTzw_activity_id() {
        return tzw_activity_id;
    }

    public void setTzw_activity_id(BigInteger tzw_activity_id) {
        this.tzw_activity_id = tzw_activity_id;
    }

    public String getTzw_activity_updateDate() {
        return tzw_activity_updateDate;
    }

    public void setTzw_activity_updateDate(String tzw_activity_updateDate) {
        this.tzw_activity_updateDate = tzw_activity_updateDate;
    }

    public String getTzw_activity_createDate() {
        return tzw_activity_createDate;
    }

    public void setTzw_activity_createDate(String tzw_activity_createDate) {
        this.tzw_activity_createDate = tzw_activity_createDate;
    }

    public String getTzw_activity_name() {
        return tzw_activity_name;
    }

    public void setTzw_activity_name(String tzw_activity_name) {
        this.tzw_activity_name = tzw_activity_name;
    }

    public String getTzw_activity_rule() {
        return tzw_activity_rule;
    }

    public void setTzw_activity_rule(String tzw_activity_rule) {
        this.tzw_activity_rule = tzw_activity_rule;
    }

    public String getTzw_activity_picture() {
        return tzw_activity_picture;
    }

    public void setTzw_activity_picture(String tzw_activity_picture) {
        this.tzw_activity_picture = tzw_activity_picture;
    }
}
