package com.czht.smartpark.tbweb.modular.controller;

import com.czht.smartpark.tbweb.context.exception.ExceptionEnum;
import com.czht.smartpark.tbweb.context.exception.ExceptionUtil;
import com.czht.smartpark.tbweb.context.tip.ResultTip;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import com.czht.smartpark.tbweb.modular.service.UserService;
import org.apache.commons.lang3.StringUtils;
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

    @RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
    public Tip modifyPassword(HttpServletRequest request, String newPwd, String oldPwd){
        if(StringUtils.isBlank(newPwd) || StringUtils.isBlank(oldPwd)) return ResultTip.error(ExceptionEnum.PARAMS_ERROR);

        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute(Constant.SESSION_USER);
        Long userId = Long.valueOf(user.getUserId());
        //校验原密码
        boolean ok = userService.checkOldPwd(userId, oldPwd);
        if(ok){
            userService.modifyPwd(userId, newPwd);
        }else {
            return ResultTip.error(ExceptionEnum.OLD_PWD_NOT_RIGHT);
        }
        return ResultTip.success("密码修改成功，再次登录将使用新密码!");
    }
}
