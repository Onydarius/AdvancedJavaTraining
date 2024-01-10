package com.nagarro.javaTraining.assigment2;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.nagarro.javaTraining.assigment2.dao.TshirtDao;
import com.nagarro.javaTraining.assigment2.model.TShirt;
import com.nagarro.javaTraining.assigment2.util.TShirtLoader;


public class App {
	private static final String CSV_LOCATION = System.getProperty("user.dir") + "/src/main/resources"; // Location of
	// the CSV files
	private static final int REFRESH_INTERVAL = 3; // Refresh interval in seconds



	public static void main(String[] args) {

		try {
			
			Scanner read = new Scanner(System.in);
			String input = "";

			//Initialize the T-shirtDao
			TshirtDao tshirtDao = new TshirtDao();
			
			// Initialize the T-shirt searcher
			TShirtLoader tShirtSearcher = new TShirtLoader();
			tShirtSearcher.initialize(CSV_LOCATION);
			
			// Schedule a task to check for new files periodically
			ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
			scheduler.scheduleAtFixedRate(() -> tShirtSearcher.checkForNewFiles(), 0, REFRESH_INTERVAL, TimeUnit.SECONDS);
			
			do {
				// Display menu
				System.out.println("================== T-Shirt searcher ==================");
				System.out.println("Color: ");
				String color = read.nextLine().toLowerCase();
				System.out.println("Size (S, M, L, XL, XXL): ");
				String size = read.nextLine().toLowerCase();
				System.out.println("Gender (F or M): ");
				String gender = read.nextLine().toLowerCase();
				System.out.println("Output Preference (Price, Rating, Price and Rating): ");
				String outputPreference = read.nextLine().toLowerCase();

				// Search for T-shirts based on user input
				List<TShirt> results = tshirtDao.searchByParameters(color, size, gender, outputPreference);
	
				if (results.size() == 0) {
					System.err.println("No suitable T-shirt found. Press any key to try again or N to exit.");
					input = read.nextLine().toLowerCase();
				} else {
					results.forEach(System.out::println);
					System.out.println("Press any key to search again or N to exit.");
	
					input = read.nextLine().toLowerCase();
	
				}
				// // Display the results

			} while (!input.equalsIgnoreCase("N"));

			// // Shutdown the scheduler when the program is done
			scheduler.shutdown();
			read.close();
			
		
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}
