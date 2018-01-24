package com.tzw.controller;

import com.sun.prism.Image;
import com.tzw.common.utils.FastDFSClient;
import com.tzw.common.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    @RequestMapping(value = "/uploadimage", method = RequestMethod.GET)
    @ResponseBody
    public void uploadv(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        System.out.println("富文本编辑器1");
    }
    @RequestMapping(value="/uploadimage",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> uploadFile(@RequestParam(value = "upfile", required = false) MultipartFile file,
                                         HttpServletRequest request,HttpServletResponse response){

        System.out.println("富文本编辑器2");
        Map<String,Object> map = new HashMap<String, Object>();
        String realName = null;
        String uuidName = null;
        String realPath = null;

        try {
            //Image image = new Image();
            //文件原来的名称
            realName = file.getOriginalFilename();
            //得到这个文件的uuidname
            uuidName = this.getUUIDFileName(file.getOriginalFilename());
            //图片保存的工程
            realPath = request.getSession().getServletContext().getRealPath("/images");
            //真实路径
            String roolPath = request.getSession().getServletContext().getRealPath("/");
          /*  image.setName(realName);
            image.setUrl(roolPath);
            image.setUuidname(uuidName);*/

            //得到文件的输入流
            InputStream in = new BufferedInputStream(file.getInputStream());
            //获得文件的输出流
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(realPath,uuidName)));

            IOUtils.copy(in, out);
            in.close();
            out.close();
            //将图片信息传递到我的数据库当中
            int flag = 1;
//            int flag = imageService.insertImage(image);

            if(flag!=0){
                map.put("state", "SUCCESS");// UEDITOR的规则:不为SUCCESS则显示state的内容
                map.put("url","/images/"+uuidName);         //能访问到你现在图片的路径
                map.put("title","");
                map.put("original","realName" );
            }
        } catch (IOException e) {

            map.put("state", "文件上传失败!"); //在此处写上错误提示信息，这样当错误的时候就会显示此信息
            map.put("url","");
            map.put("title", "");
            map.put("original", "");
            e.printStackTrace();
        }
        return map;
    }


    //下面是我的两个方法，取的uuidname防止文件同名问题
    private String getExtName(String s, char split) {
        int i = s.lastIndexOf(split);
        int leg = s.length();
        return i > 0 ? (i + 1) == leg ? " " : s.substring(i+1, s.length()) : " ";
    }

    private String getUUIDFileName(String fileName){
        UUID uuid = UUID.randomUUID();
        StringBuilder sb = new StringBuilder(100);
        sb.append(uuid.toString()).append(".").append(this.getExtName(fileName, '.'));
        return sb.toString();
    }


}