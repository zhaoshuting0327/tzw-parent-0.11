package com.tzw.common.cipher.rsa;

/**
 * com.wangxiao.cloud.cipher.rsa.RsaConst
 * Description 加密参数常量类
 * Copyrigth(C),2017,lx86468@126.com.com
 * Date 2017/10/16 0016
 *
 * @author heguifang on 2017/10/16 0016.
 * @version 1.0
 */
public final class RsaConst {

	/** 编码 */
	public final static String ENCODE = "UTF-8";

	public final static String KEY_X509 = "X509";
	public final static String KEY_PKCS12 = "PKCS12";
	public final static String KEY_ALGORITHM = "RSA";
	public final static String CER_ALGORITHM = "MD5WithRSA";

	public final static String RSA_CHIPER = "RSA/ECB/PKCS1Padding";

	public final static int KEY_SIZE = 1024;
	/** 1024bit 加密块 大小 */
	public final static int ENCRYPT_KEYSIZE = 117;
	/** 1024bit 解密块 大小 */
	public final static int DECRYPT_KEYSIZE = 128;
}
