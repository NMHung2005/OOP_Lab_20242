package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) throws Exception {
		String filename = "text.txt";
		byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

		long startTime = System.currentTimeMillis();

		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outputStringBuilder.append((char) b);
		}

		String outputString = outputStringBuilder.toString();

		long endTime = System.currentTimeMillis();
		System.out.println("Execution time (StringBuilder): " + (endTime - startTime) + " ms");
	}
}
