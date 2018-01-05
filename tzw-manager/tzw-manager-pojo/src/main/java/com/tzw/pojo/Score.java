package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Score {

    private BigInteger tzw_score_id;
    private BigInteger tzw_score_num;
    private String tzw_score_createDate;
    private String tzw_score_updateDate;
    private String tzw_score_desc;
    private Integer tzw_score_size;
    private Integer tzw_score_type;
    private Integer tzw_score_user_id;

    public Integer getTzw_score_user_id() {
        return tzw_score_user_id;
    }

    public void setTzw_score_user_id(Integer tzw_score_user_id) {
        this.tzw_score_user_id = tzw_score_user_id;
    }

    public Integer getTzw_score_type() {
        return tzw_score_type;
    }

    public void setTzw_score_type(Integer tzw_score_type) {
        this.tzw_score_type = tzw_score_type;
    }

    public Integer getTzw_score_size() {
        return tzw_score_size;
    }

    public void setTzw_score_size(Integer tzw_score_size) {
        this.tzw_score_size = tzw_score_size;
    }

    public String getTzw_score_desc() {
        return tzw_score_desc;
    }

    public void setTzw_score_desc(String tzw_score_desc) {
        this.tzw_score_desc = tzw_score_desc;
    }

    public BigInteger getTzw_score_id() {
        return tzw_score_id;
    }

    public void setTzw_score_id(BigInteger tzw_score_id) {
        this.tzw_score_id = tzw_score_id;
    }

    public BigInteger getTzw_score_num() {
        return tzw_score_num;
    }

    public void setTzw_score_num(BigInteger tzw_score_num) {
        this.tzw_score_num = tzw_score_num;
    }

    public String getTzw_score_createDate() {
        return tzw_score_createDate;
    }

    public void setTzw_score_createDate(String tzw_score_createDate) {
        this.tzw_score_createDate = tzw_score_createDate;
    }

    public String getTzw_score_updateDate() {
        return tzw_score_updateDate;
    }

    public void setTzw_score_updateDate(String tzw_score_updateDate) {
        this.tzw_score_updateDate = tzw_score_updateDate;
    }
}
