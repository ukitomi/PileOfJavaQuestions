package ProblemGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class ProblemGenerator {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("Problems.txt");
		BufferedReader r = new BufferedReader(new InputStreamReader(file)); 
		ArrayList<String> array = new ArrayList<String>();
		String line;
		while ((line = r.readLine()) != null) {
			array.add(line);
		}
		
		Random rand = new Random();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(array.get(rand.nextInt(array.size())));
		}
	}
}
