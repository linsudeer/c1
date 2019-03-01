package com.czht.smartpark.tbweb.modular.service.impl;

import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dmo.User;
import com.czht.smartpark.tbweb.modular.service.MsgService;
import com.czht.smartpark.tbweb.modular.service.UserService;
import com.czht.smartpark.tbweb.modular.webservice.msg.Sms;
import com.czht.smartpark.tbweb.modular.webservice.msg.SmsServiceImplServiceLocator;
import com.czht.smartpark.tbweb.modular.webservice.msg.SmsServiceImplServiceSoapBindingStub;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {

    private Logger logger = LoggerFactory.getLogger(MsgServiceImpl.class);

    @Autowired
    private UserService userService;


    @Override
    public void sendMsg(Integer userId, String content) throws RuntimeException {
        if(userId == null) throw new RuntimeException("【短信】-发送短信给失败！原因：没有找到用户");;

        User user = userService.getById(userId);
        String mobile = user.getUserMobile();
        String username = user.getUserName();
        if(StringUtils.isBlank(mobile)){
            throw new RuntimeException("【短信】-发送短信给"+username+"失败！原因：手机号是空。");
        }

        Sms sms = new Sms();
        sms.setContent(content);
        sms.setMobile(mobile);
        sms.setSystemName(Constant.MSG_SYSNAME);
        SmsServiceImplServiceSoapBindingStub binding;
        try {
            binding = (SmsServiceImplServiceSoapBindingStub) new SmsServiceImplServiceLocator().getSmsServiceImplPort();
            binding.sendSms(sms);
        }
        catch (Exception jre) {
            throw new RuntimeException("【短信】-发送短信给"+username+"失败！原因："+jre.getMessage());
        }
    }
}
