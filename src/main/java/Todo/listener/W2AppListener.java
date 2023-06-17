package Todo.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Log4j2
public class W2AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("----------------init----------------");
        log.info("----------------init----------------");
        log.info("----------------init----------------");
        log.info("----------------init----------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("----------------destroy----------------");
        log.info("----------------destroy----------------");
        log.info("----------------destroy----------------");
        log.info("----------------destroy----------------");
    }
}
