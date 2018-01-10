package com.tzw.controller;

import com.tzw.common.utils.Fenye;
import com.tzw.pojo.Item;
import com.tzw.pojo.User;
import com.tzw.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/9.
 */
@Controller
public class ActiveController {

    @Autowired
    private ActiveService activeService;

    @RequestMapping("choujiang_list")
    public String choujiang_list()
    {
        return "choujiang_list";
    }
   //抽奖商品
    @RequestMapping("choujiang_listJson")
    @ResponseBody
    public HashMap<String, Object> user_listJson(HttpServletRequest request, HttpSession httpSession)
    {
        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int userCount = this.activeService.chouJiangCount();
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,userCount );
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");
        List<Item> userList = this.activeService.loadChouJiang(Integer.parseInt(cpages), size);

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

    //积分商品
    @RequestMapping("jifen_list")
    public String jifen_list()
    {
        return "jifen_list";
    }

    @RequestMapping("jifen_listJson")
    @ResponseBody
    public HashMap<String, Object> jifen_listJson(HttpServletRequest request, HttpSession httpSession)
    {
        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int userCount = this.activeService.jiFenCount();
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,userCount );
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");
        List<Item> userList = this.activeService.loadJiFen(Integer.parseInt(cpages), size);

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

    //竞拍商品

    @RequestMapping("jingpai_list")
    public String jingpai_list()
    {
        return "jingpai_list";
    }

    @RequestMapping("jingpai_listJson")
    @ResponseBody
    public HashMap<String, Object> jingpai_listJson(HttpServletRequest request, HttpSession httpSession)
    {
        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int userCount = this.activeService.jingPaiCount();
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,userCount );
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");
        List<Item> userList = this.activeService.loadJingPai(Integer.parseInt(cpages), size);

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


}
