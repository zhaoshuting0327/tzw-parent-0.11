package com.twz.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/1/4.
 */
public class CommonInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
          Object handler) throws Exception {
                //获取请求的URL
                String url = request.getRequestURI();
                //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
                if(url.indexOf("login")>=0){
                      return true;
                  }
              //获取Session
              HttpSession session = request.getSession();
              String username = (String)session.getAttribute("loginname");

               if(username != null){
                      return true;
                   }
              //不符合条件的，跳转到登录界面
               request.getRequestDispatcher("/WEB-INF/jsp/login.html").forward(request, response);

                return false;
           }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}