package com.czht.smartpark.tbweb.modular.service;

/**
 * 发送短信
 */
public interface MsgService {

    /**
     * 根据用户ID 发送短信
     * @param userId
     */
    void sendMsg(Integer userId, String content) throws RuntimeException;
}
