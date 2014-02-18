import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import au.com.bytecode.opencsv.CSVReader;

public class TestCSV extends TestCase {

	@Test
	public void testCSVReader() throws IOException {
		String csvFileToRead = "csvFiles/shareData.csv";

		CSVReader reader = new CSVReader(new FileReader(csvFileToRead));

		String[] nextLine;

		int lineNumber = 0;

		while ((nextLine = reader.readNext()) != null) {

			lineNumber++;

			if (lineNumber == 10) {
				System.out.println("Line # " + lineNumber);
				System.out.println("Value at 11th Col : " + nextLine[10]);
				assertEquals("91", nextLine[10]);
		
			}

		}

	}
}
