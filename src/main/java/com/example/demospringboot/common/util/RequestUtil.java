package com.example.demospringboot.common.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public static boolean isResponseJson(HttpServletRequest request){
        return request.getRequestURI().endsWith(".json");
    }
}
