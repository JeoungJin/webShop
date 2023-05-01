package com.shinhan.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

/**
 * Application Lifecycle Listener implementation class CC
 *
 */
@WebListener
public class CC implements HttpSessionIdListener {

    /**
     * Default constructor. 
     */
    public CC() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionIdListener#sessionIdChanged(HttpSessionEvent, String)
     */
    public void sessionIdChanged(HttpSessionEvent arg0, String arg1)  { 
         System.out.println("sessionIdChanged");
    }
	
}
