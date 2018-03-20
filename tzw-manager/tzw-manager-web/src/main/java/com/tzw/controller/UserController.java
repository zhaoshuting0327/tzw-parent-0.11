package com.tzw.controller;

import com.tzw.common.utils.CookieUtils;
import com.tzw.common.utils.Fenye;
import com.tzw.common.utils.Listener01;
import com.tzw.common.utils.MD5Util;
import com.tzw.pojo.*;
import com.tzw.service.LoginService;
import com.tzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;

import java.util.*;

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

    @RequestMapping("/index")
    public String index(String username,String img,Model model) {

        model.addAttribute("username",username);
        model.addAttribute("img",img);
        model.addAttribute("count",Listener01.count);

        return "index";
    }
    @RequestMapping(value = "/loginForm",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpSession httpSession,Model model, HttpServletRequest request, HttpServletResponse response) {

        Map<String,Object> map=new HashMap<>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String  messg="";

        System.out.println(password);

        if(password == null || "".equals(password)||username == null || "".equals(username)) {
           messg="用户名或密码不能为空!";
           map.put("messg",messg);
           map.put("ok",0);
           return map;
        }
        else{
          //  String s = MD5Util.string2MD5(password);
            String s = MD5Util.string2MD5(password);
            Owner login = this.loginService.login(username, s);

           if (login==null)
           {
               messg="用户名或密码错误！";
               map.put("messg",messg);
               map.put("ok",0);
               return map;
           }else
           {
               String token = UUID.randomUUID().toString();

               httpSession.setAttribute("loginname", username);

               CookieUtils.setCookie(request, response, "token", token);

               map.put("username",username);
               map.put("img",login.getTzw_owner_img());
               map.put("lu","index");
               map.put("ok",1);
              return map;
           }
        }
    }
    /*user列表展示*/

    @RequestMapping("user_list")
    public String user_list()
    {
        return "user_list";
    }

    @RequestMapping("user_listJson")
    @ResponseBody
    public HashMap<String, Object> user_listJson(HttpServletRequest request, HttpSession httpSession)
    {

        String lname = request.getParameter("lname");

        if (lname!=null||!"".equals(lname))
        {
            httpSession.setAttribute("lname",lname);
        }

        lname= (String) httpSession.getAttribute("lname");


        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int userCount = this.userService.getUserCount(lname);
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,userCount );
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");
        List<User> userList = this.userService.findUserList(lname, Integer.parseInt(cpages), size);


        HashMap<String,Object> map=new HashMap<>();

        map.put("list",userList);
        map.put("epage",epage);
        map.put("cpage",cpages);
        int page=0;
        if(userCount%10==0)
        {
            page=userCount/10;
        }else
        {
            page=userCount/10+1;
        }


        map.put("total", page);
        map.put("totalnum", userCount);

        return map;
    }


    /*loginOut*/
    @RequestMapping("loginOut")
    public String loginOut(HttpSession httpSession)
    {
        httpSession.invalidate();
        return "login";
    }


      //用户删除
      @RequestMapping("user/del")
      @ResponseBody
      public int del(BigInteger tzw_item_id)
      {
          this.userService.deleteUser(tzw_item_id);
          return 1;
      }
     //用户修改

    @RequestMapping("toUpdateUser")
    public String toUpdateItem(BigInteger tzw_user_id,Model model)
    {
       model.addAttribute("tzw_user_id",tzw_user_id);
        return "user_update";
    }

    @RequestMapping("huixianUser")
    @ResponseBody
    public User huixianItem(HttpServletRequest request)
    {
        String tzw_user_id = request.getParameter("tzw_user_id");
        String tzw_user_createDate = request.getParameter("tzw_user_createDate");

        int i = Integer.parseInt(tzw_user_id);

        User user = this.userService.findUserById(BigInteger.valueOf(i));

        return user;
    }

    @RequestMapping("user_update_commit")
    @ResponseBody
    public boolean user_update_commit(HttpServletRequest request)
    {
        String tzw_user_id = request.getParameter("tzw_user_id");
        String tzw_user_username = request.getParameter("tzw_user_username");
        String tzw_user_pwd = request.getParameter("tzw_user_pwd");
        String tzw_user_phone = request.getParameter("tzw_user_phone");
        String tzw_user_address = request.getParameter("tzw_user_address");
        String tzw_score_num = request.getParameter("tzw_score_num");
        String tzw_user_money = request.getParameter("tzw_user_money");
        String tzw_user_sex = request.getParameter("tzw_user_sex");
        String tzw_user_vip = request.getParameter("tzw_user_vip");
        String tzw_user_createDate = request.getParameter("tzw_user_createDate");
        String tzw_money_num = request.getParameter("tzw_money_num");

        User u=new User();

        u.setTzw_user_sex(Integer.parseInt(tzw_user_sex));

        int i = Integer.parseInt(tzw_user_id);
        u.setTzw_user_id(BigInteger.valueOf(i));

        u.setTzw_user_username(tzw_user_username);
        u.setTzw_user_pwd(tzw_user_pwd);

        u.setTzw_user_phone(tzw_user_phone);
        u.setTzw_user_address(tzw_user_address);

        int i1 = Integer.parseInt(tzw_score_num);
        u.setTzw_user_score(BigInteger.valueOf(i1));

        u.setTzw_user_money(Double.parseDouble(tzw_user_money));
        u.setTzw_user_vip(Integer.parseInt(tzw_user_vip));

        u.setTzw_user_createDate(tzw_user_createDate);

        this.userService.updateUser(u,tzw_money_num,tzw_score_num);

        return true;
    }

    //积分详情
   @RequestMapping("scoreMessage")
    public String scoreMessage(BigInteger tzw_user_id,Model model)
   {
       System.out.println("进入详情页面");
       System.out.println(tzw_user_id+"积分详情");

       User userById = this.userService.findUserById(tzw_user_id);

       String tzw_user_username = userById.getTzw_user_username();

       model.addAttribute("tzw_user_id",tzw_user_id);
       model.addAttribute("tzw_user_username",tzw_user_username);
       return "score_message";
   }

   //scoreMessageJson

    @RequestMapping("scoreMessageJson")
    @ResponseBody
    public  HashMap<String, Object> scoreMessageJson(BigInteger tzw_user_id,HttpServletRequest request)
    {

        System.out.println("scoreMessageJson:"+tzw_user_id);

        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int userCount = this.userService.getScoreCount(tzw_user_id);
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,userCount );
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");

        System.out.println("scoreMessageJson:"+cpages);
        List<Score> scoreList = this.userService.findScoreById( Integer.parseInt(cpages), size,tzw_user_id);

        HashMap<String,Object> map=new HashMap<>();

        map.put("list",scoreList);
        map.put("epage",epage);
        map.put("cpage",cpages);
        int page=0;
        if(userCount%10==0)
        {
            page=userCount/10;
        }else
        {
            page=userCount/10+1;
        }
        map.put("total", page);
        map.put("totalnum", userCount);
        return map;

    }

    //余额详情
    @RequestMapping("moneyMessage")
    public String moneyMessage(BigInteger tzw_user_id,Model model)
    {
        System.out.println("进入详情页面");
        System.out.println(tzw_user_id+"积分详情");

        User userById = this.userService.findUserById(tzw_user_id);

        String tzw_user_username = userById.getTzw_user_username();

        model.addAttribute("tzw_user_id",tzw_user_id);
        model.addAttribute("tzw_user_username",tzw_user_username);
        return "money_message";
    }


    @RequestMapping("moneyMessageJson")
    @ResponseBody
    public  HashMap<String, Object> moneyMessageJson(BigInteger tzw_user_id,HttpServletRequest request)
    {

        System.out.println("moneyMessageJson:"+tzw_user_id);

        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int userCount = this.userService.getMoneyCount(tzw_user_id);
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,userCount );

        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");

        System.out.println("scoreMessageJson:"+cpages);
        List<Money> scoreList = this.userService.findMoneyById( Integer.parseInt(cpages), size,tzw_user_id);

        HashMap<String,Object> map=new HashMap<>();

        map.put("list",scoreList);
        map.put("epage",epage);
        map.put("cpage",cpages);
        int page=0;
        if(userCount%10==0)
        {
            page=userCount/10;
        }else
        {
            page=userCount/10+1;
        }
        map.put("total", page);
        map.put("totalnum", userCount);
        return map;

    }


    //订单详情
    @RequestMapping("orderMessage")
    public String orderMessage(BigInteger tzw_user_id,Model model)
    {
        System.out.println("进入详情页面");
        System.out.println(tzw_user_id+"积分详情");

        User userById = this.userService.findUserById(tzw_user_id);

        String tzw_user_username = userById.getTzw_user_username();

        model.addAttribute("tzw_user_id",tzw_user_id);
        model.addAttribute("tzw_user_username",tzw_user_username);
        return "order_message";
    }

    //scoreMessageJson

    @RequestMapping("orderMessageJson")
    @ResponseBody
    public  HashMap<String, Object> orderMessageJson(BigInteger tzw_user_id,HttpServletRequest request)
    {

        System.out.println("orderMessageJson:"+tzw_user_id);

        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int userCount = this.userService.getOrderCount(tzw_user_id);
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,userCount );
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");

        System.out.println("scoreMessageJson:"+cpages);
        List<Order> scoreList = this.userService.findOrderById( Integer.parseInt(cpages), size,tzw_user_id);

        HashMap<String,Object> map=new HashMap<>();

        map.put("list",scoreList);
        map.put("epage",epage);
        map.put("cpage",cpages);
        int page=0;
        if(userCount%10==0)
        {
            page=userCount/10;
        }else
        {
            page=userCount/10+1;
        }
        map.put("total", page);
        map.put("totalnum", userCount);
        return map;

    }

}
