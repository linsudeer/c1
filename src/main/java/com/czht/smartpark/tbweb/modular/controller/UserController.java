package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取当前登陆用户
     * @return
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Tip getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(Constant.SESSION_USER);
        return ResultTip.success(user);
    }

    @RequestMapping("/simple/{userId}")
    public Tip getSimpleUserInfo(@PathVariable("userId") Integer userId){
        UserDTO user = userService.getSimpleUserInfo(userId);
        return ResultTip.success(user);
    }
}
