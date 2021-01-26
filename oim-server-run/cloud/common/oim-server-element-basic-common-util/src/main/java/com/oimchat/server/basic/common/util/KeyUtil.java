/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oimchat.server.basic.common.util;

import java.util.UUID;

/**
 * 
 * @author XiaHui
 */
public class KeyUtil {

	public static String getKey() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static long getNanosecond() {
		return System.nanoTime();
	}
}
