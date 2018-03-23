package com.tzw.portal.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.tzw.common.cipher.aes.AesUtil;
import com.tzw.common.exception.BusinessException;
import com.tzw.common.exception.JsonUtils;
import com.tzw.common.response.TZApiResponse;
import com.tzw.common.utils.CodeUtil;
import com.tzw.portal.controller.base.BaseController;
import com.tzw.portal.controller.sms.SmsUtil;
import com.tzw.portal.in.UserLoginParam;
import com.tzw.portal.mapper.LoginMapperPortal;
import com.tzw.portal.pojo.User;
import com.tzw.portal.service.LoginServicePortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/5.
 */
@Controller
@RequestMapping(value = "/portal/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginServicePortal loginServicePortal;
    /*表里增加字段  token
        * {     code：0     message: “success”
           * data: { key1: value1, key2: value2, … } }

    code: 状态码，0表示成功，非0表示各种不同的错误

    message: 描述信息，成功时为”success”，错误时则是错误信息

    data: {token}成功时返回的数据，类型为对象或数据
    用户登录后，服务器端生成一个token，然后返回给客户端，客户端每次可以使用此token来进行获取数据，
    这样，每次获取数据都不用携带password来进行验证了，保证了用户的安全。
    二是因为每次用户登录都是新生成一个token替换原先的旧token，
    这样，原先在其他设备登录的用户就会下线
    */
    /**
     * 账号密码登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public TZApiResponse<String> login(HttpServletRequest request, String username, String passwd) {
        System.out.println("登录用户名密码");
        String version = request.getHeader("version");
        System.out.println(version);
        Map<String, Object> map = new HashMap<>();
        String json = null;
        try {
            if (version != null && version.equals("1.0")) {
                //判断用户名
                User user = new User();
                user.setTzw_user_username(username);
                user.setTzw_user_pwd(passwd);
                map = this.loginServicePortal.login(user);
                json = JsonUtils.objToJson(map);
            }
            return appSuccess("登录成功", 1, json);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                //   errorLog(((BusinessException) e).getMessage(), JsonUtils.objToJson(param), e);
                return appError(((BusinessException) e).getMessage());
            }
            //  errorLog("登录失败", JsonUtils.objToJson(param), e);
            return appError("登录失败");
        }
    }
     /*手机号登录 点击获取验证码  参数：手机号*/
     @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
     @ResponseBody
     public TZApiResponse<String> sendSms(HttpServletRequest request,String telno) {
         try {
             Map<String, Object> resultMap = new HashMap<String, Object>();

             HashMap<String, String> map2 = new HashMap<>();
             Jedis jedis=new Jedis("60.205.208.183",6379);
             String pwd =null;
             //验证手机号码是否存在

             User byTel = this.loginServicePortal.lginByTel(telno);

             //新生成验证码,发送短信，并存入redis
             pwd = CodeUtil.getCode();

             //缓存验证码并设置超时时间
             jedis.setex(telno + "_smslogin", 60, pwd);

             SendSmsResponse sendSmsResponse = SmsUtil.sendSms(telno, pwd);
             Thread.sleep(3000L);
             String json ="";
             return appSuccess("发送成功", 0, json);
         } catch (BusinessException e) {
            // errorLog(e.getMessage(), JsonUtils.objToJson(param), e);
             return appError(e.getMessage());
         } catch (Exception e) {
            // errorLog("发送验证码失败", JsonUtils.objToJson(param), e);
             return appError("发送验证码失败！");
         }
     }


    /**
     * 手机登录
     *  点击登录，获得输入验证码
     * @return
     */
    @RequestMapping(value = "/smsLogin", method = RequestMethod.POST)
    @ResponseBody
    public TZApiResponse<String> smsLogin( HttpServletRequest request,String telno,String code) {
        String version = request.getHeader("version");
        try {
            Map<String, Object> map = new HashMap<>();
            if (version != null && version.equals("1.0")) {
                //通过手机号碼查找
                map= this.loginServicePortal.smsYanZheng(telno, code);

            }
            return appSuccess("登录成功", 0, JsonUtils.objToJson(map));
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                //errorLog(((BusinessException) e).getMessage(), JsonUtils.objToJson(param), e);
                return appError(((BusinessException) e).getMessage());
            }else {
                return appError("登录失败");
            }
         //   errorLog("登录失败", JsonUtils.objToJson(param), e);
        }
    }

    /**
     * 登出
     *
     * @param request
     * @return
     */
      @RequestMapping(value = "/logOut", method = RequestMethod.POST)
      @ResponseBody
    public TZApiResponse<String> logOut(HttpServletRequest request,String tzw_user_id) {
        String version = request.getHeader("version");
        try {
            if (version != null && version.equals("1.0")) {
                //删除token
                this.loginServicePortal.updateUserToken(tzw_user_id);
            }
            return appSuccess("登出成功", 0, "");
        } catch (Exception e) {
            errorLog("登出失败", "", e);
            return appError("登出失败");
        }
    }



    /**
     * 用户名  密码 手机号注册
     */
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @ResponseBody
    public TZApiResponse<String> reg(HttpServletRequest request, String username, String passwd,String telno) {
        String version = request.getHeader("version");
        System.out.println(version);
        Map<String, Object> map = new HashMap<>();
        String json = null;
        try {
            if (version != null && version.equals("1.0")) {
                //判断用户名
                User user = new User();
                user.setTzw_user_username(username);
                user.setTzw_user_pwd(passwd);
                user.setTzw_user_phone(telno);
                map = this.loginServicePortal.reg(user);
                json = JsonUtils.objToJson(map);
            }
            return appSuccess("注册成功", 1, json);
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                //   errorLog(((BusinessException) e).getMessage(), JsonUtils.objToJson(param), e);
                return appError(((BusinessException) e).getMessage());
            }
            //  errorLog("登录失败", JsonUtils.objToJson(param), e);
            return appError("注册失败");
        }
    }

    /**
     * 忘记密码之
     * 手机找回密码
     * @param request
     * @return
     */
  /*@RequestMapping(value = "/retryPwd", method = { RequestMethod.POST })
    @ResponseBody
    public TZApiResponse<String> retryPwd(HttpServletRequest request
                                       ) {
        Map<String, Object> map = null;
        try {
            map = new HashMap<>();
            Teacher teacher = teacherService.getByTele(param.getTelephone());
            String params = AesUtil.decryptAES(param.getParams(),
                    teacher.getUserKey());
            Map<String, Object> parseJSON2Map = JsonUtils.parseJSON2Map(params);
            String imageCode = teacherService.getTeleCodeByRedis(
                    RedisKey.TEACHER_IMAGECODE_REDIS_KEY,
                    (String) parseJSON2Map.get("guid"));
            if (!parseJSON2Map.get("imageCode").equals(imageCode)) {
                throw new BusinessException("图片验证码验证失败");
            }
            String teleCodeByRedis = teacherService.getTeleCodeByRedis(
                    RedisKey.TEACHER_TELECODE_REDIS_KEY, param.getTelephone());
            if (!parseJSON2Map.get("teleCode").equals(teleCodeByRedis)) {
                throw new BusinessException("短信验证码验证失败");
            }
            teacherService.retryPwd(param.getTelephone(), parseJSON2Map);
            return appSuccess("找回密码成功", 0, "");
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                errorLog(((BusinessException) e).getMessage(),
                        JsonUtils.objToJson(param), e);
                return appError(((BusinessException) e).getMessage());
            }
            errorLog("密码找回失败", JsonUtils.objToJson(param), e);
            return appError("密码找回失败");
        }
    }*/


    /**忘记密码之
     * 修改密码
     *
     * @return
     */
 /*   @RequestMapping(value = "/updatePassword", method = { RequestMethod.POST })
    @ResponseBody
    public TZApiResponse<String> updatePassword(TeacherLoginParam param,
                                                HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String message = "";
        try {
            String key = TeacherKeyUtil.getTeacherKey(param.getuId(),
                    teacherService);
            String params = AesUtil.decryptAES(param.getParams(), key);
            map = JsonUtils.parseJSON2Map(params);
            message = teacherService.updatePassword(map, param.getuId());
            return appSuccess(message, 0, "");
        } catch (BusinessException e) {
            errorLog(e.getMessage(), JsonUtils.objToJson(param), e);
            return appError(e.getMessage());
        } catch (Exception e) {
            errorLog("操作失败", JsonUtils.objToJson(param), e);
            return appError("操作失败");
        }
    }*/
}