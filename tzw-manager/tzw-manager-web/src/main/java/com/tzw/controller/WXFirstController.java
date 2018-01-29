package com.tzw.controller;


import com.tzw.common.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 上传图片控制层
 * @author Mr_liao
 * */
@Controller
@RequestMapping(value = "/wxFirst")
public class WXFirstController {
	/**
	 * 上传图片
	 */
	@RequestMapping("/uploadImgBase")
	@ResponseBody
	public Map<String, String> uploadImgBase(@RequestParam(value="imgBase64",defaultValue="") String imgBase64,
											 @RequestParam(value="fileName",defaultValue="") String fileName,
											 HttpServletRequest request,
											 HttpServletResponse response){
		String TrueDirectory = "ImgFiles"+ File.separator+"backgroundImg";
		String inventedDirectory = "ImgFiles/"+"backgroundImg";
		System.out.println("TrueDirectory::"+TrueDirectory);
		System.out.println("inventedDirectory::"+inventedDirectory);
		String directory = TrueDirectory+"-"+inventedDirectory;
	//	System.out.println("剪切：============="+imgBase64);
		Map<String, String> map = ImageUtil.uploadImgBase64(request,imgBase64, directory, fileName);

		System.out.println("map.get:::"+map.get("path"));


		return map;
	}
}

