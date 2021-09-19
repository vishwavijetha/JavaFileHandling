package filehandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextFileDemo {

	public static void main(String[] args) throws Exception {

		// Create File
		String path = "src/test/resources/textfile.txt";
		File file = new File(path);
		if (file.createNewFile()) {
			System.out.println("File created: " + file.getName());
		} else {
			System.out.println("File already exists.");
		}

		// File exists
		System.out.println(file.exists());

		// Write
		FileWriter myWriter = new FileWriter(path);
		myWriter.write("Files in Java might be tricky, \n\nbut it is fun enough!");
		myWriter.close();

		// Read
		FileReader myReader = new FileReader(path);
		int character = 0;
		while ((character = myReader.read()) != -1) {
			System.out.print((char) character);
		}
		myReader.close();

		// Read using Files class
		System.out.println(Files.readAllLines(Paths.get(path)));
		
		// Read using Scanner
		Scanner	scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();
		
		// System.out.println(file.length());
		// file.delete();

	}

}
