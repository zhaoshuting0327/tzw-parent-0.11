package com.tzw.common.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Fenye {
    //分页
	public Map<String, Object> Fenye(HttpServletRequest request,String cpage, int size, int sumcount){
   	    
		if(cpage==null){cpage="1";};
		 int sizes=size; 
	     int epage=sumcount/sizes;
	     if(sumcount%sizes!=0){epage++;};
	     if(cpage.matches("\\d+")){
	    	 if(Integer.parseInt(cpage)>epage)
	    	  {cpage=String.valueOf(epage);}
	    	 else if(Integer.parseInt(cpage)<=0)
	    	 {cpage="1";}
	    	 else{cpage=cpage;};
	     }else{cpage="1";}
	     Map<String,Object> fenye=new HashMap<>();
	     fenye.put("cpage",cpage);
	     fenye.put("epage",epage);
	     fenye.put("total",sumcount);
		 return fenye;
	}
	//特殊卡号
	public String Cards(HttpServletRequest request,int shu){
		HttpSession session = request.getSession();
		Integer number = (Integer)session.getAttribute("numbers");
		if(number==null){number=shu;};
		Date date=new Date();
		SimpleDateFormat mat=new SimpleDateFormat("yyyyMMdd");
		String format = mat.format(date);
		int numbers=++number;
		String nums=format+"N0000"+numbers;
		session.setAttribute("numbers", numbers);
		return nums;
	}
}
