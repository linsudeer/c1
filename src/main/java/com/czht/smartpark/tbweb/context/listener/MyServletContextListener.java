package com.czht.smartpark.tbweb.context.listener;

import com.czht.smartpark.tbweb.context.support.SpringContextHolder;
import com.czht.smartpark.tbweb.modular.asyntask.TaskFactory;
import com.czht.smartpark.tbweb.modular.asyntask.TaskManager;
import com.czht.smartpark.tbweb.modular.constant.SysConfigEnum;
import com.czht.smartpark.tbweb.modular.dmo.SysConfig;
import com.czht.smartpark.tbweb.modular.mapper.SysConfigMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class MyServletContextListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("容器初始化......");
        SysConfigMapper configMapper = SpringContextHolder.getBean(SysConfigMapper.class);
        //加载系统配置文件
        List<SysConfig> sysConfigs = configMapper.getConfigsByNames(new String[]{"fdfs_client", "zmq_pass", "tb_oa"});
        setSysConfigsConstant(sysConfigs);

        // 执行通行记录异步任务
        TaskManager.getInstance().excute(TaskFactory.zmqPassTask());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("容器销毁......");
    }

    /**
     * 添加系统配置到枚举常量
     * @param sysConfigs
     */
    private void setSysConfigsConstant(List<SysConfig> sysConfigs){
        if(sysConfigs != null && sysConfigs.size()>0){
            for(SysConfig config : sysConfigs){
                logger.info("【系统配置】-[名称："+config.getConfigName()+"，值："+config.getValue()+"]");
                String configName =config.getConfigName();
                String configValue = config.getValue();
                if(SysConfigEnum.FDFS_CONNECT_TIMEOUT.getName().equals(configName)){
                    SysConfigEnum.FDFS_CONNECT_TIMEOUT.setValue(configValue);
                }else if(SysConfigEnum.FDFS_NETWORK_TIMEOUT.getName().equals(configName)){
                    SysConfigEnum.FDFS_NETWORK_TIMEOUT.setValue(configValue);
                }else if(SysConfigEnum.FDFS_CHARSET.getName().equals(configName)){
                    SysConfigEnum.FDFS_CHARSET.setValue(configValue);
                }else if(SysConfigEnum.FDFS_TRACKER_HTTP_PORT.getName().equals(configName)){
                    SysConfigEnum.FDFS_TRACKER_HTTP_PORT.setValue(configValue);
                }else if(SysConfigEnum.FDFS_ANTI_STEAL_TOKEN.getName().equals(configName)){
                    SysConfigEnum.FDFS_ANTI_STEAL_TOKEN.setValue(configValue);
                }else if(SysConfigEnum.FDFS_SECRET_KEY.getName().equals(configName)){
                    SysConfigEnum.FDFS_SECRET_KEY.setValue(configValue);
                }else if(SysConfigEnum.FDFS_TRACKER_SERVER.getName().equals(configName)){
                    SysConfigEnum.FDFS_TRACKER_SERVER.setValue(configValue);
                }else if(SysConfigEnum.ZMQ_PASS.getName().equals(configName)){
                    SysConfigEnum.ZMQ_PASS.setValue(configValue);
                }else if(SysConfigEnum.ZMQ_SITUATION.getName().equals(configName)){
                    SysConfigEnum.ZMQ_SITUATION.setValue(configValue);
                }else if(SysConfigEnum.THIRD_OA_SSO_URL.getName().equals(configName)){
                    SysConfigEnum.THIRD_OA_SSO_URL.setValue(configValue);
                }

            }
        }
    }
}
