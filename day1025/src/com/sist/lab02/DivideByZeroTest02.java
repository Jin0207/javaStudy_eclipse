package com.sist.lab02;

import java.util.Scanner;

public class DivideByZeroTest02 {
	public static int quotient(int numerator, int denominator) throws DivideByZeroException{
		if(denominator == 0) {
			throw new DivideByZeroException("0으로는 나눌 수 없습니다, 두번째 정수를 0이 아닌 값을 입력해주세요.");
		}
		return numerator / denominator;
		
	}

	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
	
		
		try {
			System.out.print("첫 번째 정수: ");
			number1 = sc.nextInt();
			System.out.print("두 번째 정수: ");
			number2 = sc.nextInt();
			result = quotient(number1, number2);
			System.out.println(result);
		}catch(DivideByZeroException d) {
			System.out.println("예외발생: " + d.getMessage());
		}catch(Exception i) {
			System.out.println("나누기할 두개의 정수 값을 입력하세요");
		}

	}

}
