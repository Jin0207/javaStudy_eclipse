package com.sist.lab03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayExceptionTest {
	public static void averageOfArray(int[] arr) {
		int sum = 0;
		double avg;
		
		for(int n : arr) {
			sum += n;
		}
		avg = (double)sum / arr.length;
		System.out.printf("���: %.2f", avg);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		try {
			for(int i=0; i < arr.length; i++) {
				System.out.print(i+1 + "��° �������� �Է��ϼ��� ->");
				arr[i] = sc.nextInt();
				averageOfArray(arr);
			}
		}catch(InputMismatchException i) {
			System.out.println("�������� �Է��ϼ���.");
		}catch(NegativeArraySizeException n) {
			System.out.println("�迭�� ũ��� ����Դϴ�.");
		}catch(ArithmeticException n) {
			System.out.println("0���δ� ���� �� �����ϴ�.");
		}catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("�ε��������� �ʰ��Ͽ����ϴ�. �ε����� ������ 0~9���� �Դϴ�.");
		}
		
		
	}

}
