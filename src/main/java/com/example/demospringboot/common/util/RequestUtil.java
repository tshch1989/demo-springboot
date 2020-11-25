package com.example.demospringboot.common.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    public static boolean isAjax(HttpServletRequest request){
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
