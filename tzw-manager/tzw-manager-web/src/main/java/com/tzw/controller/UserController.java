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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @RequestMapping("/index_v1")
    public String index_v1() {

        return "index_v1";
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



    /*user列表展示*/

    @RequestMapping("user_list")
    public String user_list()
    {
        return "user_list";
    }

    @RequestMapping("user_listJson")
    @ResponseBody
    public List<User> user_listJson(HttpServletRequest request, HttpSession httpSession, @RequestParam(name="pageNum",defaultValue = "1")  Integer pageNum,
                                @RequestParam(name="pageSize",defaultValue = "10")  Integer pageSize, Model model)
    {

        String lname = request.getParameter("lname");

        if (lname!=null||!"".equals(lname))
        {
            System.out.println(lname);
            httpSession.setAttribute("lname",lname);
        }

        lname= (String) httpSession.getAttribute("lname");

        List<User> userList = this.userService.findUserList(lname, pageNum, pageSize);

        return userList;
    }



}
