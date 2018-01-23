package com.tzw.controller;

import com.tzw.common.utils.FastDFSClient;
import com.tzw.common.utils.JsonUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/8.
 */
@Controller
public class FileController {

    /*上传的图片在tomcat目录的
    \webapps\你的项目名\images
*/
    @RequestMapping("uploader1")
    public void upload(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("收到图片!");
        int counter = 0;

        MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象
        String upaloadUrl = request.getSession().getServletContext().getRealPath("/") + "upload/";//得到当前工程路径拼接上文件名

        File dir = new File(upaloadUrl);
        System.out.println(upaloadUrl);
        if (!dir.exists())//目录不存在则创建
        {
            dir.mkdirs();
        }
        for (MultipartFile file : files.values()) {
            counter++;
            String fileName = file.getOriginalFilename();
            File tagetFile = new File(upaloadUrl + fileName);//创建文件对象
            System.out.println(fileName+"文件名");
            if (!tagetFile.exists()) {//文件名不存在 则新建文件，并将文件复制到新建文件中
                try {
                    tagetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    file.transferTo(tagetFile);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("接收完毕");
    }

    @RequestMapping("uploader2")
    public void upload2(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("收到图片!");
        int counter = 0;

        MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象
        String upaloadUrl = request.getSession().getServletContext().getRealPath("/") + "upload2/";//得到当前工程路径拼接上文件名

        File dir = new File(upaloadUrl);
        System.out.println(upaloadUrl);
        if (!dir.exists())//目录不存在则创建
        {
            dir.mkdirs();
        }
        for (MultipartFile file : files.values()) {
            counter++;
            String fileName = file.getOriginalFilename();
            File tagetFile = new File(upaloadUrl + fileName);//创建文件对象
            System.out.println(fileName+"文件名");
            if (!tagetFile.exists()) {//文件名不存在 则新建文件，并将文件复制到新建文件中
                try {
                    tagetFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    file.transferTo(tagetFile);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("接收完毕");
    }
    }
