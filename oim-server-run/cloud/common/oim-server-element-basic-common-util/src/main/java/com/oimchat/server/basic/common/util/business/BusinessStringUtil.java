package com.oimchat.server.basic.common.util.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description <br>
 * Date 2019-04-27 09:36:13<br>
 * 
 * @author XiaHui [onlovexiahui@qq.com]<br>
 * @since 1.0.0
 */

public class BusinessStringUtil {

	// ^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$
	// 百度的正则
	public static final String REGEX_MOBILE = "^1[3456789]\\d{9}$";
	// ^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$
	// ^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$
	// 百度的正则
	public static final String REGEX_EMAIL = "^([a-zA-Z0-9_\\.\\-\\+])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
	public static final String[] ACCOUNT_NOT_ARRAY = {};
	public static final String ACCOUNT_NOT_SYMBOL = "@";

	// ^(?!_)(?!.*?_$)[a-zA-Z0-9_\\\\u4e00-\\\\u9fa5]+$
	// ^[\\u4E00-\\u9FA5|a-zA-Z][\\w\\u4E00-\\u9FA5|0-9a-zA-Z]*$
	// 百度的正则
	// ^(([a-zA-Z0-9_\\.\\-\\+])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+)|(1[3456789]\\d{9})$

	public static final String REGEX_ACCOUNT = "^[\\u4E00-\\u9FA5|a-zA-Z][\\w\\u4E00-\\u9FA5|0-9a-zA-Z]*$";
	public static final String PROMPT_ACCOUNT = "用户名仅支持中英文、数字和下划线,且不能为纯数字";
	// ^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$
	// 百度的正则
	public static final String REGEX_PASSWORD = "^([0-9a-zA-Z\\_`!~@#$%^*+=,.?;'\":)(}{/\\\\\\|<>&\\[\\-]|\\])+$";
	public static final String PROMPT_PASSWORD_SIZE = "密码必须由8-14个字符组成";
	public static final String PROMPT_PASSWORD_SYMBOL = "密码仅支持数字,字母和符号,且密码中不能含有空格";
	public static final String PROMPT_PASSWORD_SMPLE = "密码过于简单,建议使用数字加字母组合,否则无法注册成功";
	// 百度的正则
	public static final String REGEX_ID = "(^\\d{15}$)|(^\\d{17}(\\d|X|x)$)";

	public static boolean isMobile(String text) {
		return match(REGEX_MOBILE, text);
	}

	public static boolean isEmail(String text) {
		return match(REGEX_EMAIL, text);
	}

	public static boolean isAccount(String text) {
		String number = "^[0-9]*$";
		String account = "^[\\u4E00-\\u9FA5-_A-Za-z0-9]+$";
		return !match(number, text) && match(account, text);
	}

	public static boolean isPassword(String text) {
		return match(REGEX_PASSWORD, text);
	}

	public static boolean match(String regex, String text) {
		text = (null == text) ? "" : text;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		return matcher.matches();
	}
}
