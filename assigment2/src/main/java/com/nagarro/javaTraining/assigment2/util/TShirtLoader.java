package com.nagarro.javaTraining.assigment2.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nagarro.javaTraining.assigment2.dao.TshirtDao;
import com.nagarro.javaTraining.assigment2.model.TShirt;

public class TShirtLoader {

	private String csvPath;
	private List<TShirt> tShirts;
	private List<String> files;
	TshirtDao tshirtDao;

	public void initialize(String csvLocation) {
		tShirts = new ArrayList<TShirt>();
		csvPath = csvLocation;
		files = new ArrayList<String>();
		tshirtDao = new TshirtDao();
		checkForNewFiles();
	}

	public Set<String> listFilesUsingJavaIO(String dir) {
		return Stream.of(new File(dir).listFiles())
				.filter(file -> !file.isDirectory() && file.getName().toLowerCase().endsWith(".csv")).map(File::getName)
				.collect(Collectors.toSet());
	}

	public void checkForNewFiles() {
		Set<String> filesInThePath = listFilesUsingJavaIO(csvPath);
		for (String file : filesInThePath) {
			if (!files.contains(file)) {
				try {
					Reader reader = new FileReader(csvPath + "/" + file);

					TShirtCsvReader.readTShirts(reader).forEach(s -> tshirtDao.saveStudent(s));
					files.add(file);

				} catch (FileNotFoundException e) {
					System.err.println("An error occurred while reading the file " + csvPath + "/" + file);
				}
			}

		}
	}

	public List<TShirt> searchTShirts(String color, String size, String gender, String outputPreference) {

		// Filter the list of T-shirts based on input parameters
		List<TShirt> filteredList = tShirts.stream()
				.filter(tShirt -> (color == null || color.isEmpty() || tShirt.getColour().equalsIgnoreCase(color))
						&& (size == null || size.isEmpty() || tShirt.getSize().equalsIgnoreCase(size))
						&& (gender == null || gender.isEmpty() || tShirt.getGender().equalsIgnoreCase(gender)))
				.collect(Collectors.toList());

		// Sort the results based on outputPreference
		if (outputPreference.equalsIgnoreCase("price")) {
			filteredList.sort((t1, t2) -> Double.compare(t1.getPrice(), t2.getPrice()));
		}

		if (outputPreference.equalsIgnoreCase("rating")) {
			filteredList.sort((t1, t2) -> Float.compare(t2.getRating(), t1.getRating()));
		}
		if (outputPreference.equalsIgnoreCase("Price and rating")) {
			filteredList.sort((t1, t2) -> {
				int ratingComparison = Float.compare(t2.getRating(), t1.getRating());
				return (ratingComparison != 0) ? ratingComparison : Double.compare(t1.getPrice(), t2.getPrice());
			});
		}

		return filteredList;
	}
}