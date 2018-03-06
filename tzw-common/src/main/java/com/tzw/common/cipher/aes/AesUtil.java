package com.tzw.common.cipher.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author caocaiyun
 * @date 2018年1月21日 
 */
public class AesUtil {
	private static final String IV_STRING = "16-Bytes--String";

	public static String encryptAES(String content, String key) throws Exception {
		byte[] byteContent = content.getBytes("UTF-8");
		// 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
		byte[] enCodeFormat = key.getBytes();
		SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		// 指定加密的算法、工作模式和填充方式
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] encryptedBytes = cipher.doFinal(byteContent);
		return Base64.encodeBase64String(encryptedBytes);
	}

	public static String encryptAES2(String content) throws Exception {
		byte[] byteContent = content.getBytes("UTF-8");
		// 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		// 指定加密的算法、工作模式和填充方式
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] encryptedBytes = cipher.doFinal(byteContent);
		return Base64.encodeBase64String(encryptedBytes);
	}

	public static String decryptAES(String content, String key) throws Exception {
		// base64 解码
		byte[] encryptedBytes = Base64.decodeBase64(content);
		byte[] enCodeFormat = key.getBytes();
		SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] result = cipher.doFinal(encryptedBytes);
		return new String(result, "UTF-8");
	}

	public static String decryptAES2(String content) throws Exception {
		// base64 解码
		byte[] encryptedBytes = Base64.decodeBase64(content);

		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] result = cipher.doFinal(encryptedBytes);
		return new String(result, "UTF-8");
	}
}
