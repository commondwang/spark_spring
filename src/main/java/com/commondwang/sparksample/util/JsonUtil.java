package com.commondwang.sparksample.util;

import com.google.gson.Gson;

public class JsonUtil {

	private static Gson gson = new Gson();

	public static String toString(Object object) {
		return gson.toJson(object);
	}

}
