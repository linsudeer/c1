package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.exception.ExceptionEnum;
import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.bean.LoginBean;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "loginValil", method = RequestMethod.POST)
    public Tip loginValil(HttpServletRequest request, LoginBean bean) {
        String username = bean.getUsername();
        String password = bean.getPassword();
        if(StringUtils.isBlank(username)){
            return ResultTip.error(ExceptionEnum.LOGIN_NAME_NOT_NULL);
        }
        if(StringUtils.isBlank(password)){
            return ResultTip.error(ExceptionEnum.LOGIN_PASSWORD_NOT_NULL);
        }

        UserDTO user = userService.loginVail(username, password, bean.getDeptPid());
        if(user == null){
            return ResultTip.error(ExceptionEnum.LOGIN_FAIL);
        }
        if(StringUtils.isBlank(user.getDataRole())){// 没有数据权限
            return ResultTip.error(ExceptionEnum.NO_PERMITION);
        }
        // 保存Session
        HttpSession session = request.getSession();
        session.setAttribute(Constant.SESSION_USER, user);
        return ResultTip.success(user);
    }

    @RequestMapping(value = "checklogin", method = RequestMethod.GET)
    public Tip checklogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(Constant.SESSION_USER);
        if(user != null) {
            return ResultTip.success(user);
        }else {
            return ResultTip.success(false);
        }

    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public Tip logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return ResultTip.success();
    }
}
