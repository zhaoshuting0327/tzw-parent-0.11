package com.tzw.common.utils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2018/1/15.
 */
public class Listener01 implements HttpSessionListener {

    public static int count = 1;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
           count++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
    }
}
