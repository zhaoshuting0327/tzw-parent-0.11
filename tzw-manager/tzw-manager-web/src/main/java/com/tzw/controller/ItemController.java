package com.tzw.controller;

import com.tzw.common.pojo.EasyUIDataGridResult;
import com.tzw.common.utils.Fenye;
import com.tzw.pojo.Choujiang;
import com.tzw.pojo.Item;
import com.tzw.pojo.JiFen;
import com.tzw.pojo.JingPai;
import com.tzw.service.ItemService;
import org.apache.http.HttpRequest;
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
    public  HashMap<String, Object>  item_list(HttpServletRequest request, HttpSession httpSession) {

        String lname = request.getParameter("lname");
        lname= (String) httpSession.getAttribute("lname");
        String cpage = request.getParameter("cpage");
        int size = 10;
        Fenye fenye = new Fenye();
        int total=this.itemService.getCount(lname);

        Map<String, Object> fen = fenye.Fenye(request, cpage, size, total);
        String cpages = (String) fen.get("cpage");
        Integer epage =  (Integer) fen.get("epage");

        List<Item> list = this.itemService.getItemList(Integer.parseInt(cpages),size,lname);

            HashMap<String, Object> m = new HashMap<>();
            m.put("list", list);
            m.put("cpage", cpages);
            m.put("epage", epage);
            m.put("totalnum", total);

            int page=0;
            if(total%10==0)
            {
                page=total/10;
            }else
            {
                page=total/10+1;
            }
        m.put("total", page);
        return m;
    }
    @RequestMapping("item_list")
    public String item(HttpServletRequest request,HttpSession httpSession)
    {
        item_list(request,httpSession);
        return "item_list";
    }

   @RequestMapping("item/del")
   @ResponseBody
    public int del(BigInteger tzw_item_id)
    {
        this.itemService.del(tzw_item_id);
        return 1;
    }

    @RequestMapping("item_add")
    public String item_add()
    {
        return "item_add";
    }


    @RequestMapping("toUpdateItem")
    public String toUpdateItem(BigInteger tzw_item_id,Model model)
    {
        model.addAttribute("tzw_item_id",tzw_item_id);

        return "item_update";
    }

    @RequestMapping("huixianItem")
    @ResponseBody
    public Item huixianItem( HttpServletRequest request)
    {

        String tzw_item_id = request.getParameter("tzw_item_id");

        int i = Integer.parseInt(tzw_item_id);


        System.out.println(tzw_item_id+"update");

        Item itemById = this.itemService.findItemById(BigInteger.valueOf(i));

        System.out.println(itemById.getTzw_item_name());
        System.out.println(itemById.getTzw_item_num());
        return itemById;
    }


    //添加提交  item_add_commit

    @RequestMapping("item_add_commit")
    @ResponseBody
    public HashMap<String, Object> item_add_commit(HttpServletRequest request,Model model)
    {
        HashMap<String,Object> map=new HashMap<>();

        int i=0;

        Item item=new Item();
    /*  {"itemname":itemname,
                    "itemprice":itemprice,
                    "itemnum":itemnum,
                    "itemstatus":itemstatus,
                    "itemdesc":itemdesc,
                    "choujiang":choujiang,
                    "jifen":jifen,
                    "jingpai":jingpai,
                    "preNum":preNum,
                    "houNum":houNum,
                    "scoreNum":scoreNum,
                    "jingpaiNum":jingpaiNum,
                    "imageStr":imageStr
                },*/
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
        System.out.println(scoreNum+"===scoreNum===");
        String jingpaiNum = request.getParameter("jingpaiNum");
        String imageStr = request.getParameter("imageStr");





        System.out.println(itemname+"itemname");
        System.out.println(itemprice+"itemprice");
        System.out.println(itemdesc+"itemdesc");
        //验证商品名不能为空
        if(itemname==null||("".equals(itemname)))
        {
            map.put("itemname","商品名称不能为空");
        }else
        {
            i++;
        }

       String regex1="^[1-9]\\d*(\\.\\d{1,2})?$";
        String regex2="^0(\\.\\d{1,2})?$";

        if(itemprice==null||("".equals(itemprice)))
        {
           map.put("itemprice","商品价格不能为空");
        }else if(!itemprice.matches(regex1)&&!itemprice.matches(regex2))
        {
           map.put("itemprice","商品价格必须是数字且最多只允许俩位小数");
        }else
        {
            i++;
        }


        i++;
      /*   String regex3="^\\d+$";

        if (itemNum==null||("".equals(itemNum)))
        {
           map.put("itemnum","商品库存不能为空");
        }else if(!regex3.matches(itemNum))
        {
           map.put("itemnum","商品库存必须为数字");
        }else
        {
            i++;
        }
*/
        if (itemstatus==null||("".equals(itemstatus)))
        {
           map.put("itemstatus","商品商品状态必须选择");
        }else
        {
            i++;
        }



        JiFen jifen1=new JiFen();
        JingPai jingpai1=new JingPai();
        Choujiang choujiang1=new Choujiang();

        if(scoreNum==null||("".equals(scoreNum)))
        {
        }else {
            jifen1.setTzw_jifen_num(Integer.parseInt(scoreNum));
        }


        if(jingpaiNum==null||("".equals(jingpaiNum)))
        {
        }else
        {
            jingpai1.setTzw_jingpai_num(Integer.parseInt(jingpaiNum));

        }

        if(preNum==null||("".equals(preNum)))
        {

        }else
        {
            choujiang1.setTzw_choujiang_preNum(preNum);
            choujiang1.setTzw_choujiang_houNum(Integer.parseInt(houNum));
        }


        System.out.println(i+"=============");
        map.put("success",0);
        if(i==4)
       {
           System.out.println("添加值");
           item.setTzw_item_status(Integer.parseInt(itemstatus));
           item.setTzw_item_name(itemname);
           item.setTzw_item_price(Double.parseDouble(itemprice));
           item.setTzw_item_desc(itemdesc);
           item.setTzw_item_num(Integer.parseInt(itemNum));
           item.setTzw_item_choujiang(Integer.parseInt(choujiang));
           item.setTzw_item_jifen(Integer.parseInt(jifen));
           item.setTzw_item_jingpai(Integer.parseInt(jingpai));
           item.setTzw_item_picture(imageStr);
           this.itemService.addItem(item,jingpai1,choujiang1,jifen1);

           map.put("success",1);
       }

        return map;
    }
}
