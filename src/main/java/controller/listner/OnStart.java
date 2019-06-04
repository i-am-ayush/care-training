package controller.listner;

import dao.DatabaseConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OnStart implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("aagyaaagya");
        DatabaseConnector.getConnection();


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
