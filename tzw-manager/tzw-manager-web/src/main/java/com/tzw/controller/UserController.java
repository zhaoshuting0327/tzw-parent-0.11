package com.tzw.controller;

import com.tzw.common.utils.CookieUtils;
import com.tzw.pojo.Owner;
import com.tzw.pojo.User;
import com.tzw.service.LoginService;
import com.tzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/12/24.
 */
@Controller
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/user/userList")
    @ResponseBody
    public User getItemById() {
        List<User> userList = userService.userList();


        System.out.println(userList.size()+"ddddddddddddddddd");
        return (User) userList;
    }


    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    @RequestMapping("/login")
    public String toLogin() {

        return "login";
    }

    @RequestMapping("/loginForm")
    public String login(String username , String password, Model model, HttpServletRequest request, HttpServletResponse response) {

        System.out.println(username+"sssssssssssssssssssss"+password);

       if(password == null || "".equals(password)||username == null || "".equals(username)) {
            model.addAttribute("error", "用户名或密码不能为空！");
        }
        else{

           Owner login = this.loginService.login(username, password);

           if (login==null)
           {
               model.addAttribute("error", "用户名或密码错误！");
           }else
           {
               String token = UUID.randomUUID().toString();
               CookieUtils.setCookie(request, response, "token", token);
               model.addAttribute("username",username);
              return "index";
           }
        }
        return "login";
    }

    @RequestMapping("/loginForm/{username}/{password}")
    public String login2(String username , String password, Model model, HttpServletRequest request, HttpServletResponse response) {

        System.out.println(username+"sssssssssssssssssssss"+password);

        if(password == null || "".equals(password)||username == null || "".equals(username)) {
            model.addAttribute("error", "用户名或密码不能为空！");
        }
        else{

            Owner login = this.loginService.login(username, password);

            if (login==null)
            {
                model.addAttribute("error", "用户名或密码错误！");
            }else
            {
                String token = UUID.randomUUID().toString();
                CookieUtils.setCookie(request, response, "token", token);
                model.addAttribute("username",username);
                return "index";
            }
        }
        return "redirect:login2";
    }


}
