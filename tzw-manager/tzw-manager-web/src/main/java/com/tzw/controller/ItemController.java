package com.tzw.controller;

import com.tzw.common.pojo.EasyUIDataGridResult;
import com.tzw.common.utils.Fenye;
import com.tzw.pojo.Item;
import com.tzw.service.ItemService;
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


        for (int i=0;i<list.size();i++) {
            Item o = (Item) list.get(i);

            String s = o.getTzw_item_createDate() + "";
            String s1 = o.getTzw_item_updateDate() + "";

            o.setTzw_item_createDate(s.substring(0, s.length() - 2));
            o.setTzw_item_updateDate(s1.substring(0, s1.length() - 2));

        }
            HashMap<String, Object> m = new HashMap<>();
            m.put("list", list);
            m.put("cpage", cpages);
            m.put("epage", epage);

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



    @RequestMapping("item_add")
    public String item_add()
    {
        return "item_add";
    }


/*    @RequestMapping("/upload")
    public String upload()
    {
        System.out.println("1111111111111111111");
        return "";
    }*/
  /*  @RequestMapping("/upload")
    public String upload()
    {
        System.out.println("1111111111111111111");
        return "";
    }*/
        @RequestMapping(value = "/upload", method ={RequestMethod.POST,RequestMethod.GET}, produces = "application/json; charset=utf-8")
        @ResponseBody
        public String uploder(@RequestParam MultipartFile[] file, HttpServletRequest request, HttpServletResponse response){

            System.out.println("22222");
                    String flag=null;
                    try {
                           WebuploaderUtil webuploaderUtil=new WebuploaderUtil();
                       webuploaderUtil.upload(file[0], "upload/news/", request);
                          flag=webuploaderUtil.getFileName();
                   } catch (Exception e) {
                       e.printStackTrace();
                     }

                    return flag;
              }


    //添加提交  item_add_commit

    @RequestMapping("item_add_commit")
    @ResponseBody
    public HashMap<String, Object> item_add_commit(HttpServletRequest request,Model model)
    {
        HashMap<String,Object> map=new HashMap<>();

        int i=0;
        //验证商品名不能为空
        String itemname = request.getParameter("itemname");
        String itemprice = request.getParameter("itemprice");
        String content = request.getParameter("content");

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

        String itemNum = request.getParameter("itemnum");

        String regex3="^\\d+$";

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

        String itemstatus = request.getParameter("itemstatus");
        if (itemstatus==null||("".equals(itemstatus)))
        {
           map.put("itemstatus","商品商品状态必须选择");
        }else
        {
            i++;
        }

        map.put("success",0);
       if(i==4)
       {
           map.put("success",1);
       }

        return map;
    }
}
