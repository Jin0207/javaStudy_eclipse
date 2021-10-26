package com.sist.lab01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
				
		try {
			
			int number1, number2, result;
			Scanner sc = new Scanner(System.in);
			
			System.out.print("첫 번째 정수: ");
			number1 = sc.nextInt();
			
			System.out.print("두 번째 정수: ");
			number2 = sc.nextInt();
			
			result = number1 / number2;
			System.out.println(result);
			
		}catch(ArithmeticException e) {
			System.out.println("예외발생: " + e.getMessage());
			e.printStackTrace();			
		}catch(InputMismatchException e) {
			System.out.println("예외발생: " + e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("작업완료");
		}
		
		/*
		 * 1-1 : 4
		 * 1-2 : Exception in thread "main" java.util.InputMismatchException
		 * 1-3 : Exception in thread "main" java.lang.ArithmeticException: / by zero
		 * 4.
		 * null
		 * java.util.InputMismatchException
		 */
	}

}
