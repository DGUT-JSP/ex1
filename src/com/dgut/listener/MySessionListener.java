package com.dgut.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听session的销毁
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

	
	/**
	 * session销毁时 将session从对应的list移除
	 * 如果list为空，则ip离线，将其从ipMap移除
	 */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//获取被销毁的session
    	HttpSession currentSession = se.getSession();
    	//获取servletContext对象
    	ServletContext sc = currentSession.getServletContext();
    	//获取ipMap
    	Map<String,List<HttpSession>> ipMap = (Map<String,List<HttpSession>>)sc.getAttribute("ipMap");
    	String ip = (String) currentSession.getAttribute("ip");
    	//根据ip找打map中相应的list
    	List<HttpSession> list = ipMap.get(ip);
    	//将待销毁的session从list中移除
    	list.remove(currentSession);
    	
    	if(list.isEmpty()){
    		ipMap.remove(ip);
    	}else{
    		ipMap.put(ip,list);
    	}
    	sc.setAttribute("ipMap", ipMap);
    }

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
