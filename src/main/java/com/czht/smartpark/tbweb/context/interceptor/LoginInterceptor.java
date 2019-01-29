package com.czht.smartpark.tbweb.context.interceptor;

import com.czht.smartpark.tbweb.context.exception.ExceptionEnum;
import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(Constant.SESSION_USER);
        if(user == null){
            response.getWriter().write(com.alibaba.fastjson.JSONObject.toJSONString(ResultTip.error(ExceptionEnum.NO_LOGIN)));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
