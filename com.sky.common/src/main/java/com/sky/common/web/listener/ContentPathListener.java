package com.sky.common.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContentPathListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		ServletContext ctx = contextEvent.getServletContext();
		ctx.setAttribute("home", ctx.getContextPath());

	}

}
