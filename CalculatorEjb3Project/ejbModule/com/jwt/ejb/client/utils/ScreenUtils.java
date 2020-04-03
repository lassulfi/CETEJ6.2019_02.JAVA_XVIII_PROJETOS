package com.jwt.ejb.client.utils;

import java.util.Scanner;

public class ScreenUtils {

	private static Scanner in = new Scanner(System.in);
	
	public static Double readNumber(String message) throws NumberFormatException {
		System.out.print(message);
		
		Double number = 0.0;
		try {
			number = in.nextDouble();			
		} catch (Exception e) {
			throw new NumberFormatException("Erro ao ler número.");
		}
		
		return number;
	}
	
	public static void displayResult(String message, Double value) {
		System.out.println(message + ": " + value);
	}
	
	public static void closeScanner() {
		in.close();
	}
}
