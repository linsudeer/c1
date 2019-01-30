package com.czht.smartpark.tbweb.context.filter;

import com.czht.smartpark.tbweb.modular.constant.AuthProperties;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 对 request过滤
 */
public class RequestFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(RequestFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("========== init RequestFilter============");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 这里对权限进行控制，控制不同权限可以看到的数据
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpSession session = servletRequest.getSession();
        UserDTO user = (UserDTO) session.getAttribute(Constant.SESSION_USER);
        if(user != null){
            String role = user.getDataRole();
            if(AuthProperties.ROLE_ADMIN.equals(role)){
                request.setAttribute("deptPid", 0);
            }else if(AuthProperties.ROLE_SENIOR.equals(role)){
                request.setAttribute("deptPid", user.getDeptPid());
            }else if(AuthProperties.ROLE_VIEW.equals(role)){
                request.setAttribute("deptPid", user.getDeptPid());
            }else {
                request.setAttribute("deptId", user.getDeptId());
                request.setAttribute("deptPid", user.getDeptPid());
            }

        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("========== destroy RequestFilter============");
    }
}
