package com.czht.smartpark.tbweb.context.listener;

import com.czht.smartpark.tbweb.modular.service.CodeService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    private CodeService codeService;


    @Override
    public void contextInitialized(ServletContextEvent sce) {


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
