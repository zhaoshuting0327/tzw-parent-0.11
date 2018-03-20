package com.tzw.common.utils;

import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/29.
 */

/**
    * 图片上传与删除工具类
    * @author Mr_liao
    * */
   public class ImageUtil2 {
       /**
        * 上传base64 单个图片
        */
       public static Map<String, String> uploadImgBase64(HttpServletRequest request, String imgBase64, String Directory, String oldFileName){
           Map<String, String> uploadImageMap  =  new HashMap<String, String>();
           String oldFileName2 = oldFileName.substring(0,oldFileName.lastIndexOf("."));
           String lastFileName = oldFileName.substring(oldFileName.lastIndexOf("."),oldFileName.length());
           String fileName =  oldFileName2+System.currentTimeMillis()+lastFileName;// 重命名上传后的文件名
           uploadImageMap.put("oldFileName", oldFileName);
           //上传本地tomcat路径
           String path = request.getSession().getServletContext().getRealPath("/") + Directory.split("-")[0] + File.separator+ fileName;
           String filePath = request.getSession().getServletContext().getRealPath("/") + Directory.split("-")[0];
           System.out.println("filePath::"+filePath);
           System.out.println("path::"+path);
           System.out.println("fileName::"+fileName);
           System.out.println("lastFileName::"+lastFileName);
           System.out.println("oldFileName2::"+oldFileName2);
           System.out.println("oldFileName::"+oldFileName);
           //上传服务器路径
           String phoUrl = "/" + Directory.split("-")[1]+"/" + fileName;
           System.out.println("phoUrl::"+phoUrl);

           String header ="data:image";
           String[] imageArr=imgBase64.split(",");
           if(imageArr[0].contains(header)){//是img的
               // 去掉头部
               imgBase64=imageArr[1];
               //image = image.substring(header.length());
               // 写入磁盘
               BASE64Decoder decoder = new BASE64Decoder();
               try{
                   byte[] decodedBytes = decoder.decodeBuffer(imgBase64);        //将字符串格式的image转为二进制流（biye[])的decodedBytes
                   File targetFile = new File(filePath);
                   if(!targetFile.exists()){
                       targetFile.mkdirs();
                   }
                   FileOutputStream out = new FileOutputStream(path);        //新建一个文件输出器，并为它指定输出位置imgFilePath
                   out.write(decodedBytes); //利用文件输出器将二进制格式decodedBytes输出
                   out.flush();
                   out.close();                        //关闭文件输出器
                   uploadImageMap.put("success", "上传文件成功！");
                   uploadImageMap.put("path", path);
                   uploadImageMap.put("phoUrl", phoUrl);
                   return uploadImageMap;
               }catch(Exception e){
                   uploadImageMap.put("err", "上传文件失败！");
                   return uploadImageMap;
               }
           }else{
               uploadImageMap.put("err", "上传文件失败！");
               return uploadImageMap;
           }
       }
       /**
        * 删除目录（文件夹）以及目录下的文件
        * @param   sPath 被删除目录的文件路径
        * @return  目录删除成功返回true，否则返回false
        */
       public static boolean deleteDirectory(String sPath) {
           //如果sPath不以文件分隔符结尾，自动添加文件分隔符
           sPath = sPath.replace("/", File.separator);
           if (!sPath.endsWith(File.separator)) {
               sPath = sPath + File.separator;
           }
           File dirFile = new File(sPath);
           //如果dir对应的文件不存在，或者不是一个目录，则退出
           if (!dirFile.exists() || !dirFile.isDirectory()) {
               return false;
           }
           boolean flag = true;
           //删除文件夹下的所有文件(包括子目录)
           File[] files = dirFile.listFiles();
           for (int i = 0; i < files.length; i++) {
               //删除子文件
               if (files[i].isFile()) {
                   flag = deleteFile(files[i].getAbsolutePath());
                   if (!flag){ break;}
               } //删除子目录
               else {
                   flag = deleteDirectory(files[i].getAbsolutePath());
                   if (!flag) {break;}
               }
           }
           if (!flag)
           {
               return false;
           }
           //删除当前目录
           if (dirFile.delete()) {
               return true;
           } else {
               return false;
           }
       }
       /**
        * 删除单个文件
        * @param   sPath    被删除文件的文件名
        * @return 单个文件删除成功返回true，否则返回false
        */
       public static boolean deleteFile(String sPath) {
           boolean flag = false;
           File file = new File(sPath);
           // 路径为文件且不为空则进行删除
           if (file.isFile() && file.exists()) {
               file.delete();
               flag = true;
           }
           return flag;
       }
       /**
        * 删除文件
        * @param sPath 数据库存的相对路径
        * @return
        */
       public static boolean deleteFileByPath(HttpServletRequest request,String sPath) {
           String realProjectPath = request.getSession().getServletContext().getRealPath("/");
           String reso = (realProjectPath+sPath).replace("/",File.separator);
           boolean flag = false;
           File file = new File(reso);
           // 路径为文件且不为空则进行删除
           if (file.isFile() && file.exists()) {
               file.delete();
               flag = true;
           }
           return flag;

       }
       /**
        * 删除本地资源中的图片
        */
       public static void delPhotoSourse(HttpServletRequest request,String resourse){
//		String projectName = publicUtil.getProjectMame(request);
           String tomcatPath = request.getSession().getServletContext().getRealPath("/");
//		String[] pUrl= resourse.split(projectName);
           //替换斜杠
//		String purl2 = pUrl[1].replace("/", File.separator);
//		purl2 = purl2.substring(1,purl2.length());
           //截取字符串
//		String realProjectPath = request.getSession().getServletContext().getRealPath("/");
           String reso = (tomcatPath+resourse).replace("/",File.separator);
           File fileTemp = new File(reso);
           boolean falg = false;
           falg = fileTemp.exists();
           if (falg) {
               fileTemp.delete();
           }
       }
}
