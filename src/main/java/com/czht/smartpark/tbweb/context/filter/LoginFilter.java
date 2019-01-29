package com.czht.smartpark.tbweb.context.filter;

import com.czht.smartpark.tbweb.context.exception.ExceptionEnum;
import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆过滤器(和登陆拦截器使用一个就行)
 */

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest)request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        // 这里判断不过滤路径
        StringBuffer url = servletRequest.getRequestURL();
        if(url.indexOf("static") > 0){// 不过滤
            chain.doFilter(request, response);
        }else {
            HttpSession session = servletRequest.getSession();
            UserDTO user = (UserDTO) session.getAttribute(Constant.SESSION_USER);
            if(user == null ){
                servletResponse.getWriter().write(com.alibaba.fastjson.JSONObject.toJSONString(ResultTip.error(ExceptionEnum.NO_LOGIN)));
            }else {
                chain.doFilter(request, response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
