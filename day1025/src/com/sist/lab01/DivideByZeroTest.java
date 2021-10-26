package com.sist.lab01;

import java.util.Scanner;

public class DivideByZeroTest {

	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("ù ��° ����: ");
			number1 = sc.nextInt();
			System.out.print("�� ��° ����: ");
			number2 = sc.nextInt();
			
			result = number1 / number2;
			System.out.println(result);
		}catch(ArithmeticException a) {
			System.out.println(a.getMessage());
			a.printStackTrace();
			System.out.println("0���δ� ���� �� �����ϴ�, �ι�° ������ 0�� �ƴ� ���� �Է����ּ���.");
		}catch(Exception e) {
			System.out.println("�� �� ��� ������ �Է����ּ���");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("������ �����");
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
