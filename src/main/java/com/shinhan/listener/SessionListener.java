package com.shinhan.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.shinhan.vo.AdminVO;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    int total_user;
    public SessionListener() {
        System.out.println("SessionListener생성");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	 total_user++;
         System.out.println(total_user + "번째 Browser가 이 서버에 접속되었음!!!!");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 System.out.println("Browser가 이 서버에 접속해제되었음!!!!");
    	 total_user--;
    	 
    	 HttpSession httpSession = se.getSession();
    	 ServletContext app = httpSession.getServletContext();
 		Object obj = app.getAttribute("userList");
 		AdminVO admin;
 		admin = (AdminVO)httpSession.getAttribute("loginUser"); 
 		System.out.println("onClose AdminVO:" + admin);
 		
 		List<AdminVO> userList = null;
 		if(obj !=null) {
 			userList = (List<AdminVO>)obj;
 			userList.remove(admin);
 			app.setAttribute("userList", userList);
 			System.out.println("onClose:" + userList);
 		}
 		httpSession.invalidate(); 
 		
    }
	
}
