package com.tzw.controller;

import com.tzw.common.utils.CookieUtils;
import com.tzw.common.utils.Fenye;
import com.tzw.pojo.Item;
import com.tzw.pojo.Owner;
import com.tzw.pojo.User;
import com.tzw.service.LoginService;
import com.tzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
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
        return "index";
    }
    @RequestMapping(value = "/loginForm",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(Model model, HttpServletRequest request, HttpServletResponse response) {

        Map<String,Object> map=new HashMap<>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String  messg="";

        if(password == null || "".equals(password)||username == null || "".equals(username)) {
           messg="用户名或密码不能为空!";
           map.put("messg",messg);
           map.put("ok",0);
           return map;
        }
        else{
           String s = makeMD5(password);

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
    public String loginOut()
    {
        return "login";
    }

        public String makeMD5(String password) {
        MessageDigest md;
        try {
            // 生成一个MD5加密计算摘要
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            String pwd = new BigInteger(1, md.digest()).toString(16);

            return pwd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
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

        System.out.println(tzw_user_id+"tzw_user_id+++++++");
        int i = Integer.parseInt(tzw_user_id);

        User user = this.userService.findUserById(BigInteger.valueOf(i));
        return user;
    }



}
