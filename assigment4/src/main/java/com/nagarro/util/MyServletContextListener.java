package com.nagarro.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.core.io.ClassPathResource;

public class MyServletContextListener implements ServletContextListener {

  @Override
  public void contextDestroyed(ServletContextEvent arg0) {
    //Notification that the servlet context is about to be shut down.   
  }

  @Override
  public void contextInitialized(ServletContextEvent arg0) {
    // do all the tasks that you need to perform just after the server starts


		 String CSV_LOCATION =  "C:\\Users\\Ricardo\\Downloads\\springmvc\\src\\main\\resources"; // Location of
		 int REFRESH_INTERVAL = 3; // Refresh interval in seconds

		// Initialize the T-shirt searcher
		TShirtLoader tShirtSearcher = new TShirtLoader();
		tShirtSearcher.initialize(CSV_LOCATION);
		
		// Schedule a task to check for new files periodically
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(() -> tShirtSearcher.checkForNewFiles(), 0, REFRESH_INTERVAL, TimeUnit.SECONDS);
		
  }

}