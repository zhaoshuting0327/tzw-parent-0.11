package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class User {

    private BigInteger tzw_user_id;
    private String tzw_user_username;
    private String tzw_user_pwd;
    private String tzw_user_phone;

    private String tzw_user_address;
    private BigInteger tzw_user_score;
    private Double tzw_user_money;
    private Integer tzw_user_ordernum;

    private String tzw_user_createDate;
    private String tzw_user_updateDate;

    private Integer tzw_user_sex;
    private String tzw_user_sex1;

    private Integer  tzw_user_vip;
    private String  tzw_user_vip1;

    public String getTzw_user_vip1() {
        return tzw_user_vip1;
    }

    public void setTzw_user_vip1(String tzw_user_vip1) {
        this.tzw_user_vip1 = tzw_user_vip1;
    }

    public Integer getTzw_user_vip() {
        return tzw_user_vip;
    }

    public void setTzw_user_vip(Integer tzw_user_vip) {
        this.tzw_user_vip = tzw_user_vip;
    }

    public String getTzw_user_sex1() {
        return tzw_user_sex1;
    }

    public void setTzw_user_sex1(String tzw_user_sex1) {
        this.tzw_user_sex1 = tzw_user_sex1;
    }

    public Integer getTzw_user_sex() {
        return tzw_user_sex;
    }

    public void setTzw_user_sex(Integer tzw_user_sex) {
        this.tzw_user_sex = tzw_user_sex;
    }

    public BigInteger getTzw_user_id() {
        return tzw_user_id;
    }

    public void setTzw_user_id(BigInteger tzw_user_id) {
        this.tzw_user_id = tzw_user_id;
    }

    public String getTzw_user_username() {
        return tzw_user_username;
    }

    public void setTzw_user_username(String tzw_user_username) {
        this.tzw_user_username = tzw_user_username;
    }

    public String getTzw_user_pwd() {
        return tzw_user_pwd;
    }

    public void setTzw_user_pwd(String tzw_user_pwd) {
        this.tzw_user_pwd = tzw_user_pwd;
    }

    public String getTzw_user_phone() {
        return tzw_user_phone;
    }

    public void setTzw_user_phone(String tzw_user_phone) {
        this.tzw_user_phone = tzw_user_phone;
    }

    public String getTzw_user_address() {
        return tzw_user_address;
    }

    public void setTzw_user_address(String tzw_user_address) {
        this.tzw_user_address = tzw_user_address;
    }

    public BigInteger getTzw_user_score() {
        return tzw_user_score;
    }

    public void setTzw_user_score(BigInteger tzw_user_score) {
        this.tzw_user_score = tzw_user_score;
    }

    public Double getTzw_user_money() {
        return tzw_user_money;
    }

    public void setTzw_user_money(Double tzw_user_money) {
        this.tzw_user_money = tzw_user_money;
    }

    public Integer getTzw_user_ordernum() {
        return tzw_user_ordernum;
    }

    public void setTzw_user_ordernum(Integer tzw_user_ordernum) {
        this.tzw_user_ordernum = tzw_user_ordernum;
    }

    public String getTzw_user_createDate() {
        return tzw_user_createDate;
    }

    public void setTzw_user_createDate(String tzw_user_createDate) {
        this.tzw_user_createDate = tzw_user_createDate;
    }

    public String getTzw_user_updateDate() {
        return tzw_user_updateDate;
    }

    public void setTzw_user_updateDate(String tzw_user_updateDate) {
        this.tzw_user_updateDate = tzw_user_updateDate;
    }
}
