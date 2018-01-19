package com.tzw.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/19.
 */
public class OrderUtil extends Thread{
        private static long orderNum = 0L;
        private static String date ;

        public static void main(String[] args) throws InterruptedException {
          /*  for (int i = 0; i < 10000; i++) {
                System.out.println(OrderUtil.getOrderNo());
                Thread.sleep(1000);
            }*/
            String orderingID= getOrderIdByUUId();
            System.out.println(orderingID);  String orderingID1= getOrderIdByUUId();
            System.out.println(orderingID1);  String orderingID2= getOrderIdByUUId();
            System.out.println(orderingID2);  String orderingID3= getOrderIdByUUId();
            System.out.println(orderingID3);
        }

        /**
         * 生成订单编号
         * @return
         */
    /*    public static synchronized String getOrderNo() {
            String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
            if(date==null||!date.equals(str)){
                date = str;
                orderNum  = 0L;
            }
            orderNum ++;
            long orderNo = Long.parseLong((date)) * 10000;
            orderNo += orderNum;;
            return orderNo+"";
        }
*/
    public static String getOrderIdByUUId() {
        int first = new Random(10).nextInt(8) + 1;
        System.out.println(first);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return first + String.format("%015d", hashCodeV);
    }

    }
