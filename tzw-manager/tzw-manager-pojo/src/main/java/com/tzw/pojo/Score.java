package com.tzw.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Score {

    private BigInteger tzw_score_id;
    private BigInteger tzw_score_num;
    private Timestamp tzw_score_createdate;

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

    public Timestamp getTzw_score_createdate() {
        return tzw_score_createdate;
    }

    public void setTzw_score_createdate(Timestamp tzw_score_createdate) {
        this.tzw_score_createdate = tzw_score_createdate;
    }
}
