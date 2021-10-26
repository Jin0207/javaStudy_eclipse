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
		System.out.printf("평균: %.2f", avg);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		try {
			for(int i=0; i < arr.length; i++) {
				System.out.print(i+1 + "번째 정수값을 입력하세요 ->");
				arr[i] = sc.nextInt();
				averageOfArray(arr);
			}
		}catch(InputMismatchException i) {
			System.out.println("정수값을 입력하세요.");
		}catch(NegativeArraySizeException n) {
			System.out.println("배열의 크기는 양수입니다.");
		}catch(ArithmeticException n) {
			System.out.println("0으로는 나눌 수 없습니다.");
		}catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("인덱스범위를 초과하였습니다. 인덱스의 범위는 0~9까지 입니다.");
		}
		
		
	}

}
