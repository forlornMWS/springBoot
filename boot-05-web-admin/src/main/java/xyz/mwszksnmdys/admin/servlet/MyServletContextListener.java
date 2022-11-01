package xyz.mwszksnmdys.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      log.info("项目初始化{}", sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("项目销毁{}", sce);
    }
}
