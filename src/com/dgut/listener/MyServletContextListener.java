package com.dgut.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

/**
 * 监听ServletContext的创建
 *
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {


	/**
     * ServletContext创建时初始化一个map
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	Map<String,List<HttpSession>> ipMap = new HashMap<>();
    	ServletContext sc = sce.getServletContext();
    	//将创建好的map对象放到ServletContext域中
    	sc.setAttribute("ipMap", ipMap);
    	
    	//map：key存放用户名，value存放用户信息
    	Map<String,HttpSession> userMap = new HashMap<>();
    	sc.setAttribute("userMap", userMap);
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
