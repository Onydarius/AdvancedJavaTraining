package com.nagarro.javaTraining.TShirtSearcher;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
	private static final String CSV_LOCATION = System.getProperty("user.dir") + "/src/main/resources"; // Location of
																										// the CSV files
	private static final int REFRESH_INTERVAL = 3; // Refresh interval in seconds

	public static void main(String[] args) throws IOException {
		Scanner read = new Scanner(System.in);
		String input = "";

		
		// Initialize the T-shirt searcher
		TShirtSearcher tShirtSearcher = new TShirtSearcher();
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
			List<TShirt> results = tShirtSearcher.searchTShirts(color, size, gender, outputPreference);

			if(results.size() == 0) {
				System.err.println("No suitable T-shirt found. Press ENTER to try again or N to exit.");
				input = read.nextLine().toLowerCase();
			}else {
				results.forEach(System.out::println);
				System.out.println("Press ENTER to search again or N to exit.");

				input = read.nextLine().toLowerCase();

			}
			// // Display the results

		} while (!input.equalsIgnoreCase("N"));
		
		// // Shutdown the scheduler when the program is done
		scheduler.shutdown();
		read.close();

	}

}
