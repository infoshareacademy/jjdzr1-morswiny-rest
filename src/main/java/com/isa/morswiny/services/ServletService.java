package com.isa.morswiny.services;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ServletService {
    private static final String ADMIN_EMAIL ="admin@morswiny.pl";


    public static void sessionValidation(HttpServletRequest req, Map<String, Object> map) {
        if (req.getSession(false) != null && req.getSession(false).getAttribute("logged") != null){
            if (req.getSession().getAttribute("logged").toString().equals(ADMIN_EMAIL)){
                map.put("admin", req.getSession().getAttribute("logged"));
            }
            map.put("logged", req.getSession().getAttribute("logged"));
        }
    }
}
