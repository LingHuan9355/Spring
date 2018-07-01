package com.hr.spring.struts2.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application Lifecycle Listener implementation class SpringServletContextListener
 *
 */
@WebListener
public class SpringServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SpringServletContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent contextEvent)  { 
    			//1.获取Spring 配置文件的名称	
    			ServletContext servletContext = contextEvent.getServletContext();
    			String config = servletContext.getInitParameter("configLocation");
    	
    			//1.创建 IOC容器
    			ApplicationContext context = new ClassPathXmlApplicationContext(config);		
    	
    			//2.把IOC容器放在ServletContext 的一个属性中。
    			servletContext.setAttribute("ApplicationContext", context);
    			
    }
	
}
