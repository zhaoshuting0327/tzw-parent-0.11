package com.tzw.controller;

import com.tzw.common.pojo.EasyUIDataGridResult;
import com.tzw.common.utils.Fenye;
import com.tzw.pojo.Choujiang;
import com.tzw.pojo.Item;
import com.tzw.pojo.JiFen;
import com.tzw.pojo.JingPai;
import com.tzw.service.ItemService;
import org.apache.http.HttpRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/25.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("item_listJson")
    @ResponseBody
    public HashMap<String, Object> item_list(HttpServletRequest request, HttpSession httpSession) {

        System.out.println("走了");
        String lname = request.getParameter("lname");
        lname = (String) httpSession.getAttribute("lname");
        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int total = this.itemService.getCount(lname);

        Map<String, Object> fen = fenye.Fenye(request, cpage, size, total);
        String cpages = (String) fen.get("cpage");
        Integer epage = (Integer) fen.get("epage");

        List<Item> list = this.itemService.getItemList(Integer.parseInt(cpages), size, lname);

     /*   for (int i = 0; i < list.size(); i++) {
            System.out.println("jingpai" + list.get(i).getTzw_item_jingpai1());
            System.out.println("choujiang" + list.get(i).getTzw_item_choujiang1());
            System.out.println("jifen" + list.get(i).getTzw_item_jifen1());
        }*/
        HashMap<String, Object> m = new HashMap<>();
        m.put("list", list);
        m.put("cpage", cpages);
        m.put("epage", epage);
        m.put("totalnum", total);

        int page = 0;
        if (total % 10 == 0) {
            page = total / 10;
        } else {
            page = total / 10 + 1;
        }
        m.put("total", page);
        return m;
    }

    @RequestMapping("item_list")
    public String item(HttpServletRequest request, HttpSession httpSession) {
        item_list(request, httpSession);
        return "item_list";
    }

    @RequestMapping("item/del")
    @ResponseBody
    public int del(BigInteger tzw_item_id) {
        this.itemService.del(tzw_item_id);
        return 1;
    }

    @RequestMapping("item_add")
    public String item_add() {
        return "item_add";
    }


    @RequestMapping("toUpdateItem")
    public String toUpdateItem(BigInteger tzw_item_id, Model model) {
        model.addAttribute("tzw_item_id", tzw_item_id);

        return "item_update";
    }

    @RequestMapping("huixianItem")
    @ResponseBody
    public Item huixianItem(HttpServletRequest request) {

        String tzw_item_id = request.getParameter("tzw_item_id");

        Long i = Long.parseLong(tzw_item_id);

        System.out.println(tzw_item_id + "update");

        Item itemById = this.itemService.findItemById(BigInteger.valueOf(i));

        System.out.println(itemById.getTzw_item_name());
        System.out.println(itemById.getTzw_item_num());
        return itemById;
    }


    //添加提交  item_add_commit

    @RequestMapping("item_add_commit")
    @ResponseBody
    public HashMap<String, Object> item_add_commit(HttpServletRequest request, Model model) {

        System.out.println("添加提交");
        HashMap<String, Object> map = new HashMap<>();

        Item item = new Item();
        String itemname = request.getParameter("itemname");

        String itemprice = request.getParameter("itemprice");

        String itemdesc = request.getParameter("itemdesc");
        String itemNum = request.getParameter("itemnum");
        String itemstatus = request.getParameter("itemstatus");
        String choujiang = request.getParameter("choujiang");
        String jifen = request.getParameter("jifen");
        String jingpai = request.getParameter("jingpai");
        String preNum = request.getParameter("preNum");
        String houNum = request.getParameter("houNum");
        String scoreNum = request.getParameter("scoreNum");
        System.out.println(scoreNum + "===scoreNum===");
        String jingpaiNum = request.getParameter("jingpaiNum");
        String imageStr = request.getParameter("imageStr");
        String tzw_item_content = request.getParameter("tzw_item_content");
        String tzw_item_new= request.getParameter("tzw_item_new");
        String tzw_item_type = request.getParameter("itemtype");
        String tzw_item_leibie= request.getParameter("itemleibie");
        String tzw_item_little= request.getParameter("itemlittle");


        System.out.println(itemname + "itemname");
        System.out.println(itemprice + "itemprice");
        System.out.println(itemdesc + "itemdesc");

        String tzw_jingpai_liupai = request.getParameter("tzw_jingpai_liupai");
        String tzw_jingpai_jifen = request.getParameter("tzw_jingpai_jifen");
        String tzw_jingpai_yue = request.getParameter("tzw_jingpai_yue");
        String tzw_jingpai_xianjin = request.getParameter("tzw_jingpai_xianjin");

        JiFen jifen1 = new JiFen();
        JingPai jingpai1 = new JingPai();
        Choujiang choujiang1 = new Choujiang();

        if (scoreNum == null || ("".equals(scoreNum))) {
            jifen1.setTzw_jifen_num(0);
        } else {
            jifen1.setTzw_jifen_num(Integer.parseInt(scoreNum));
        }

        //竞拍后加
        if (tzw_jingpai_liupai == null || ("".equals(tzw_jingpai_liupai))) {
            jingpai1.setTzw_jingpai_liupai(0);

        } else {
           jingpai1.setTzw_jingpai_liupai(Integer.parseInt(tzw_jingpai_liupai));
        }
        if (tzw_jingpai_jifen == null || ("".equals(tzw_jingpai_jifen))) {
            jingpai1.setTzw_jingpai_jifen(0);
        } else {
            jingpai1.setTzw_jingpai_jifen(Integer.parseInt(tzw_jingpai_jifen));
        }
        if (tzw_jingpai_yue == null || ("".equals(tzw_jingpai_yue))) {
            jingpai1.setTzw_jingpai_yue(0);

        } else {
            jingpai1.setTzw_jingpai_yue(Integer.parseInt(tzw_jingpai_yue));
        }
        if (tzw_jingpai_xianjin == null || ("".equals(tzw_jingpai_xianjin))) {
            jingpai1.setTzw_jingpai_xianjin(0);

        } else {
           jingpai1.setTzw_jingpai_xianjin(Integer.parseInt(tzw_jingpai_xianjin));
        }

        //积分后加
        String tzw_jifen_yue = request.getParameter("tzw_jifen_yue");
        String tzw_jifen_xianjin = request.getParameter("tzw_jifen_xianjin");

        if (tzw_jifen_yue == null || ("".equals(tzw_jifen_yue))) {
        } else {
           jifen1.setTzw_jifen_yue(Integer.parseInt(tzw_jifen_yue));

        }
        if (tzw_jifen_xianjin == null || ("".equals(tzw_jifen_xianjin))) {
        } else {
           jifen1.setTzw_jifen_xianjin(Integer.parseInt(tzw_jifen_xianjin));

        }

        //抽奖后加
        String tzw_choujiang_jifen = request.getParameter("tzw_choujiang_jifen");
        String tzw_choujiang_yue = request.getParameter("tzw_choujiang_yue");
        String tzw_choujiang_xianjin = request.getParameter("tzw_choujiang_xianjin");


        if (tzw_choujiang_jifen == null || ("".equals(tzw_choujiang_jifen))) {
        } else {
           choujiang1.setTzw_choujiang_jifen(Integer.parseInt(tzw_choujiang_jifen));

        }

        if (tzw_choujiang_yue == null || ("".equals(tzw_choujiang_yue))) {
        } else {
           choujiang1.setTzw_choujiang_yue(Integer.parseInt(tzw_choujiang_yue));

        }

        if (tzw_choujiang_xianjin == null || ("".equals(tzw_choujiang_xianjin))) {
        } else {
           choujiang1.setTzw_choujiang_xianjin(Integer.parseInt(tzw_choujiang_xianjin));

        }

        if (jingpaiNum == null || ("".equals(jingpaiNum))) {
        } else {
            jingpai1.setTzw_jingpai_num(Integer.parseInt(jingpaiNum));

        }

        if (preNum == null || ("".equals(preNum))) {

        } else {
            choujiang1.setTzw_choujiang_preNum(preNum);
            choujiang1.setTzw_choujiang_houNum(Integer.parseInt(houNum));
        }

        map.put("success", 0);

            System.out.println("添加值");
        if (itemname == null || ("".equals(itemname))) {
            item.setTzw_item_name("未命名");
        } else {
            item.setTzw_item_name(itemname);
        }
        if (itemprice == null || ("".equals(itemprice))) {
            item.setTzw_item_price(Double.parseDouble("0.00"));
        } else {
            item.setTzw_item_price(Double.parseDouble(itemprice));
        }
            item.setTzw_item_status(Integer.parseInt(itemstatus));
         /*   item.setTzw_item_name(itemname);
            item.setTzw_item_price(Double.parseDouble(itemprice));*/
         //   item.setTzw_item_desc(itemdesc);
          //  item.setTzw_item_num(Integer.parseInt(itemNum));
        if (itemdesc == null || ("".equals(itemdesc))) {
            item.setTzw_item_desc(itemdesc);
        } else {
            item.setTzw_item_desc(itemdesc);
        }
           if (itemNum == null || ("".equals(itemNum))) {
               item.setTzw_item_num(0);
        } else {
               item.setTzw_item_num(Integer.parseInt(itemNum));
        }

            item.setTzw_item_type(Integer.parseInt(tzw_item_type));
            item.setTzw_item_leibie(Integer.parseInt(tzw_item_leibie));
            item.setTzw_item_choujiang(Integer.parseInt(choujiang));
            item.setTzw_item_jifen(Integer.parseInt(jifen));
            item.setTzw_item_jingpai(Integer.parseInt(jingpai));
            item.setTzw_item_picture(imageStr);
            item.setTzw_item_content(tzw_item_content);
            item.setTzw_item_new(tzw_item_new);
            item.setTzw_item_little(tzw_item_little);

            this.itemService.addItem(item, jingpai1, choujiang1, jifen1);

            map.put("success", 1);

        return map;
    }


    //修改提交  item_update_commit

    @RequestMapping("item_update_commit")
    @ResponseBody
    public HashMap<String, Object> item_update_commit(HttpServletRequest request, Model model) {
        HashMap<String, Object> map = new HashMap<>();

        int i = 0;

        Item item = new Item();
        String itemname = request.getParameter("itemname");
        String itemid = request.getParameter("itemid");
        String itemprice = request.getParameter("itemprice");
        String itemdesc = request.getParameter("itemdesc");
        String itemNum = request.getParameter("itemnum");
        String itemstatus = request.getParameter("itemstatus");
        String choujiang = request.getParameter("choujiang");
        String jifen = request.getParameter("jifen");
        String jingpai = request.getParameter("jingpai");
        String preNum = request.getParameter("preNum");
        String houNum = request.getParameter("houNum");
        String scoreNum = request.getParameter("scoreNum");
        System.out.println(scoreNum + "===scoreNum===");
        String jingpaiNum = request.getParameter("jingpaiNum");
        String imageStr = request.getParameter("imageStr");

        String tzw_item_type = request.getParameter("itemtype");
        String tzw_item_leibie= request.getParameter("itemleibie");
        String tzw_item_little= request.getParameter("itemlittle");

        String tzw_item_content = request.getParameter("tzw_item_content");
        String tzw_item_new= request.getParameter("tzw_item_new");

        JiFen jifen1 = new JiFen();
        JingPai jingpai1 = new JingPai();
        Choujiang choujiang1 = new Choujiang();

        if (scoreNum == null || ("".equals(scoreNum))) {
        } else {
            item.setTzw_jifen_num(Integer.parseInt(scoreNum));
            jifen1.setTzw_jifen_num(Integer.parseInt(scoreNum));
        }


        if (jingpaiNum == null || ("".equals(jingpaiNum))) {
        } else {
            jingpai1.setTzw_jingpai_num(Integer.parseInt(jingpaiNum));
            item.setTzw_jingpai_num(Integer.parseInt(jingpaiNum));
        }

        if (preNum == null || ("".equals(preNum))) {
        } else {
            choujiang1.setTzw_choujiang_preNum(preNum);
            choujiang1.setTzw_choujiang_houNum(Integer.parseInt(houNum));
            item.setTzw_choujiang_preNum(preNum);
            item.setTzw_choujiang_houNum(Integer.parseInt(houNum));
        }


        String tzw_jingpai_liupai = request.getParameter("tzw_jingpai_liupai");
        String tzw_jingpai_jifen = request.getParameter("tzw_jingpai_jifen");
        String tzw_jingpai_yue = request.getParameter("tzw_jingpai_yue");
        String tzw_jingpai_xianjin = request.getParameter("tzw_jingpai_xianjin");

        if (scoreNum == null || ("".equals(scoreNum))) {
        } else {
            jifen1.setTzw_jifen_num(Integer.parseInt(scoreNum));
        }

        //竞拍后加
        if (tzw_jingpai_liupai == null || ("".equals(tzw_jingpai_liupai))) {
        } else {
            jingpai1.setTzw_jingpai_liupai(Integer.parseInt(tzw_jingpai_liupai));
        }
        if (tzw_jingpai_jifen == null || ("".equals(tzw_jingpai_jifen))) {
        } else {
            jingpai1.setTzw_jingpai_jifen(Integer.parseInt(tzw_jingpai_jifen));
        }
        if (tzw_jingpai_yue == null || ("".equals(tzw_jingpai_yue))) {
        } else {
            jingpai1.setTzw_jingpai_yue(Integer.parseInt(tzw_jingpai_yue));
        }
        if (tzw_jingpai_xianjin == null || ("".equals(tzw_jingpai_xianjin))) {
        } else {
            jingpai1.setTzw_jingpai_xianjin(Integer.parseInt(tzw_jingpai_xianjin));
        }

        //积分后加
        String tzw_jifen_yue = request.getParameter("tzw_jifen_yue");
        String tzw_jifen_xianjin = request.getParameter("tzw_jifen_xianjin");

        if (tzw_jifen_yue == null || ("".equals(tzw_jifen_yue))) {
        } else {
            jifen1.setTzw_jifen_yue(Integer.parseInt(tzw_jifen_yue));

        }
        if (tzw_jifen_xianjin == null || ("".equals(tzw_jifen_xianjin))) {
        } else {
            jifen1.setTzw_jifen_xianjin(Integer.parseInt(tzw_jifen_xianjin));

        }

        //抽奖后加
        String tzw_choujiang_jifen = request.getParameter("tzw_choujiang_jifen");
        String tzw_choujiang_yue = request.getParameter("tzw_choujiang_yue");
        String tzw_choujiang_xianjin = request.getParameter("tzw_choujiang_xianjin");


        if (tzw_choujiang_jifen == null || ("".equals(tzw_choujiang_jifen))) {
        } else {
            choujiang1.setTzw_choujiang_jifen(Integer.parseInt(tzw_choujiang_jifen));

        }

        if (tzw_choujiang_yue == null || ("".equals(tzw_choujiang_yue))) {
        } else {
            choujiang1.setTzw_choujiang_yue(Integer.parseInt(tzw_choujiang_yue));

        }

        if (tzw_choujiang_xianjin == null || ("".equals(tzw_choujiang_xianjin))) {
        } else {
            choujiang1.setTzw_choujiang_xianjin(Integer.parseInt(tzw_choujiang_xianjin));

        }

        System.out.println(i + "=============");
        map.put("success", 0);

            System.out.println("添加值");
//             Long i1 = Long.parseLong(itemid);
            BigInteger n=new BigInteger(itemid);
            item.setTzw_item_id(n);
            item.setTzw_item_status(Integer.parseInt(itemstatus));
            item.setTzw_item_name(itemname);
            item.setTzw_item_price(Double.parseDouble(itemprice));
            item.setTzw_item_desc(itemdesc);
            item.setTzw_item_num(Integer.parseInt(itemNum));
            item.setTzw_item_choujiang(Integer.parseInt(choujiang));
            item.setTzw_item_jifen(Integer.parseInt(jifen));
            item.setTzw_item_jingpai(Integer.parseInt(jingpai));
            item.setTzw_item_picture(imageStr);
            item.setTzw_item_content(tzw_item_content);
            item.setTzw_item_new(tzw_item_new);
            item.setTzw_item_little(tzw_item_little);

            item.setTzw_item_type(Integer.parseInt(tzw_item_type));
            item.setTzw_item_leibie(Integer.parseInt(tzw_item_leibie));

            this.itemService.updateById(item,choujiang1,jifen1,jingpai1);


            map.put("success", 1);

        return map;
    }

    @RequestMapping(value = "hhh")
    public String hh() {
        return "hhh";
    }


    @RequestMapping(value = "pay")
    public String hhh() {

        System.out.println("支付宝======================================支付宝");
        return "hhh";
    }
}
