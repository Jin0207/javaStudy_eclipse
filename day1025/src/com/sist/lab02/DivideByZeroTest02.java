package com.sist.lab02;

import java.util.Scanner;

public class DivideByZeroTest02 {
	public static int quotient(int numerator, int denominator) throws DivideByZeroException{
		if(denominator == 0) {
			throw new DivideByZeroException("0���δ� ���� �� �����ϴ�, �ι�° ������ 0�� �ƴ� ���� �Է����ּ���.");
		}
		return numerator / denominator;
		
	}

	public static void main(String[] args) {
		int number1, number2, result;
		
		Scanner sc = new Scanner(System.in);
	
		
		try {
			System.out.print("ù ��° ����: ");
			number1 = sc.nextInt();
			System.out.print("�� ��° ����: ");
			number2 = sc.nextInt();
			result = quotient(number1, number2);
			System.out.println(result);
		}catch(DivideByZeroException d) {
			System.out.println("���ܹ߻�: " + d.getMessage());
		}catch(Exception i) {
			System.out.println("�������� �ΰ��� ���� ���� �Է��ϼ���");
		}

	}

}
