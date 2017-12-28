package com.tzw.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/28.
 */
public class mytest {

    public static void main(String[] ar){

        Date date=new Date();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

        String format = simpleDateFormat.format(date);

        System.out.println(format);


    }
}
