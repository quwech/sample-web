package com.qwc.sample.web.launch;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 服务器启动初始类
 *
 * @author GeekQWC
 */
@Log4j2
public class StartUp implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("主程序启动！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("主程序停止！");
    }
}
