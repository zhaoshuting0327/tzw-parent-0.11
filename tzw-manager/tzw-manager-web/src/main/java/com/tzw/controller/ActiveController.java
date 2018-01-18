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
        String tzw_choujiang_jifen = request.getParameter("tzw_choujiang_jifen");
        String tzw_choujiang_yue = request.getParameter("tzw_choujiang_yue");
        String tzw_choujiang_xianjin = request.getParameter("tzw_choujiang_xianjin");

        Choujiang u=new Choujiang();

        u.setTzw_choujiang_houNum(Integer.parseInt(tzw_choujiang_houNum));

        u.setTzw_choujiang_xianjin(Integer.parseInt(tzw_choujiang_xianjin));
        u.setTzw_choujiang_yue(Integer.parseInt(tzw_choujiang_yue));
        u.setTzw_choujiang_jifen(Integer.parseInt(tzw_choujiang_jifen));

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


        System.out.println("积分余额："+item.getTzw_jifen_yue());
        System.out.println("积分现金："+item.getTzw_jifen_xianjin());

        return item;
    }

    //修改提交
    @RequestMapping("jifen_update_commit")
    @ResponseBody
    public boolean jifen_update_commit(HttpServletRequest request)
    {
        String tzw_item_id = request.getParameter("tzw_item_id");
        String tzw_jifen_num = request.getParameter("tzw_jifen_num");

        String tzw_jifen_yue = request.getParameter("tzw_jifen_yue");
        String tzw_jifen_xianjin = request.getParameter("tzw_jifen_xianjin");

        JiFen u=new JiFen();

        u.setTzw_jifen_num(Integer.parseInt(tzw_jifen_num));

        u.setTzw_jifen_yue(Integer.parseInt(tzw_jifen_yue));
        u.setTzw_jifen_xianjin(Integer.parseInt(tzw_jifen_xianjin));

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

    //修改活动
    @RequestMapping("toUpdateActive")
    public String active_update(BigInteger tzw_activity_id,Model model)
    {
        System.out.println("进来了");
        model.addAttribute("tzw_activity_id",tzw_activity_id);
        return "active_update";
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

    /*活动回显*/
    @RequestMapping("huixianActive")
    @ResponseBody
    public Activity huixianActive(HttpServletRequest request)
    {
        String tzw_activity_id = request.getParameter("tzw_activity_id");
        int i = Integer.parseInt(tzw_activity_id);

        Activity activity = this.activeService.findActivityById(BigInteger.valueOf(i));

        return activity;
    }

    //修改提交
    @RequestMapping("jingpai_update_commit")
    @ResponseBody
    public boolean jingpai_update_commit(HttpServletRequest request)
    {
        String tzw_item_id = request.getParameter("tzw_item_id");
        String tzw_jingpai_num = request.getParameter("tzw_jingpai_num");
        String tzw_jingpai_liupai = request.getParameter("tzw_jingpai_liupai");
        String tzw_jingpai_jifen = request.getParameter("tzw_jingpai_jifen");
        String tzw_jingpai_yue = request.getParameter("tzw_jingpai_yue");
        String tzw_jingpai_xianjin = request.getParameter("tzw_jingpai_xianjin");

        JingPai u=new JingPai();

        u.setTzw_jingpai_num(Integer.parseInt(tzw_jingpai_num));

        u.setTzw_jingpai_liupai(Integer.parseInt(tzw_jingpai_liupai));
        u.setTzw_jingpai_yue(Integer.parseInt(tzw_jingpai_yue));
        u.setTzw_jingpai_xianjin(Integer.parseInt(tzw_jingpai_xianjin));
        u.setTzw_jingpai_jifen(Integer.parseInt(tzw_jingpai_jifen));

        int i = Integer.parseInt(tzw_item_id);
        u.setTzw_jingpai_item_id(BigInteger.valueOf(i));

        this.activeService.updatejByItemId(u);
        return true;
    }


    /*active_add*/
    @RequestMapping("/active_add")
    public String active_add()
    {
        return "active_add";
    }

    @RequestMapping("/active_add_commit")
    @ResponseBody
    public int active_add_commit(HttpServletRequest request)
    {

        String tzw_activity_name = request.getParameter("tzw_activity_name");
        String tzw_activity_rule = request.getParameter("tzw_activity_rule");
        String tzw_activity_picture = request.getParameter("tzw_activity_picture");
        Activity activity=new Activity();

        activity.setTzw_activity_rule(tzw_activity_rule);
        activity.setTzw_activity_name(tzw_activity_name);
        activity.setTzw_activity_picture(tzw_activity_picture);

        this.activeService.active_add_commit(activity);
        return 1;
    }


    @RequestMapping("/active_update_commit")
    @ResponseBody
    public int active_upload_commit(HttpServletRequest request)
    {

        String tzw_activity_name = request.getParameter("tzw_activity_name");
        String tzw_activity_rule = request.getParameter("tzw_activity_rule");
        String tzw_activity_picture = request.getParameter("tzw_activity_picture");
        String tzw_activity_id= request.getParameter("tzw_activity_id");
        Activity activity=new Activity();

        int i = Integer.parseInt(tzw_activity_id);
        activity.setTzw_activity_id(BigInteger.valueOf(i));
        activity.setTzw_activity_rule(tzw_activity_rule);
        activity.setTzw_activity_name(tzw_activity_name);
        activity.setTzw_activity_picture(tzw_activity_picture);

        this.activeService.active_update_commit(activity);
        return 1;
    }


    //积分商品
    @RequestMapping("active_list")
    public String active_list()
    {
        return "active_list";
    }

    @RequestMapping("active_listJson")
    @ResponseBody
    public HashMap<String, Object> active_listJson(HttpServletRequest request, HttpSession httpSession)
    {
        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int userCount = this.activeService.activeCount();
        Map<String, Object> fen = fenye.Fenye(request, cpage, size,userCount );
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");
        List<Activity> userList = this.activeService.loadActive(Integer.parseInt(cpages), size);

        for (int i=0;i<userList.size();i++)
        {
            System.out.println(userList.get(i).getTzw_activity_id());
        }
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
