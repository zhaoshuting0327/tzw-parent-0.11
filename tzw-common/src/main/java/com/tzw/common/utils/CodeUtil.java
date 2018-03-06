package com.tzw.common.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 验证码生成
 * 
 * @author Administrator
 *
 */
public class CodeUtil {

	// 测试随机生成4位数验证码
	private static int CODE_LENGTH = 4;

	public static String getCode() {
		String random = "";
		while (true) {
			random = (Math.random() * 10000) + "";
			if (!StringUtils.isEmpty(random) && random.contains(".")) {
				String[] randoms = random.split("\\.");
				random = randoms[0];
			}
			if (random.length() >= CODE_LENGTH) {
				break;
			}
		}
		return random;
	}

}
