package com.dgut.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 监听request的创建
 *
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {


    public void requestInitialized(ServletRequestEvent sre)  { 
    	
    	//获取request对象
    	HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();  
    	
    	//获取客户端ip地址
    	String ip = request.getRemoteAddr();
    	System.out.println(ip);
    	//获取ServletContext对象
    	ServletContext sc = sre.getServletContext();
    	Map<String,List<HttpSession>> ipMap = (Map<String,List<HttpSession>>)sc.getAttribute("ipMap");
    	
    	//将ip作为key去map获取相应value
    	List<HttpSession> list = ipMap.get(ip);
    	
    	if(list == null){
    		//第一次访问，创建一个list
    		list = new ArrayList<>();
    	}
    	
    	//获取当前session
    	HttpSession currentSession = request.getSession();
    	//遍历list若存在当前session则为同一回话的请求，无需处理
    	for(HttpSession s:list){
    		if(s == currentSession){
    			return;
    		}
    	}
    	//不满足的话，将新session放入list
    	list.add(currentSession);
    	//
    	ipMap.put(ip,list);
    	//
    	sc.setAttribute("ipMap", ipMap);
    	
    	//将ip地址放到session域中，方便session销毁时使用
    	currentSession.setAttribute("ip", ip);
    }

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
