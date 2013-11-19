package com.weakie.global;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
public final class Listener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener() {
    	System.out.println("listener new ");
    }

	public void contextDestroyed(ServletContextEvent arg0) {
		String name = arg0.getServletContext().getServletContextName();
		System.out.println("destroy "+name);
		Initialize instance = Initialize.getInstance();
		try {
			instance.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		String name = arg0.getServletContext().getServletContextName();
		System.out.println("initial "+name);
		Initialize instance = Initialize.getInstance();
		instance.setListenPort(10230);
		try {
			instance.startup();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
