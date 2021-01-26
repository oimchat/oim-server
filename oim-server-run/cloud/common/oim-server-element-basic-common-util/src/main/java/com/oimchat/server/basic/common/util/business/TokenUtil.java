package com.oimchat.server.basic.common.util.business;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Date 2019-02-11 19:03:58<br>
 * Description
 * 
 * @author XiaHui<br>
 * @since 1.0.0
 */

public class TokenUtil {

	public static String getToken(String text) {
		try {
			byte id[] = text.getBytes();
			byte now[] = new Long(System.currentTimeMillis()).toString().getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(id);
			md.update(now);
			BigInteger a = new BigInteger(md.digest());
			return a.toString(16);
		} catch (IllegalStateException e) {
			return (text);
		} catch (NoSuchAlgorithmException e) {
			return (text);
		}
	}
}
