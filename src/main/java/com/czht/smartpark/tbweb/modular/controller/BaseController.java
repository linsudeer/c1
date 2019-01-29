package com.czht.smartpark.tbweb.modular.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    @ModelAttribute
    public void common(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("deptPid", 1);
    }
}
