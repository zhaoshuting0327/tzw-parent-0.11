package com.tzw.pojo;

import java.math.BigInteger;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Talk {

    private BigInteger tzw_talk_id;
    private BigInteger tzw_user_id;
    private BigInteger tzw_item_id;
    private String tzw_talk_content;

    public BigInteger getTzw_talk_id() {
        return tzw_talk_id;
    }

    public void setTzw_talk_id(BigInteger tzw_talk_id) {
        this.tzw_talk_id = tzw_talk_id;
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

    public String getTzw_talk_content() {
        return tzw_talk_content;
    }

    public void setTzw_talk_content(String tzw_talk_content) {
        this.tzw_talk_content = tzw_talk_content;
    }
}

