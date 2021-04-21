package c_advanced;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
Create a CSV file and write Time Stamp (seconds)
*/

public class CsvWriter {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String pathToCsv = "src/c_advanced/my_csv.csv";
		
		String name = "Component 1";
		writeTimestamp(pathToCsv, name);
		
		TimeUnit.SECONDS.sleep(1);
		
		name = "Component 2";
		writeTimestamp(pathToCsv, name);
	}

	private static void writeTimestamp(String pathToCsv, String name) throws IOException {
		
		File csvFile = new File(pathToCsv);
		if (!csvFile.isFile()) {
			System.out.println("Creating " + pathToCsv);
			
			FileWriter writer = new FileWriter(pathToCsv); // Creating a new CSV file
			writer.append("Name");
			writer.append(",");
			writer.append("Time Stamp (Sec)");
			writer.append("\n");
			writer.flush();
			writer.close();			
		}
		
		System.out.println("Writing " + pathToCsv);
		FileWriter writer = new FileWriter(pathToCsv, true); // appending to existing CSV file
		writer.append(name);
		writer.append(",");
		long timestamp = System.currentTimeMillis() / 1000; // Time stamp in seconds
		writer.append(Long.toString(timestamp));
		writer.append("\n");
		writer.flush();
		writer.close();
	}

}
