package studio8;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.
public class CountSteps {

	public static void main(String[] args) {
		String fileName = "data/practice.csv";
		File file = new File(fileName);
		ArrayList<String> zValues = new ArrayList();
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String z = data.split(",", 0)[2];
				// System.out.println(data);
				// System.out.println(z);
				zValues.add(z);
			}
			// System.out.println(zValues);
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i < zValues.size() - 1; i++) {
			if ((Double.parseDouble(zValues.get(i)) > Double.parseDouble(zValues.get(i - 1)))
					&& (Double.parseDouble(zValues.get(i)) > Double.parseDouble(zValues.get(i + 1)))
					&& Double.parseDouble(zValues.get(i)) > 1.0) {
				System.out.println(zValues.get(i));
			}
		}
	}
}