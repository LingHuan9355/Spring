package com.hr.spring.struts2.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.hr.spring.struts2.beans.Person;

/**
 * 
 * @Name  : TestServlet
 * @Author : LH
 * @Date : 2018年7月1日 下午4:25:28
 * @Version : V1.0
 * 
 * @Description :
 */
public class TestServlet extends HttpServlet {

			private static final long serialVersionUID = 1L;

				
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					//1. 从application 域对象中得到 IOC容器的引用	
					ServletContext servletContext = getServletContext();
					ApplicationContext context = (ApplicationContext) servletContext.getAttribute("ApplicationContext");
					
				  //2.从IOC容器中得到需要的bean
					Person person = context.getBean(Person.class);
					person.hello();
			}
			
	
}
