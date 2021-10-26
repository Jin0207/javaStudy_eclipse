package com.sist.lab01;

import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("첫 번째 정수: ");
			number1 = sc.nextInt();
			System.out.print("두 번째 정수: ");
			number2 = sc.nextInt();
			
			result = number1 / number2;
			System.out.println(result);
		}catch(ArithmeticException a) {
			System.out.println(a.getMessage());
			a.printStackTrace();
			System.out.println("0으로는 나눌 수 없습니다, 두번째 정수를 0이 아닌 값을 입력해주세요.");
		}catch(Exception e) {
			System.out.println("두 수 모두 정수를 입력해주세요");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("무조건 실행됨");
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
