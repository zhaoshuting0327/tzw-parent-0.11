package com.tzw.common.constant;

/**
 * Created by Administrator on 2017/3/6 0006.
 */
public class Constant {
	public static final int REDIS_START = 0;
	public static final int REDIS_END = 1;
	public static final int REDIS_LREM_COUNT = 1;

	/** 默认parentId **/
	public static final int DEFAULT_PARENT_ID = 0;
	public static final String STR_DEFAULT_PARENT_ID = "0000000000000000000000000";



	public static final String TEACHER_SESSION = "TEACHER_SESSION";
	/** 验证码 **/
	public static final String CAPTCHA_IMAGE_CODE = "CAPTCHA_IMAGE_CODE";
	/** 重置验证码 **/
	public static final String VALIDATE_IMAGE_CODE = "VALIDATE_IMAGE_CODE";
	/** 短信验证码 **/

	public static final String TEACHER_SMS_CODE = "TEACHER_SMS_CODE";
	// 如果是AJAX请求 则响应1010状态码
	public final static Integer AJAX_STATUS = 1010;
	// 没有权限
	public final static String NO_AUTH_MESSAGE = "没有权限!";
	// 文件超过规定大小
	public final static String FILE_SIZE_MESSAGE = "文件超过规定大小!";
	// 文件类型不符合要求
	public final static String FILE_TYPE_MESSAGE = "文件类型不符合要求!";

	// 充值订单状态
	public static final int ORDER_STATUS_SUCCESS = 0;
	public static final int ORDER_STATUS_INIT = 1;
	public static final int ORDER_STATUS_HANDING = 2;
	public static final int ORDER_STATUS_FAIL = 3;
	
	//异常输出
	public static final String 	OUT_PUT="您目前暂无访问此权限";
}
