package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Score {

    private BigInteger tzw_score_id;
    private BigInteger tzw_score_num;
    private Timestamp tzw_score_createDate;
    private Timestamp tzw_score_updateDate;

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

    public Timestamp getTzw_score_createDate() {
        return tzw_score_createDate;
    }

    public void setTzw_score_createDate(Timestamp tzw_score_createDate) {
        this.tzw_score_createDate = tzw_score_createDate;
    }

    public Timestamp getTzw_score_updateDate() {
        return tzw_score_updateDate;
    }

    public void setTzw_score_updateDate(Timestamp tzw_score_updateDate) {
        this.tzw_score_updateDate = tzw_score_updateDate;
    }
}
