package com.tzw.common.exception;

import com.tzw.common.enums.ErrorCode;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2017/10/13 0013.
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    private String errorMsg;
    private Exception exception;
    private ErrorCode errorCodeEnum;

    public Exception getException() {
        return exception;
    }


    //定义无参构造方法
    public BusinessException() {
        super();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
    }

    public BusinessException(ErrorCode errorCodeEnum) {
        super((errorCodeEnum.getMessage()));
        this.errorCodeEnum = errorCodeEnum;
        this.errorMsg = "";
    }

    public BusinessException(ErrorCode errorCodeEnum,Exception e) {
        super((errorCodeEnum.getMessage()));
        this.errorCodeEnum = errorCodeEnum;
        this.errorMsg = "";
        this.exception = e;
    }

    public String getErrorMsg() {
        String pattern = errorCodeEnum != null ? errorCodeEnum.getMessage() : "{0}";
        String arg = StringUtils.isBlank(errorMsg) ? "" : errorMsg;
        return pattern +  arg;
    }

    public BusinessException(ErrorCode errorCodeEnum, String errorMsg,Exception e) {
        super(errorCodeEnum.getMessage());
        this.errorCodeEnum = errorCodeEnum;
        this.errorMsg = errorMsg;
        this.exception = e;
    }

    public ErrorCode getErrorCodeEnum() {
        return errorCodeEnum;
    }

    public void setErrorCodeEnum(ErrorCode errorCodeEnum) {
        this.errorCodeEnum = errorCodeEnum;
    }

    public BusinessException(ErrorCode errorCodeEnum, Throwable th) {
        super(th);
        this.errorCodeEnum = errorCodeEnum;
    }

    public BusinessException(ErrorCode errorCodeEnum, String errorMsg, Throwable th) {
        super(errorCodeEnum.getMessage(), th);
        this.errorCodeEnum = errorCodeEnum;
        this.errorMsg = errorMsg;
    }
}
