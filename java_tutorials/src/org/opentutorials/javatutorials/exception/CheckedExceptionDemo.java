package org.opentutorials.javatutorials.exception;
import java.io.*;

public class CheckedExceptionDemo {

	public static void main(String[] args) {
		BufferedReader breader = null;
		String input = null;
		try {
			breader = new BufferedReader(new FileReader("out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			input = breader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(input);
	}

}
