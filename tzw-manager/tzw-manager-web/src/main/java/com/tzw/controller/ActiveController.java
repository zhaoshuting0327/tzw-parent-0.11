package com.tzw.controller;

import com.tzw.common.utils.Fenye;
import com.tzw.pojo.*;
import com.tzw.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
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

    @RequestMapping("active/delChouJiang")
    @ResponseBody
    public int deleteChouJiang(BigInteger tzw_item_id)
    {
        this.activeService.deleteChouJiang(tzw_item_id);
        return 1;
    }
   @RequestMapping("active/delJiFen")
    @ResponseBody
    public int deleteJiFen(BigInteger tzw_item_id)
    {
        this.activeService.deleteJiFen(tzw_item_id);
        return 1;
    }

   @RequestMapping("active/delJingPai")
    @ResponseBody
    public int deleteJingPai(BigInteger tzw_item_id)
    {
        this.activeService.deleteJingPai(tzw_item_id);
        return 1;
    }

    //修改抽奖
    @RequestMapping("toUpdateChouJiang")
    public String toUpdateChouJiang(BigInteger tzw_item_id,Model model)
    {
        System.out.println("进来了");
        model.addAttribute("tzw_item_id",tzw_item_id);
        return "choujiang_update";
    }

    //修改回显
    @RequestMapping("huixianChouJiang")
    @ResponseBody
    public Item huixianChouJiang(HttpServletRequest request)
    {
        String tzw_user_id = request.getParameter("tzw_item_id");
        String tzw_user_createDate = request.getParameter("tzw_choujiang_createDate");

        int i = Integer.parseInt(tzw_user_id);

        Item item = this.activeService.findcByItemId(BigInteger.valueOf(i));

        return item;
    }

    //修改提交
    @RequestMapping("choujiang_update_commit")
    @ResponseBody
    public boolean user_update_commit(HttpServletRequest request)
    {
        String tzw_item_id = request.getParameter("tzw_item_id");
        String tzw_choujiang_preNum = request.getParameter("tzw_choujiang_preNum");
        String tzw_choujiang_houNum = request.getParameter("tzw_choujiang_houNum");

        Choujiang u=new Choujiang();

        u.setTzw_choujiang_houNum(Integer.parseInt(tzw_choujiang_houNum));

        int i = Integer.parseInt(tzw_item_id);
        u.setTzw_choujiang_item_id(BigInteger.valueOf(i));

        u.setTzw_choujiang_preNum(tzw_choujiang_preNum);

        this.activeService.updatecByItemId(u);
        return true;
    }

    //修改积分
    @RequestMapping("toUpdateJiFen")
    public String toUpdateJiFen(BigInteger tzw_item_id,Model model)
    {
        System.out.println("进来了");
        model.addAttribute("tzw_item_id",tzw_item_id);
        return "jifen_update";
    }

    //修改回显
    @RequestMapping("huixianJiFen")
    @ResponseBody
    public Item huixianJiFen(HttpServletRequest request)
    {
        String tzw_item_id = request.getParameter("tzw_item_id");
        String tzw_jifen_createDate = request.getParameter("tzw_jifen_createDate");

        int i = Integer.parseInt(tzw_item_id);

        Item item = this.activeService.findjiByItemId(BigInteger.valueOf(i));

        return item;
    }

    //修改提交
    @RequestMapping("jifen_update_commit")
    @ResponseBody
    public boolean jifen_update_commit(HttpServletRequest request)
    {
        String tzw_item_id = request.getParameter("tzw_item_id");
        String tzw_jifen_num = request.getParameter("tzw_jifen_num");

        JiFen u=new JiFen();

        u.setTzw_jifen_num(Integer.parseInt(tzw_jifen_num));

        int i = Integer.parseInt(tzw_item_id);
        u.setTzw_jifen_item_id(BigInteger.valueOf(i));

        this.activeService.updatejiByItemId(u);
        return true;
    }

    //修改竞拍
    @RequestMapping("toUpdateJingPai")
    public String toUpdateJingPai(BigInteger tzw_item_id,Model model)
    {
        System.out.println("进来了");
        model.addAttribute("tzw_item_id",tzw_item_id);
        return "jingpai_update";
    }

    //修改回显
    @RequestMapping("huixianJingPai")
    @ResponseBody
    public Item huixianJingPai(HttpServletRequest request)
    {
        String tzw_item_id = request.getParameter("tzw_item_id");
        String tzw_jingpai_createDate = request.getParameter("tzw_jingpai_createDate");

        int i = Integer.parseInt(tzw_item_id);

        Item item = this.activeService.findjByItemId(BigInteger.valueOf(i));

        return item;
    }

    //修改提交
    @RequestMapping("jingpai_update_commit")
    @ResponseBody
    public boolean jingpai_update_commit(HttpServletRequest request)
    {
        String tzw_item_id = request.getParameter("tzw_item_id");
        String tzw_jingpai_num = request.getParameter("tzw_jingpai_num");

        JingPai u=new JingPai();

        u.setTzw_jingpai_num(Integer.parseInt(tzw_jingpai_num));

        int i = Integer.parseInt(tzw_item_id);
        u.setTzw_jingpai_item_id(BigInteger.valueOf(i));

        this.activeService.updatejByItemId(u);
        return true;
    }



}
