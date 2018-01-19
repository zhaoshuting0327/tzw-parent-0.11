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

    private String tzw_shipping_code;
    private String tzw_shipping_name;
    private String tzw_buyer_name;

    private Integer tzw_order_rate;
    private Integer tzw_order_rate1;
    private Integer tzw_payment_type;
    private Integer tzw_payment_type1;
    private Integer tzw_order_payment;
    private Integer tzw_order_status;
    private String tzw_order_status1;

    private String tzw_end_time;
    private String tzw_close_time;
    private String tzw_consign_time;
    private String tzw_payment_time;
    private String tzw_order_createdate;
    private String tzw_order_updateDate;
    private BigInteger tzw_order_item_id;

    private String tzw_item_name;
    private String tzw_item_picture;

    private Double tzw_item_price;
    private Double tzw_total_fee;

    private Integer tzw_item_num;

    private BigInteger tzw_order_shipping_id;

    private  String tzw_receiver_name;
    private  String tzw_receiver_address;
    private  String tzw_receiver_phone;
    private  String tzw_shipping_createDate;
    private  String tzw_shipping_updateDate;

    public Integer getTzw_order_rate1() {
        return tzw_order_rate1;
    }

    public void setTzw_order_rate1(Integer tzw_order_rate1) {
        this.tzw_order_rate1 = tzw_order_rate1;
    }

    public BigInteger getTzw_order_item_id() {
        return tzw_order_item_id;
    }

    public void setTzw_order_item_id(BigInteger tzw_order_item_id) {
        this.tzw_order_item_id = tzw_order_item_id;
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

    public BigInteger getTzw_order_shipping_id() {
        return tzw_order_shipping_id;
    }

    public void setTzw_order_shipping_id(BigInteger tzw_order_shipping_id) {
        this.tzw_order_shipping_id = tzw_order_shipping_id;
    }

    public String getTzw_receiver_name() {
        return tzw_receiver_name;
    }

    public void setTzw_receiver_name(String tzw_receiver_name) {
        this.tzw_receiver_name = tzw_receiver_name;
    }

    public String getTzw_receiver_address() {
        return tzw_receiver_address;
    }

    public void setTzw_receiver_address(String tzw_receiver_address) {
        this.tzw_receiver_address = tzw_receiver_address;
    }

    public String getTzw_receiver_phone() {
        return tzw_receiver_phone;
    }

    public void setTzw_receiver_phone(String tzw_receiver_phone) {
        this.tzw_receiver_phone = tzw_receiver_phone;
    }

    public String getTzw_shipping_createDate() {
        return tzw_shipping_createDate;
    }

    public void setTzw_shipping_createDate(String tzw_shipping_createDate) {
        this.tzw_shipping_createDate = tzw_shipping_createDate;
    }

    public String getTzw_shipping_updateDate() {
        return tzw_shipping_updateDate;
    }

    public void setTzw_shipping_updateDate(String tzw_shipping_updateDate) {
        this.tzw_shipping_updateDate = tzw_shipping_updateDate;
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

    public String getTzw_shipping_code() {
        return tzw_shipping_code;
    }

    public void setTzw_shipping_code(String tzw_shipping_code) {
        this.tzw_shipping_code = tzw_shipping_code;
    }

    public String getTzw_shipping_name() {
        return tzw_shipping_name;
    }

    public void setTzw_shipping_name(String tzw_shipping_name) {
        this.tzw_shipping_name = tzw_shipping_name;
    }

    public String getTzw_buyer_name() {
        return tzw_buyer_name;
    }

    public void setTzw_buyer_name(String tzw_buyer_name) {
        this.tzw_buyer_name = tzw_buyer_name;
    }

    public Integer getTzw_order_rate() {
        return tzw_order_rate;
    }

    public void setTzw_order_rate(Integer tzw_order_rate) {
        this.tzw_order_rate = tzw_order_rate;
    }

    public Integer getTzw_payment_type() {
        return tzw_payment_type;
    }

    public void setTzw_payment_type(Integer tzw_payment_type) {
        this.tzw_payment_type = tzw_payment_type;
    }

    public Integer getTzw_payment_type1() {
        return tzw_payment_type1;
    }

    public void setTzw_payment_type1(Integer tzw_payment_type1) {
        this.tzw_payment_type1 = tzw_payment_type1;
    }

    public Integer getTzw_order_payment() {
        return tzw_order_payment;
    }

    public void setTzw_order_payment(Integer tzw_order_payment) {
        this.tzw_order_payment = tzw_order_payment;
    }

    public Integer getTzw_order_status() {
        return tzw_order_status;
    }

    public void setTzw_order_status(Integer tzw_order_status) {
        this.tzw_order_status = tzw_order_status;
    }

    public String getTzw_end_time() {
        return tzw_end_time;
    }

    public void setTzw_end_time(String tzw_end_time) {
        this.tzw_end_time = tzw_end_time;
    }

    public String getTzw_close_time() {
        return tzw_close_time;
    }

    public void setTzw_close_time(String tzw_close_time) {
        this.tzw_close_time = tzw_close_time;
    }

    public String getTzw_consign_time() {
        return tzw_consign_time;
    }

    public void setTzw_consign_time(String tzw_consign_time) {
        this.tzw_consign_time = tzw_consign_time;
    }

    public String getTzw_payment_time() {
        return tzw_payment_time;
    }

    public void setTzw_payment_time(String tzw_payment_time) {
        this.tzw_payment_time = tzw_payment_time;
    }

    public String getTzw_order_createdate() {
        return tzw_order_createdate;
    }

    public void setTzw_order_createdate(String tzw_order_createdate) {
        this.tzw_order_createdate = tzw_order_createdate;
    }

    public String getTzw_order_updateDate() {
        return tzw_order_updateDate;
    }

    public void setTzw_order_updateDate(String tzw_order_updateDate) {
        this.tzw_order_updateDate = tzw_order_updateDate;
    }

    public String getTzw_order_status1() {
        return tzw_order_status1;
    }

    public void setTzw_order_status1(String tzw_order_status1) {
        this.tzw_order_status1 = tzw_order_status1;
    }
}
