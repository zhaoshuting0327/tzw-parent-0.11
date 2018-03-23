package com.tzw.portal.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2018/2/27.
 */
public class TuziwuAlipay {

    /*用官网的sdk进行签名和验签*/

    private static String APP_ID="2016091300498295";

    private static String APP_PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCKXLY3FZ/N6Nvms/9Ci98yCJO15uqibADxlPDmZhW2PTxtDTo/ajMw4YSoCUFowETg8dO7zhZhOfClNcGGkEAByBtus/KXtAx4ptWslkgb32nw+VxTWuWyb3IDRo43aoCINIxrslBd/oQF0fAXYmZZJwzuht3DlxY4Qjy2chpXKG3Oi44MhyLkpe/w3hGg/2H24qA5Prc38ZplIH6+0w6mOdW+T10ZVQdcfzd+f4BAt5kXTHUOy320yBqL8Umass3A5AVujnhm1dnUKwSm3eV07IZ4oTI85WftMNjIlatLmuTX9gPvSdZjO5wP2jN7+BjFTY4edxEPdZ+XPiRgLYGPAgMBAAECggEAV4wqT9iC8UsyOVwTXAwdAg+jRyoBtRwZzMKtW1ukyVcd8PK5tH6CPZ+0zI5usNVXv+3ER8UzK/n5ZtAI0BheJ8JyeS2rhooKih0mfrnojppi8nMWFDgjtzAFOEVgn3foNEbrwwllCNSOvRAFlwZQNIEdEaCMmcHz8U0YFWlFeXfRAUP5B9hEtCyUVAPCCtKKRLfS8dTJHFx8x1foVEXtQnA0FWmjXXUWnPKwSYIOq6A8T29XrtF9hNZUSHeH9XTNINATafIDBMC1NTiyOLEvplYfsggrbx8R0TOgvjQUKbj2ZQUej6/4plKsArdITrTnmwTY27pVEZfsiWwnKqAAIQKBgQDERZsVTLaiXcqFT4BT5ytfEeG3wJzxXg3RcAI+uU0i4ypFy39stctPIOywt24TqRy/a48ZJwlD07baEeSokPKcNMe1vtXwJU4MWHexrLIqoAtPqhrZXClw6phC0UKJUE9QLeThqW0e2crvSRvrHDlIE1NTcARnyM9AweMxP3F6SwKBgQC0d7JzluOP7tWilSq8YGJD5J7G+e4VQlWduES/6MpWfG17UblwLzvcH/TsZCFmYjlJI/NxmQcemlhv3xjmMvwPViW321iKrv/gUAe7E9TORLs/TOh+6R1Z6CoxWj4nNKCNGIZoM1nWib2bL5KUsKjGLRj/lfTqcXZzkV6Agc+LTQKBgQCV1ADwQJCG4AxSuf7fje/o8jCZ4lqsUr0/rT65fSEqSbmicBdE+H5MWHj26gAI2CcO5V/mtor3ES5byB8CoyvhHNV7o0OTwBaVjA9LPecAbQ5VcShv10/3V86F61LcmccCERbRQVIApAerpObAEtqTb9VDM5bZV00HRTtXA/RvgwKBgEHTm1sAQddBddmM8X6u5YkAPk4z4f0NKi+ShDlAD3YGguTFhY9/GyWK3orPZ0NyNpUQMP9Ro0Atam68ANgO5tQtRyrOLni/poPKjVdWv3vRpD9NrUyFeXhO7/z6fstMLffpZzVg7bcMnQWbD6t+2MEYuBKaPzC43E0BTGgxcWPNAoGAfgUwMRje7c74f+XX2P+mGZyXFqAb2hED1Se/5Kjmq+ap+LMyaUsEt4ZPmeLh+zSlLiH/a4xTFnKirdXM8z81DAINsVls4v1lJwz5J7xoJKo9P46sCMxPn+IhA9nQ1IKxr4USZVYaKo3EUT4NVj03szyn8Mgsh/kd5PSLZuiJgpU=";

    private static String CHARSET="utf-8";

    private static String ALIPAY_PUBLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    /*支付 拼接*/
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public void pay(HttpServletRequest request1, HttpServletResponse response1,
                    @RequestParam(required = false, defaultValue = "0") Double cashnum, String mercid, String callback)
    {
        //交易具体描述信息
        String body = request1.getParameter("body");
        //商品标题
        String subject = request1.getParameter("subject");
        //订单号   待生成
        String out_trade_no = request1.getParameter("out_trade_no");
        //总金额
        String total_amount = request1.getParameter("total_amount");
        //销售产品码，商家和支付宝签约的产品码
        String product_code = request1.getParameter("product_code");

        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(body);
        model.setSubject(subject);
        model.setOutTradeNo(out_trade_no);
        model.setTimeoutExpress("30m");
        model.setTotalAmount(total_amount);
        model.setProductCode(product_code);
        request.setBizModel(model);
      //  request.setNotifyUrl("商户外网可以访问的异步地址");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    /*验签*/
    @RequestMapping(value = "/yanqian", method = RequestMethod.POST)
    @ResponseBody
    public void yanqian(HttpServletRequest request1) {

        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request1.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        try {
            boolean flag = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET,"RSA2");
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }
}
