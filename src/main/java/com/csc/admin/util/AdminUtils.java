package com.csc.admin.util;

public class AdminUtils {
	
	public static boolean isEmpty(String s) {
		return (s== null) || (s.length() == 0);
	}
	public static boolean isNotEmpty(String s) {
		return !isEmpty(s);
	}
	public static boolean isEmpty(Integer i) {
		return i == null;
	}
	public static boolean isNotEmpty(Integer i) {
		return i != null;
	}

}
